package id.mhafizsir.quranannotation.service;

import id.mhafizsir.quranannotation.dto.AnnotationDto;
import id.mhafizsir.quranannotation.payload.CreateAnnotationRequest;
import java.util.List;

public interface AnnotationService {

  AnnotationDto createAnnotation(CreateAnnotationRequest request, String username);

  List<AnnotationDto> getAnnotations(String username);
}
