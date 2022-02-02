package id.mhafizsir.quranannotation.controller;

import id.mhafizsir.quranannotation.dto.AnnotationDto;
import id.mhafizsir.quranannotation.payload.CreateAnnotationRequest;
import id.mhafizsir.quranannotation.service.AnnotationService;
import java.util.List;
import java.util.UUID;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/annotation")
public class AnnotationController {

  private final AnnotationService annotationService;

  @GetMapping
  public ResponseEntity<List<AnnotationDto>> getAnnotations() {

    UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
        .getPrincipal();
    var username = userDetails.getUsername();
    return ResponseEntity.ok(annotationService.getAnnotations(username));
  }

  @PostMapping
  public ResponseEntity<AnnotationDto> createAnnotation(
      @RequestBody CreateAnnotationRequest request) {

    UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
        .getPrincipal();
    var username = userDetails.getUsername();
    return ResponseEntity.ok(annotationService.createAnnotation(request, username));
  }

  @DeleteMapping("/{quranWordsId}/{labelId}")
  public ResponseEntity<List<AnnotationDto>> deleteAnnotation(
      @PathVariable("quranWordsId") Integer quranWordsId, @PathVariable("labelId") UUID labelId) {

    UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
        .getPrincipal();
    var username = userDetails.getUsername();
    return ResponseEntity.ok(annotationService.deleteAnnotation(quranWordsId, labelId, username));
  }
}
