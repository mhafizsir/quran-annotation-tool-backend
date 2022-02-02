package id.mhafizsir.quranannotation.controller;

import id.mhafizsir.quranannotation.dto.LabelDto;
import id.mhafizsir.quranannotation.service.LabelService;
import java.util.List;
import java.util.UUID;
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
@RequestMapping("/api/label")
public class LabelController {

  private final LabelService labelService;

  public LabelController(LabelService labelService) {
    this.labelService = labelService;
  }

  @GetMapping
  public ResponseEntity<List<LabelDto>> getLabels() {
    UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
        .getPrincipal();
    var username = userDetails.getUsername();
    return ResponseEntity.ok(labelService.getLabels(username));
  }

  @PostMapping
  public ResponseEntity<List<LabelDto>> createLabels(@RequestBody LabelDto labelDto) {
    UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
        .getPrincipal();
    var username = userDetails.getUsername();
    return ResponseEntity.ok(labelService.createLabel(labelDto, username));
  }

  @DeleteMapping("/{labelId}")
  public ResponseEntity<List<LabelDto>> deleteLabel(@PathVariable("labelId") UUID labelId) {
    UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
        .getPrincipal();
    var username = userDetails.getUsername();
    return ResponseEntity.ok(labelService.deleteLabel(labelId, username));
  }
}
