package id.mhafizsir.quranannotation.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
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
@Table(name = "quran_words")
public class QuranWords {

  @Id
  private Integer id;
  private Integer aya;
  private Integer sura;
  private Integer position;
  @Column(name = "verse_key")
  private String verseKey;
  private String text;
  private String simple;
  private Integer page;
  @Column(name = "class_name")
  private String className;
  private Integer line;
  private String code;
  @Column(name = "code_v3")
  private String codeV3;
  @Column(name = "char_type")
  private String charType;
  @Column(name = "translation")
  private String translation;
  @Column(name = "sura_name")
  private String suraName;
}
