package id.mhafizsir.quranannotation.controller;

import id.mhafizsir.quranannotation.payload.SigninRequest;
import id.mhafizsir.quranannotation.payload.SigninResponse;
import id.mhafizsir.quranannotation.payload.SignupRequest;
import id.mhafizsir.quranannotation.payload.SignupResponse;
import id.mhafizsir.quranannotation.payload.TokenRefreshRequest;
import id.mhafizsir.quranannotation.payload.TokenRefreshResponse;
import id.mhafizsir.quranannotation.service.AuthService;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

  private final AuthService authService;

  public AuthController(AuthService authService) {
    this.authService = authService;
  }

  @PostMapping("/signin")
  public ResponseEntity<SigninResponse> signin(@Valid @RequestBody SigninRequest request) {

    return ResponseEntity.ok(authService.signin(request));
  }

  @PostMapping("/signup")
  public ResponseEntity<SignupResponse> signup(@Valid @RequestBody SignupRequest request) {

    return ResponseEntity.ok(authService.signup(request));
  }

  @PostMapping("/refresh-token")
  public ResponseEntity<TokenRefreshResponse> refreshToken(
      @Valid @RequestBody TokenRefreshRequest request) {

    return ResponseEntity.ok(authService.refreshToken(request));
  }
}
