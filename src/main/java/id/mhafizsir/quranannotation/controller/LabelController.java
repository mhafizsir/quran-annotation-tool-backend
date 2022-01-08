package id.mhafizsir.quranannotation.controller;

import id.mhafizsir.quranannotation.dto.LabelDto;
import id.mhafizsir.quranannotation.payload.GeneralResponse;
import id.mhafizsir.quranannotation.service.LabelService;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.web.bind.annotation.GetMapping;
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
  public ResponseEntity<GeneralResponse> getLabels() {
    UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
        .getPrincipal();
    var username = userDetails.getUsername();
    return ResponseEntity.ok(labelService.getLabels(username));
  }

  @PostMapping
  public ResponseEntity<GeneralResponse> createLabels(@RequestBody LabelDto labelDto) {
    UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication()
        .getPrincipal();
    var username = userDetails.getUsername();
    return ResponseEntity.ok(labelService.createLabel(labelDto, username));
  }
}
