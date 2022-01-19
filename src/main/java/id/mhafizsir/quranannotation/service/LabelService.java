package id.mhafizsir.quranannotation.service;

import id.mhafizsir.quranannotation.dao.Label;
import id.mhafizsir.quranannotation.dto.LabelDto;
import java.util.List;
import java.util.UUID;

public interface LabelService {

  List<LabelDto> getLabels(String username);

  List<LabelDto> createLabel(LabelDto labelDto, String username);

  Label getLabel(UUID id);
}
