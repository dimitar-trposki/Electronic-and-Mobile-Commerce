package mk.ukim.finki.emc.lv1a.service.application;

import mk.ukim.finki.emc.lv1a.dto.CreateAuthorDto;
import mk.ukim.finki.emc.lv1a.dto.DisplayAuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorApplicationService {
    List<DisplayAuthorDto> findAll();

    Optional<DisplayAuthorDto> findById(Long id);

    Optional<DisplayAuthorDto> update(Long id, CreateAuthorDto authorDto);

    Optional<DisplayAuthorDto> save(CreateAuthorDto createAuthorDto);

    void deleteById(Long id);
}
