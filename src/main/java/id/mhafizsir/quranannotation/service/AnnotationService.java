package id.mhafizsir.quranannotation.service;

import id.mhafizsir.quranannotation.dto.AnnotationDto;
import java.util.List;

public interface AnnotationService {

  AnnotationDto createAnnotation(AnnotationDto annotationDto, String username);

  List<AnnotationDto> getAnnotations(String username);
}
