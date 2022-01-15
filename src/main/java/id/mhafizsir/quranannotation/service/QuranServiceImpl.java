package id.mhafizsir.quranannotation.service;

import id.mhafizsir.quranannotation.dao.QuranWords;
import id.mhafizsir.quranannotation.repository.QuranRepository;
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
}
