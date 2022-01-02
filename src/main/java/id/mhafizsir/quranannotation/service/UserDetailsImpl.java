package id.mhafizsir.quranannotation.service;

import com.fasterxml.jackson.annotation.JsonIgnore;
import id.mhafizsir.quranannotation.dao.User;
import java.util.Collection;
import java.util.Collections;
import java.util.UUID;
import lombok.Data;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@Data
public class UserDetailsImpl implements UserDetails {

  private static final long serialVersionUID = 1L;

  private UUID id;
  private String username;
  private String email;
  @JsonIgnore
  private String password;
  private Collection<? extends GrantedAuthority> authorities;

  public UserDetailsImpl(UUID id, String username, String email, String password,
      Collection<? extends GrantedAuthority> authorities) {
    this.id = id;
    this.username = username;
    this.email = email;
    this.password = password;
    this.authorities = authorities;
  }

  public static UserDetailsImpl build(User user) {

    return new UserDetailsImpl(user.getId(), user.getUsername(), user.getEmail(),
        user.getPassword(), Collections.emptyList());
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    return Collections.emptyList();
  }

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }
}
