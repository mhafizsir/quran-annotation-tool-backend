package id.mhafizsir.quranannotation.service;

import id.mhafizsir.quranannotation.dao.Annotation;
import id.mhafizsir.quranannotation.dto.AnnotationDto;
import id.mhafizsir.quranannotation.repository.AnnotationRepository;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AnnotationServiceImpl implements AnnotationService {

  private final AuthService authService;
  private final LabelService labelService;
  private final QuranService quranService;
  private final AnnotationRepository annotationRepository;

  @Override
  public AnnotationDto createAnnotation(AnnotationDto annotationDto, String username) {

    var user = authService.getUserByUsername(username);
    var label = labelService.getLabel(annotationDto.getLabel().getId());
    var quranWords = quranService.getQuranWordsById(annotationDto.getQuranWords().getId());

    var annotation = new Annotation();
    annotation.setCreatedAt(OffsetDateTime.now());
    annotation.setUser(user);
    annotation.setLabel(label);
    annotation.setQuranWords(quranWords);
    var savedAnnotation = annotationRepository.save(annotation);

    var result = new AnnotationDto(savedAnnotation);
    result.setCode("00");
    result.setMessage("Success create annotation");
    return result;
  }

  @Override
  public List<AnnotationDto> getAnnotations(String username) {

    var user = authService.getUserByUsername(username);
    var annotations = annotationRepository.getAnnotationsByUser(user);
    return annotations.stream().map(AnnotationDto::new).collect(Collectors.toList());
  }
}
