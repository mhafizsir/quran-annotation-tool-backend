package id.mhafizsir.quranannotation.dao;

import java.util.UUID;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@Entity
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "users")
public class User extends DateAudit {

  @Id
  @GeneratedValue
  private UUID id;

  @NotBlank
  @Size(max = 20)
  @Column(unique = true)
  private String username;

  @Email
  @NotBlank
  @Size(max = 50)
  @Column(unique = true)
  private String email;

  @NotBlank
  @Size(max = 120)
  private String password;

  @OneToOne(mappedBy = "user", cascade = CascadeType.ALL)
  @PrimaryKeyJoinColumn
  private UserProfile userProfile;

  public User(String username, String email, String password) {

    this.username = username;
    this.email = email;
    this.password = password;
  }
}
