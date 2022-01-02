package id.mhafizsir.quranannotation.repository;

import id.mhafizsir.quranannotation.dao.QuranWords;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuranRepository extends JpaRepository<QuranWords, Integer> {

  @Query(value = "select q from QuranWords q where q.sura = :suraId")
  List<QuranWords> getQuranWordsBySuraId(@Param("suraId") Integer suraId);
}
