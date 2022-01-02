package id.mhafizsir.quranannotation.payload;

import javax.validation.constraints.NotBlank;
import lombok.Data;

@Data
public class TokenRefreshRequest {

  @NotBlank
  private String refreshToken;
}