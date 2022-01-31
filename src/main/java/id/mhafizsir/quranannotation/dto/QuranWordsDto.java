package id.mhafizsir.quranannotation.dto;

import id.mhafizsir.quranannotation.dao.Annotation;
import id.mhafizsir.quranannotation.dao.QuranWords;
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
  private String suraName;
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
  private LabelDto labelDto;

  public QuranWordsDto(QuranWords quranWords) {

    this.id = quranWords.getId();
    this.aya = quranWords.getAya();
    this.sura = quranWords.getSura();
    this.suraName = quranWords.getSuraName();
    this.position = quranWords.getPosition();
    this.verseKey = quranWords.getVerseKey();
    this.text = quranWords.getText();
    this.simple = quranWords.getSimple();
    this.page = quranWords.getPage();
    this.className = quranWords.getClassName();
    this.line = quranWords.getLine();
    this.code = quranWords.getCode();
    this.codeV3 = quranWords.getCodeV3();
    this.charType = quranWords.getCharType();
    this.translation = quranWords.getTranslation();
  }

  public QuranWordsDto(QuranWords quranWords, Annotation annotation) {

    this.id = quranWords.getId();
    this.aya = quranWords.getAya();
    this.sura = quranWords.getSura();
    this.suraName = quranWords.getSuraName();
    this.position = quranWords.getPosition();
    this.verseKey = quranWords.getVerseKey();
    this.text = quranWords.getText();
    this.simple = quranWords.getSimple();
    this.page = quranWords.getPage();
    this.className = quranWords.getClassName();
    this.line = quranWords.getLine();
    this.code = quranWords.getCode();
    this.codeV3 = quranWords.getCodeV3();
    this.charType = quranWords.getCharType();
    this.translation = quranWords.getTranslation();
    if (annotation != null) {
      this.labelDto = new LabelDto(annotation.getLabel());
    }
  }
}
