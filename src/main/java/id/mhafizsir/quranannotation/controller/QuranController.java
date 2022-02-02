package id.mhafizsir.quranannotation.controller;

import id.mhafizsir.quranannotation.dto.QuranWordsDto;
import id.mhafizsir.quranannotation.service.QuranService;
import java.util.List;
import java.util.UUID;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/quran")
@CrossOrigin(methods = {RequestMethod.GET, RequestMethod.POST, RequestMethod.DELETE,
    RequestMethod.PUT, RequestMethod.HEAD})
public class QuranController {

  private final QuranService quranService;

  public QuranController(QuranService quranService) {
    this.quranService = quranService;
  }

  @GetMapping("/sura/{suraId}")
  public ResponseEntity<List<QuranWordsDto>> getQuranWordsBySuraId(
      @PathVariable("suraId") Integer suraId,
      @RequestParam(value = "labelId", required = false, defaultValue = "") UUID labelId) {
    return ResponseEntity.ok(quranService.getQuranWordsBySuraId(suraId, labelId));
  }

  @GetMapping("/page/{pageId}")
  public ResponseEntity<List<QuranWordsDto>> getQuranWordsByPageId(
      @PathVariable("pageId") Integer pageId,
      @RequestParam(value = "labelId", required = false, defaultValue = "") UUID labelId) {
    return ResponseEntity.ok(quranService.getQuranWordsByPageId(pageId, labelId));
  }

  @GetMapping("/sura")
  public ResponseEntity<List<QuranWordsDto>> getSuraNames() {

    return ResponseEntity.ok(quranService.getSuraNames());
  }
}
