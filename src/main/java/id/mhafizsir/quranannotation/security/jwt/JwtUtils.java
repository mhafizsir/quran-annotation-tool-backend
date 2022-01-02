package id.mhafizsir.quranannotation.security.jwt;

import id.mhafizsir.quranannotation.service.UserDetailsImpl;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;
import java.util.Date;
import java.util.UUID;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class JwtUtils {

  @Value("${mhafizsir.security.jwtsecret}")
  private String jwtSecret;

  @Value("${mhafizsir.security.jwtrefreshexpirationsecond}")
  private Long jwtExpirationSecond;

  @Value("${mhafizsir.security.jwtrefreshexpirationsecond}")
  private Long jwtRefreshExpirationSecond;

  public String generateJwtToken(UserDetailsImpl userPrincipal) {
    return generateTokenFromUsername(userPrincipal.getUsername());
  }

  public String generateTokenFromUsername(String username) {
    return Jwts.builder().setSubject(username).setIssuedAt(new Date())
        .setExpiration(new Date((new Date()).getTime() + jwtExpirationSecond))
        .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
  }

  public String generateRefreshTokenFromUsername(UUID userId) {
    return Jwts.builder().setSubject(String.valueOf(userId)).setIssuedAt(new Date())
        .setExpiration(new Date((new Date()).getTime() + jwtRefreshExpirationSecond))
        .signWith(SignatureAlgorithm.HS512, jwtSecret).compact();
  }

  public String getSubjectFromJwtToken(String token) {
    var claims = Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(token).getBody();
    return claims.getSubject();
  }

  public boolean validateJwtToken(String authToken) {
    try {
      Jwts.parser().setSigningKey(jwtSecret).parseClaimsJws(authToken);
      return true;
    } catch (SignatureException e) {
      log.error("Invalid JWT signature: {}", e.getMessage());
    } catch (MalformedJwtException e) {
      log.error("Invalid JWT token: {}", e.getMessage());
    } catch (ExpiredJwtException e) {
      log.error("JWT token is expired: {}", e.getMessage());
    } catch (UnsupportedJwtException e) {
      log.error("JWT token is unsupported: {}", e.getMessage());
    } catch (IllegalArgumentException e) {
      log.error("JWT claims string is empty: {}", e.getMessage());
    }

    return false;
  }
}