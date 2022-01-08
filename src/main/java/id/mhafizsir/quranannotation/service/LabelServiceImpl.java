package id.mhafizsir.quranannotation.service;

import id.mhafizsir.quranannotation.dao.Label;
import id.mhafizsir.quranannotation.dto.LabelDto;
import id.mhafizsir.quranannotation.payload.GeneralResponse;
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
  public GeneralResponse getLabels(String username) {

    var user = userRepository.findByUsernameOrEmail(username);
    var labels = labelRepository.getLabelsByUser(user.getId());
    ArrayList<LabelDto> results = labels.stream().map(LabelDto::new)
        .collect(Collectors.toCollection(ArrayList::new));
    return new GeneralResponse("00", "Get Labels Success", results);
  }

  @Override
  public GeneralResponse createLabel(LabelDto labelDto, String username) {

    var user = userRepository.findByUsernameOrEmail(username);
    var label = labelRepository.getLabelByName(labelDto.getName().toUpperCase());
    if (label != null) {
      return new GeneralResponse("01", "Create Label Failed, label with this name already exists",
          null);
    }
    labelRepository.save(new Label(labelDto, user));
    var labels = labelRepository.getLabelsByUser(user.getId());
    ArrayList<LabelDto> results = labels.stream().map(LabelDto::new)
        .collect(Collectors.toCollection(ArrayList::new));
    return new GeneralResponse("00", "Create Label Success", results);
  }
}
