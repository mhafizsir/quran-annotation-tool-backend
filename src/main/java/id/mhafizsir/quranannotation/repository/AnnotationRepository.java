package id.mhafizsir.quranannotation.repository;

import id.mhafizsir.quranannotation.dao.Annotation;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnotationRepository extends JpaRepository<Annotation, UUID> {

  @Query(value = "select a from Annotation a "
      + "left join fetch a.user u "
      + "left join fetch a.quranWords q "
      + "left join fetch a.label l "
      + "where u.id=:userId "
      + "and l.active=true ")
  List<Annotation> getAnnotationsByUser(@Param("userId") UUID userId);

  @Query(value = "select a from Annotation a "
      + "left join fetch a.quranWords q "
      + "left join fetch a.label l "
      + "where q.id in (:quranIds) "
      + "and l.id=:labelId ")
  List<Annotation> getAnnotationsByQuranIdAndLabelId(@Param("quranIds") List<Integer> quranIds,
      @Param("labelId") UUID labelId);
}
