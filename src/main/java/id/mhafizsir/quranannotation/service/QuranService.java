package id.mhafizsir.quranannotation.service;

import id.mhafizsir.quranannotation.dao.QuranWords;
import java.util.List;

public interface QuranService {

  List<QuranWords> getQuranWordsBySuraId(Integer suraId);

  List<QuranWords> getQuranWordsByPageId(Integer pageId);

  List<QuranWords> getSuraNames();
}
