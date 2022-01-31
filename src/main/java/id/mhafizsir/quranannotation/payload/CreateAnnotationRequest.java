package id.mhafizsir.quranannotation.payload;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateAnnotationRequest {

  private UUID labelId;
  private Integer quranWordsId;
}
