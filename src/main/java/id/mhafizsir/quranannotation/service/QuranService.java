package id.mhafizsir.quranannotation.service;

import id.mhafizsir.quranannotation.dto.QuranWordsDto;
import java.util.List;
import java.util.UUID;

public interface QuranService {

  List<QuranWordsDto> getQuranWordsBySuraId(Integer suraId, UUID labelId);

  List<QuranWordsDto> getQuranWordsByPageId(Integer pageId, UUID labelId);

  List<QuranWordsDto> getSuraNames();
}
