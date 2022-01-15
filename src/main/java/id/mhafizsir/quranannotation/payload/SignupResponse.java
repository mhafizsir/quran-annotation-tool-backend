package id.mhafizsir.quranannotation.payload;

import id.mhafizsir.quranannotation.dao.User;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class SignupResponse extends GeneralResponse {

  private UUID id;
  private String email;
  private String username;

  public SignupResponse(User user) {
    this.id = user.getId();
    this.email = user.getEmail();
    this.username = user.getUsername();
  }
}
