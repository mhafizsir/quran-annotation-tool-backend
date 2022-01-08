package id.mhafizsir.quranannotation.service;

import id.mhafizsir.quranannotation.dto.LabelDto;
import id.mhafizsir.quranannotation.payload.GeneralResponse;

public interface LabelService {

  GeneralResponse getLabels(String username);

  GeneralResponse createLabel(LabelDto labelDto, String username);
}
