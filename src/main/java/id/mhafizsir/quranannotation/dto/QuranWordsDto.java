package id.mhafizsir.quranannotation.dto;

import id.mhafizsir.quranannotation.payload.GeneralResponse;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

@Data
@SuperBuilder
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class QuranWordsDto extends GeneralResponse {

  private Integer id;
  private Integer aya;
  private Integer sura;
  private Integer position;
  private String verseKey;
  private String text;
  private String simple;
  private Integer page;
  private String className;
  private Integer line;
  private String code;
  private String codeV3;
  private String charType;
  private String translation;
}
