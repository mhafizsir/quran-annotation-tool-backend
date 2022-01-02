package id.mhafizsir.quranannotation.controller;

import id.mhafizsir.quranannotation.payload.GeneralResponse;
import id.mhafizsir.quranannotation.service.QuranService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quran")
public class QuranController {

  private final QuranService quranService;

  public QuranController(QuranService quranService) {
    this.quranService = quranService;
  }

  @GetMapping("/sura/{suraId}")
  public ResponseEntity<GeneralResponse> getQuranWordsBySuraId(
      @PathVariable("suraId") Integer suraId) {
    return ResponseEntity.ok(quranService.getQuranWordsBySuraId(suraId));
  }
}
