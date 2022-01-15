package id.mhafizsir.quranannotation.service;

import id.mhafizsir.quranannotation.dao.User;
import id.mhafizsir.quranannotation.dao.UserProfile;
import id.mhafizsir.quranannotation.payload.SigninRequest;
import id.mhafizsir.quranannotation.payload.SigninResponse;
import id.mhafizsir.quranannotation.payload.SignupRequest;
import id.mhafizsir.quranannotation.payload.SignupResponse;
import id.mhafizsir.quranannotation.payload.TokenRefreshRequest;
import id.mhafizsir.quranannotation.payload.TokenRefreshResponse;
import id.mhafizsir.quranannotation.repository.UserProfileRepository;
import id.mhafizsir.quranannotation.repository.UserRepository;
import id.mhafizsir.quranannotation.security.jwt.JwtUtils;
import id.mhafizsir.quranannotation.security.jwt.TokenRefreshException;
import io.jsonwebtoken.lang.Strings;
import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Slf4j
@Service
public class AuthServiceImpl implements AuthService {

  private final AuthenticationManager authenticationManager;
  private final JwtUtils jwtUtils;
  private final UserRepository userRepository;
  private final PasswordEncoder passwordEncoder;
  private final UserProfileRepository userProfileRepository;

  @Value("${mhafizsir.security.jwtrefreshexpirationsecond}")
  private Long refreshTokenExpirationSecond;

  public AuthServiceImpl(AuthenticationManager authenticationManager, JwtUtils jwtUtils,
      UserRepository userRepository, PasswordEncoder passwordEncoder,
      UserProfileRepository userProfileRepository) {
    this.authenticationManager = authenticationManager;
    this.jwtUtils = jwtUtils;
    this.userRepository = userRepository;
    this.passwordEncoder = passwordEncoder;
    this.userProfileRepository = userProfileRepository;
  }

  @Override
  @Transactional
  public SigninResponse signin(SigninRequest request) {

    log.info("### signin start ###");
    String username = request.getUsername();
    if (username.contains("@")) {
      var user = userRepository.findByUsernameOrEmail(username);
      if (user != null) {
        username = user.getUsername();
      }
    }
    Authentication authentication = authenticationManager.authenticate(
        new UsernamePasswordAuthenticationToken(username, request.getPassword()));
    SecurityContextHolder.getContext().setAuthentication(authentication);
    String jwt = jwtUtils.generateJwtToken((UserDetailsImpl) authentication.getPrincipal());
    UserDetailsImpl userDetails = (UserDetailsImpl) authentication.getPrincipal();
    var user = userRepository.findByUsernameOrEmail(userDetails.getEmail());
    if (user == null) {
      throw new UsernameNotFoundException("User Not Found with username: " + username);
    }
    log.info("### signin finish ###");
    SigninResponse response = SigninResponse.builder().type("Bearer").token(jwt).refreshToken(
            String.valueOf(createRefreshToken(user.getUserProfile()).getRefreshToken()))
        .email(userDetails.getEmail()).username(userDetails.getUsername()).build();
    return response;
  }

  @Override
  @Transactional
  public SignupResponse signup(SignupRequest request) {

    log.info("### signup start ###");

    if (Strings.hasText(request.getUsername()) && userRepository.existsByUsernameOrEmail(
        request.getUsername(), request.getUsername())) {
      return SignupResponse.builder().code("01")
          .message("Error: Username or Email is already taken!").build();
    }

    var now = OffsetDateTime.now();
    User user = new User(request.getUsername(), request.getEmail(),
        passwordEncoder.encode(request.getPassword()));
    user.setCreatedAt(now);
    var savedUser = userRepository.save(user);

    UserProfile userProfile = new UserProfile();
    userProfile.setRefreshTokenExpiry(now.plusSeconds(refreshTokenExpirationSecond));
    userProfile.setRefreshToken(jwtUtils.generateRefreshTokenFromUsername(user.getId()));
    userProfile.setUser(savedUser);
    userProfile.setCreatedAt(now);
    userProfileRepository.save(userProfile);

    log.info("### signup finish ###");
    return SignupResponse.builder().code("00").message("User registered successfully!").build();
  }

  @Override
  public TokenRefreshResponse refreshToken(TokenRefreshRequest request) {

    return userProfileRepository.findByRefreshToken(request.getRefreshToken())
        .map(this::verifyRefreshTokenExpiration).map(UserProfile::getUser).map((User user) -> {
          String token = jwtUtils.generateTokenFromUsername(user.getUsername());
          var refreshToken = createRefreshToken(user.getUserProfile()).getRefreshToken();
          TokenRefreshResponse response = TokenRefreshResponse.builder().code("00")
              .message("Refresh Token Success").accessToken(token)
              .refreshToken(refreshToken)
              .tokenType("Bearer ").build();
          return response;
        }).orElseThrow(() -> new TokenRefreshException(request.getRefreshToken(),
            "Refresh token is not in database!"));
  }

  private UserProfile createRefreshToken(UserProfile userProfile) {
    String refreshToken = jwtUtils.generateRefreshTokenFromUsername(userProfile.getUser().getId());
    userProfile.setRefreshToken(refreshToken);
    userProfile.setRefreshTokenExpiry(
        OffsetDateTime.now().plusSeconds(refreshTokenExpirationSecond));
    return userProfileRepository.save(userProfile);
  }

  private UserProfile verifyRefreshTokenExpiration(UserProfile userProfile) {
    if (!userProfile.getRefreshToken().equalsIgnoreCase("") && userProfile.getRefreshTokenExpiry()
        .isBefore(OffsetDateTime.now())) {
      deleteRefreshTokenByUserId(userProfile.getId());
      throw new TokenRefreshException(userProfile.getRefreshToken(),
          "Refresh token was expired. Please make a new signin request");
    }

    return userProfile;
  }

  @Transactional
  public void deleteRefreshTokenByUserId(UUID userId) {
    var userProfileOpt = userProfileRepository.findById(userId);
    userProfileOpt.ifPresent(userProfile -> {
      userProfile.setRefreshToken(null);
      userProfile.setRefreshTokenExpiry(null);
      userProfileRepository.save(userProfile);
    });
  }
}
