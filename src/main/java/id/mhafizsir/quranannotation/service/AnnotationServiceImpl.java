package id.mhafizsir.quranannotation.service;

import id.mhafizsir.quranannotation.dao.Annotation;
import id.mhafizsir.quranannotation.dto.AnnotationDto;
import id.mhafizsir.quranannotation.payload.CreateAnnotationRequest;
import id.mhafizsir.quranannotation.repository.AnnotationRepository;
import id.mhafizsir.quranannotation.repository.QuranRepository;
import java.time.OffsetDateTime;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
public class AnnotationServiceImpl implements AnnotationService {

  private final AuthService authService;
  private final LabelService labelService;
  private final QuranRepository quranRepository;
  private final AnnotationRepository annotationRepository;

  @Override
  @Transactional
  public AnnotationDto createAnnotation(CreateAnnotationRequest request, String username) {

    var user = authService.getUserByUsername(username);
    var label = labelService.getLabel(request.getLabelId());
    var quranWords = quranRepository.getById(request.getQuranWordsId());

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
    var annotations = annotationRepository.getAnnotationsByUser(user.getId());
    return annotations.stream().map(AnnotationDto::new).collect(Collectors.toList());
  }

  @Override
  public List<Annotation> getAnnotationsByQuranIdAndLabelId(List<Integer> quranIds, UUID labelId) {

    return annotationRepository.getAnnotationsByQuranIdAndLabelId(quranIds, labelId);
  }

  @Override
  public List<AnnotationDto> deleteAnnotation(UUID quranId, UUID labelId, String username) {

    var annotation = annotationRepository.deleteByQuranIdAndLabelId(quranId, labelId);
    annotationRepository.delete(annotation);
    return getAnnotations(username);
  }
}
