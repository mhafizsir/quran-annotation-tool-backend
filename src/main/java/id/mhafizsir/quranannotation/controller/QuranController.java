package id.mhafizsir.quranannotation.controller;

import id.mhafizsir.quranannotation.dao.QuranWords;
import id.mhafizsir.quranannotation.service.QuranService;
import java.util.List;
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
  public ResponseEntity<List<QuranWords>> getQuranWordsBySuraId(
      @PathVariable("suraId") Integer suraId) {
    return ResponseEntity.ok(quranService.getQuranWordsBySuraId(suraId));
  }

  @GetMapping("/page/{pageId}")
  public ResponseEntity<List<QuranWords>> getQuranWordsByPageId(
      @PathVariable("pageId") Integer pageId) {
    return ResponseEntity.ok(quranService.getQuranWordsByPageId(pageId));
  }

  @GetMapping("/sura")
  public ResponseEntity<List<QuranWords>> getSuraNames(){

    return ResponseEntity.ok(quranService.getSuraNames());
  }
}
