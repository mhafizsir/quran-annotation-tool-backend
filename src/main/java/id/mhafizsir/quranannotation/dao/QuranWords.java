package id.mhafizsir.quranannotation.dao;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "quran_words")
public class QuranWords {

  @Id
  @Column(updatable = false, insertable = false)
  private Integer id;
  @Column(updatable = false, insertable = false)
  private Integer aya;
  @Column(updatable = false, insertable = false)
  private Integer sura;
  @Column(updatable = false, insertable = false)
  private Integer position;
  @Column(name = "verse_key", updatable = false, insertable = false)
  private String verseKey;
  @Column(updatable = false, insertable = false)
  private String text;
  @Column(updatable = false, insertable = false)
  private String simple;
  @Column(updatable = false, insertable = false)
  private Integer page;
  @Column(name = "class_name", updatable = false, insertable = false)
  private String className;
  @Column(updatable = false, insertable = false)
  private Integer line;
  @Column(updatable = false, insertable = false)
  private String code;
  @Column(name = "code_v3", updatable = false, insertable = false)
  private String codeV3;
  @Column(name = "char_type", updatable = false, insertable = false)
  private String charType;
  @Column(name = "translation", updatable = false, insertable = false)
  private String translation;
}
