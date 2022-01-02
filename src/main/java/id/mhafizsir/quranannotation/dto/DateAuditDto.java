package id.mhafizsir.quranannotation.dto;

import java.time.OffsetDateTime;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class DateAuditDto {

  private OffsetDateTime createdAt;
  private OffsetDateTime updatedAt;
}
