package id.mhafizsir.quranannotation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AddressDto extends DateAuditDto {

  private String firstAddress;
  private String secondAddress;
  private String latitude;
  private String longitude;
  private String zipcode;
  private String subDistrict;
  private String district;
  private String city;
  private String province;
  private String country;
}
