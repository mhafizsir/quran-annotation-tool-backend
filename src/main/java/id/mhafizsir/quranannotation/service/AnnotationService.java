package id.mhafizsir.quranannotation.service;

import id.mhafizsir.quranannotation.dao.Annotation;
import id.mhafizsir.quranannotation.dto.AnnotationDto;
import id.mhafizsir.quranannotation.payload.CreateAnnotationRequest;
import java.util.List;
import java.util.UUID;

public interface AnnotationService {

  AnnotationDto createAnnotation(CreateAnnotationRequest request, String username);

  List<AnnotationDto> getAnnotations(String username);

  List<Annotation> getAnnotationsByQuranIdAndLabelId(List<Integer> quranIds, UUID labelId);

  List<AnnotationDto> deleteAnnotation(UUID annotationId, String username);
}
