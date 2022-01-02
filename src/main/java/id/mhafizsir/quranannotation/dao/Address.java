package id.mhafizsir.quranannotation.dao;

import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public class Address extends DateAudit {

  @Column(name = "first_address")
  private String firstAddress;
  @Column(name = "second_address")
  private String secondAddress;
  private String latitude;
  private String longitude;
  private String zipcode;
  @Column(name = "sub_district")
  private String subDistrict;
  private String district;
  private String city;
  private String province;
  private String country;
}
