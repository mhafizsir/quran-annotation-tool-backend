package id.mhafizsir.quranannotation.dao;

import java.time.OffsetDateTime;
import javax.persistence.Column;
import javax.persistence.MappedSuperclass;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.SuperBuilder;

@Getter
@Setter
@SuperBuilder
@MappedSuperclass
@NoArgsConstructor
@AllArgsConstructor
public class DateAudit {

  @Column(name = "created_at", columnDefinition = "TIMESTAMP WITH TIME ZONE")
  private OffsetDateTime createdAt;

  @Column(name = "updated_at", columnDefinition = "TIMESTAMP WITH TIME ZONE")
  private OffsetDateTime updatedAt;
}
