package id.mhafizsir.quranannotation.service;

import id.mhafizsir.quranannotation.dao.Annotation;
import id.mhafizsir.quranannotation.dao.QuranWords;
import id.mhafizsir.quranannotation.dto.QuranWordsDto;
import id.mhafizsir.quranannotation.repository.QuranRepository;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class QuranServiceImpl implements QuranService {

  private final QuranRepository quranRepository;
  private final AnnotationService annotationService;

  public QuranServiceImpl(QuranRepository quranRepository,
      AnnotationService annotationService) {
    this.quranRepository = quranRepository;
    this.annotationService = annotationService;
  }

  @Override
  public List<QuranWordsDto> getQuranWordsBySuraId(Integer suraId, UUID labelId) {
    var quranWords = quranRepository.getQuranWordsBySuraId(suraId);
    return getQuranAnnotated(labelId, quranWords);
  }

  @Override
  public List<QuranWordsDto> getQuranWordsByPageId(Integer pageId, UUID labelId) {
    var quranWords = quranRepository.getQuranWordsByPageId(pageId);
    return getQuranAnnotated(labelId, quranWords);
  }

  @Override
  public List<QuranWordsDto> getSuraNames() {
    var suraNames = quranRepository.getSuraNames();
    int rowCount = 1;
    List<QuranWordsDto> quranWordsList = new ArrayList<>();
    for (String suraName : suraNames) {
      var quranWords = new QuranWordsDto();
      quranWords.setSura(rowCount);
      quranWords.setSuraName(suraName);
      rowCount++;
      quranWordsList.add(quranWords);
    }
    return quranWordsList;
  }

  private List<QuranWordsDto> getQuranAnnotated(UUID labelId, List<QuranWords> quranWords) {
    var annotations = annotationService.getAnnotationsByQuranIdAndLabelId(
        quranWords.stream().map(QuranWords::getId).collect(Collectors.toList()), labelId);
    HashMap<Integer, Annotation> annotationMap = annotations.stream().collect(
        Collectors.toMap(annotation -> annotation.getQuranWords().getId(), annotation -> annotation,
            (a, b) -> b, HashMap::new));
    return quranWords.stream()
        .map(quranWord -> new QuranWordsDto(quranWord, annotationMap.get(quranWord.getId())))
        .collect(Collectors.toList());
  }
}
