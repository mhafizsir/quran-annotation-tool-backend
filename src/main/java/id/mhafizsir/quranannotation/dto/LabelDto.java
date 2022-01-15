package id.mhafizsir.quranannotation.dto;

import id.mhafizsir.quranannotation.dao.Label;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class LabelDto {

  private UUID id;
  private String name;

  public LabelDto(Label label) {

    this.id = label.getId();
    this.name = label.getName();
  }
}
