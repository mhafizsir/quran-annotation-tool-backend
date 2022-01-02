package id.mhafizsir.quranannotation.dao;

import java.time.OffsetDateTime;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;
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
@Table(name = "user_profiles")
public class UserProfile extends Address {

  @Id
  private UUID id;

  @Column(name = "phone", columnDefinition = "TEXT")
  private String phone;

  @Column(name = "identification_number", columnDefinition = "TEXT")
  private String identificationNumber;

  @Column(name = "tax_identification_number", columnDefinition = "TEXT")
  private String taxIdentificationNumber;

  @Column(name = "refresh_token")
  private String refreshToken;

  @Column(name = "refresh_token_expiry", columnDefinition = "TIMESTAMP WITH TIME ZONE")
  private OffsetDateTime refreshTokenExpiry;

  @Column(name = "venue_owner")
  private Boolean venueOwner;

  @MapsId
  @OneToOne
  @JoinColumn(name = "id")
  private User user;
}
