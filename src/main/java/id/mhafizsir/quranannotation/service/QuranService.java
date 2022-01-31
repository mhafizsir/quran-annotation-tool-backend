package id.mhafizsir.quranannotation.service;

import id.mhafizsir.quranannotation.dao.QuranWords;
import id.mhafizsir.quranannotation.dto.QuranWordsDto;
import java.util.List;

public interface QuranService {

  List<QuranWords> getQuranWordsBySuraId(Integer suraId);

  List<QuranWords> getQuranWordsByPageId(Integer pageId);

  List<QuranWordsDto> getSuraNames();

  QuranWords getQuranWordsById(Integer id);
}
