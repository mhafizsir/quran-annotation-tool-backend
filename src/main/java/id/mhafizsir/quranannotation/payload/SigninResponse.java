package id.mhafizsir.quranannotation.payload;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class SigninResponse {

  private String type;
  private String token;
  private String refreshToken;
  private String username;
  private String email;
}
