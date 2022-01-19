package id.mhafizsir.quranannotation.service;

import id.mhafizsir.quranannotation.dao.QuranWords;
import id.mhafizsir.quranannotation.repository.QuranRepository;
import java.util.ArrayList;
import java.util.List;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuranServiceImpl implements QuranService {

  private final QuranRepository quranRepository;

  public QuranServiceImpl(QuranRepository quranRepository) {
    this.quranRepository = quranRepository;
  }

  @Override
  public List<QuranWords> getQuranWordsBySuraId(Integer suraId) {
    return quranRepository.getQuranWordsBySuraId(suraId);
  }

  @Override
  public List<QuranWords> getQuranWordsByPageId(Integer pageId) {
    return quranRepository.getQuranWordsByPageId(pageId);
  }

  @Override
  public List<QuranWords> getSuraNames() {
    var suraNames = quranRepository.getSuraNames();
    int rowCount = 1;
    List<QuranWords> quranWordsList = new ArrayList<>();
    for (String suraName : suraNames) {
      var quranWords = new QuranWords();
      quranWords.setSura(rowCount);
      quranWords.setSuraName(suraName);
      rowCount++;
      quranWordsList.add(quranWords);
    }
    return quranWordsList;
  }

  @Override
  public QuranWords getQuranWordsById(Integer id) {
    return quranRepository.getById(id);
  }
}
