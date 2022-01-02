package id.mhafizsir.quranannotation.service;

import id.mhafizsir.quranannotation.payload.GeneralResponse;
import id.mhafizsir.quranannotation.payload.SigninRequest;
import id.mhafizsir.quranannotation.payload.SignupRequest;
import id.mhafizsir.quranannotation.payload.TokenRefreshRequest;
import javax.validation.Valid;
import org.springframework.http.ResponseEntity;

public interface AuthService {

  GeneralResponse signin(@Valid SigninRequest request);

  ResponseEntity<GeneralResponse> signup(SignupRequest request);

  ResponseEntity<GeneralResponse> refreshToken(TokenRefreshRequest request);
}
