package id.mhafizsir.quranannotation.service;

import id.mhafizsir.quranannotation.payload.GeneralResponse;
import id.mhafizsir.quranannotation.repository.QuranRepository;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuranServiceImpl implements QuranService {

  private final QuranRepository quranRepository;

  public QuranServiceImpl(QuranRepository quranRepository) {
    this.quranRepository = quranRepository;
  }

  @Override
  public GeneralResponse getQuranWordsBySuraId(Integer suraId) {
    return new GeneralResponse("00", "Get Quran Words By Sura Id = " + suraId + " success",
        quranRepository.getQuranWordsBySuraId(suraId));
  }
}
