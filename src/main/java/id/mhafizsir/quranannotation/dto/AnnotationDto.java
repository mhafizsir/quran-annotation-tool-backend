package id.mhafizsir.quranannotation.dto;

import id.mhafizsir.quranannotation.dao.Annotation;
import id.mhafizsir.quranannotation.payload.GeneralResponse;
import java.time.OffsetDateTime;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class AnnotationDto extends GeneralResponse {

  private UUID id;
  private UUID user;
  private LabelDto label;
  private QuranWordsDto quranWords;
  private OffsetDateTime createdAt;

  public AnnotationDto(Annotation savedAnnotation) {

    this.id = savedAnnotation.getId();
    this.user = savedAnnotation.getUser().getId();
    this.label = new LabelDto(savedAnnotation.getLabel());
    this.quranWords = new QuranWordsDto(savedAnnotation.getQuranWords());
    this.createdAt = savedAnnotation.getCreatedAt();
  }
}
