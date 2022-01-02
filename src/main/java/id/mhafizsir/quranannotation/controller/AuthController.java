package id.mhafizsir.quranannotation.controller;

import id.mhafizsir.quranannotation.payload.GeneralResponse;
import id.mhafizsir.quranannotation.payload.SigninRequest;
import id.mhafizsir.quranannotation.payload.SignupRequest;
import id.mhafizsir.quranannotation.payload.TokenRefreshRequest;
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
  public ResponseEntity<GeneralResponse> signin(@Valid @RequestBody SigninRequest request) {

    return ResponseEntity.ok(authService.signin(request));
  }

  @PostMapping("/signup")
  public ResponseEntity<GeneralResponse> signup(@Valid @RequestBody SignupRequest request) {

    return authService.signup(request);
  }

  @PostMapping("/refresh-token")
  public ResponseEntity<GeneralResponse> refreshToken(
      @Valid @RequestBody TokenRefreshRequest request) {

    return authService.refreshToken(request);
  }
}
