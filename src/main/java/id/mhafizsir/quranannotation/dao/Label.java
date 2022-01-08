package id.mhafizsir.quranannotation.dao;

import id.mhafizsir.quranannotation.dto.LabelDto;
import java.time.OffsetDateTime;
import java.time.ZoneId;
import java.util.UUID;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
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
@Table(name = "labels")
@EqualsAndHashCode(callSuper = true)
public class Label extends DateAudit {

  @Id
  @GeneratedValue
  private UUID id;

  @Column(nullable = false, unique = true)
  private String name;

  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "user_id", nullable = false)
  private User user;

  public Label(LabelDto labelDto, User user) {

    this.name = labelDto.getName().toUpperCase();
    this.user = user;
    this.setCreatedAt(OffsetDateTime.now(ZoneId.of("Asia/Jakarta")));
  }
}
