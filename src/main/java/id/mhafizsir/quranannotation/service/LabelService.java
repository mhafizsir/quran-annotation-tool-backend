package id.mhafizsir.quranannotation.service;

import id.mhafizsir.quranannotation.dto.LabelDto;
import java.util.List;

public interface LabelService {

  List<LabelDto> getLabels(String username);

  List<LabelDto> createLabel(LabelDto labelDto, String username);
}
