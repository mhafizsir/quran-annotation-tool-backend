package id.mhafizsir.quranannotation.repository;

import id.mhafizsir.quranannotation.dao.Annotation;
import id.mhafizsir.quranannotation.dao.User;
import java.util.List;
import java.util.UUID;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AnnotationRepository extends JpaRepository<Annotation, UUID> {

  List<Annotation> getAnnotationsByUser(User user);
}
