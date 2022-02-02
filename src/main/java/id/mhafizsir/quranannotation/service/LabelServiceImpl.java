package id.mhafizsir.quranannotation.service;

import id.mhafizsir.quranannotation.dao.Label;
import id.mhafizsir.quranannotation.dto.LabelDto;
import id.mhafizsir.quranannotation.repository.LabelRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class LabelServiceImpl implements LabelService {

  private final LabelRepository labelRepository;
  private final AuthService authService;

  @Override
  public ArrayList<LabelDto> getLabels(String username) {

    var user = authService.getUserByUsername(username);
    var labels = labelRepository.getLabelsByUser(user.getId());
    return labels.stream().map(LabelDto::new)
        .collect(Collectors.toCollection(ArrayList::new));
  }

  @Override
  public ArrayList<LabelDto> createLabel(LabelDto labelDto, String username) {

    var user = authService.getUserByUsername(username);
    var label = new Label(labelDto, user);
    label.setActive(true);
    labelRepository.save(label);
    var labels = labelRepository.getLabelsByUser(user.getId());
    return labels.stream().map(LabelDto::new)
        .collect(Collectors.toCollection(ArrayList::new));
  }

  @Override
  public Label getLabel(UUID id) {
    return labelRepository.getById(id);
  }

  @Override
  public List<LabelDto> deleteLabel(UUID labelId, String username) {

    var label = labelRepository.getById(labelId);
    label.setActive(false);
    labelRepository.save(label);
    return getLabels(username);
  }
}
