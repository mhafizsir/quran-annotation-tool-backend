package id.mhafizsir.quranannotation.dto;

import id.mhafizsir.quranannotation.dao.User;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserDto extends DateAuditDto {

  private UUID id;
  private String username;
  private String email;

  public UserDto(User user) {

    this.id = user.getId();
    this.username = user.getUsername();
    this.email = user.getEmail();
    this.setCreatedAt(user.getCreatedAt());
    this.setUpdatedAt(user.getUpdatedAt());
  }
}
