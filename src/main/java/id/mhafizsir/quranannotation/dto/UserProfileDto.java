package id.mhafizsir.quranannotation.dto;

import id.mhafizsir.quranannotation.dao.UserProfile;
import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class UserProfileDto extends AddressDto {

  private UUID id;
  private String phone;
  private String identificationNumber;
  private String taxIdentificationNumber;
  private String refreshToken;
  private OffsetDateTime refreshTokenExpiry;
  private Boolean venueOwner;

  public UserProfileDto(UserProfile userProfile) {
    this.id = userProfile.getId();
    this.phone = userProfile.getPhone();
    this.identificationNumber = userProfile.getIdentificationNumber();
    this.taxIdentificationNumber = userProfile.getTaxIdentificationNumber();
    this.venueOwner = userProfile.getVenueOwner();

    this.setCreatedAt(userProfile.getCreatedAt());
    this.setUpdatedAt(userProfile.getUpdatedAt());
    this.setFirstAddress(userProfile.getFirstAddress());
    this.setSecondAddress(userProfile.getSecondAddress());
    this.setLatitude(userProfile.getLatitude());
    this.setLongitude(userProfile.getLongitude());
    this.setZipcode(userProfile.getZipcode());
    this.setSubDistrict(userProfile.getSubDistrict());
    this.setDistrict(userProfile.getDistrict());
    this.setCity(userProfile.getCity());
    this.setProvince(userProfile.getProvince());
    this.setCountry(userProfile.getCountry());
  }
}
