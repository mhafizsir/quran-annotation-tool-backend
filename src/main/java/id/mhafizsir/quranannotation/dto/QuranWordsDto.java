package id.mhafizsir.quranannotation.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class QuranWordsDto {

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
