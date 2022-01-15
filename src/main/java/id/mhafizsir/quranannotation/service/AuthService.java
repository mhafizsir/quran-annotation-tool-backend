package id.mhafizsir.quranannotation.service;

import id.mhafizsir.quranannotation.payload.SigninRequest;
import id.mhafizsir.quranannotation.payload.SigninResponse;
import id.mhafizsir.quranannotation.payload.SignupRequest;
import id.mhafizsir.quranannotation.payload.SignupResponse;
import id.mhafizsir.quranannotation.payload.TokenRefreshRequest;
import id.mhafizsir.quranannotation.payload.TokenRefreshResponse;
import javax.validation.Valid;

public interface AuthService {

  SigninResponse signin(@Valid SigninRequest request);

  SignupResponse signup(SignupRequest request);

  TokenRefreshResponse refreshToken(TokenRefreshRequest request);
}
