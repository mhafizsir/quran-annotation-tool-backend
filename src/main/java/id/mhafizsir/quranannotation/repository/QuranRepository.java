package id.mhafizsir.quranannotation.repository;

import id.mhafizsir.quranannotation.dao.QuranWords;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface QuranRepository extends JpaRepository<QuranWords, Integer> {

  @Query(value = "select q from QuranWords q where q.sura = :suraId order by q.id asc")
  List<QuranWords> getQuranWordsBySuraId(@Param("suraId") Integer suraId);

  @Query(value = "select q from QuranWords q where q.page = :pageId")
  List<QuranWords> getQuranWordsByPageId(@Param("pageId") Integer pageId);

  @Query(value = "select q.suraName from QuranWords q group by q.suraName, q.sura order by q.sura")
  List<String> getSuraNames();
}
