package id.mhafizsir.quranannotation.dto;

import id.mhafizsir.quranannotation.dao.Label;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class LabelDto extends DateAuditDto {

  private UUID id;
  private String name;

  public LabelDto(Label label){

    this.id = label.getId();
    this.name = label.getName();
    this.setCreatedAt(label.getCreatedAt());
    this.setUpdatedAt(label.getUpdatedAt());
  }
}
