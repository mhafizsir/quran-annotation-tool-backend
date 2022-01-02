package id.mhafizsir.quranannotation.payload;

import id.mhafizsir.quranannotation.dao.User;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class SignupResponse {

  private UUID id;
  private String email;
  private String username;

  public SignupResponse(User user) {
    this.id = user.getId();
    this.email = user.getEmail();
    this.username = user.getUsername();
  }
}
