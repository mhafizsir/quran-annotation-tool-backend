package id.mhafizsir.quranannotation.payload;

import lombok.Data;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
public class TokenRefreshResponse extends GeneralResponse {

  private String accessToken;
  private String refreshToken;
  private String tokenType = "Bearer";

  public TokenRefreshResponse(String accessToken, String refreshToken) {
    this.accessToken = accessToken;
    this.refreshToken = refreshToken;
  }
}
