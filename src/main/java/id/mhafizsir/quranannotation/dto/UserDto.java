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
  private UserProfileDto userProfile;

  public UserDto(User owner) {

    this.id = owner.getId();
    this.username = owner.getUsername();
    this.email = owner.getEmail();
    this.userProfile = new UserProfileDto(owner.getUserProfile());

    this.setCreatedAt(owner.getCreatedAt());
    this.setUpdatedAt(owner.getUpdatedAt());
  }
}
