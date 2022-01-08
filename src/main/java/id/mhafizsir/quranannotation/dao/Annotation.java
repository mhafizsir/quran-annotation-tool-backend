package id.mhafizsir.quranannotation.dao;

import java.util.UUID;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@Entity
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "annotations")
@EqualsAndHashCode(callSuper = true)
public class Annotation extends DateAudit {

  @Id
  @GeneratedValue
  private UUID id;

  @ManyToOne
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  @ManyToOne
  @JoinColumn(name = "label_id", nullable = false)
  private Label label;

  @ManyToOne
  @JoinColumn(name = "quran_words_id", nullable = false)
  private QuranWords quranWords;
}
