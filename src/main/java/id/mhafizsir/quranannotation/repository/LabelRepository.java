package id.mhafizsir.quranannotation.repository;

import id.mhafizsir.quranannotation.dao.Label;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface LabelRepository extends JpaRepository<Label, UUID> {

  @Query(value = "select l from Label l "
      + "left join fetch l.user u "
      + "where u.id=:userId "
      + "and l.active=true "
      + "order by l.name asc ")
  List<Label> getLabelsByUser(@Param("userId") UUID userId);

  @Query(value = "select l from Label l "
      + "where l.name = :name")
  Label getLabelByName(@Param("name") String name);

}
