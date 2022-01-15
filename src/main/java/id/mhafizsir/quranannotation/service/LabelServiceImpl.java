package id.mhafizsir.quranannotation.service;

import id.mhafizsir.quranannotation.dao.Label;
import id.mhafizsir.quranannotation.dto.LabelDto;
import id.mhafizsir.quranannotation.repository.LabelRepository;
import id.mhafizsir.quranannotation.repository.UserRepository;
import java.util.ArrayList;
import java.util.stream.Collectors;
import org.springframework.stereotype.Service;

@Service
public class LabelServiceImpl implements LabelService {

  private final LabelRepository labelRepository;
  private final UserRepository userRepository;

  public LabelServiceImpl(LabelRepository labelRepository,
      UserRepository userRepository) {
    this.labelRepository = labelRepository;
    this.userRepository = userRepository;
  }

  @Override
  public ArrayList<LabelDto> getLabels(String username) {

    var user = userRepository.findByUsernameOrEmail(username);
    var labels = labelRepository.getLabelsByUser(user.getId());
    return labels.stream().map(LabelDto::new)
        .collect(Collectors.toCollection(ArrayList::new));
  }

  @Override
  public ArrayList<LabelDto> createLabel(LabelDto labelDto, String username) {

    var user = userRepository.findByUsernameOrEmail(username);
    labelRepository.save(new Label(labelDto, user));
    var labels = labelRepository.getLabelsByUser(user.getId());
    return labels.stream().map(LabelDto::new)
        .collect(Collectors.toCollection(ArrayList::new));
  }
}
