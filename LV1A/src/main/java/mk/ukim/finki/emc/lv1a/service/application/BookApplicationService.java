package mk.ukim.finki.emc.lv1a.service.application;

import mk.ukim.finki.emc.lv1a.dto.CreateBookDto;
import mk.ukim.finki.emc.lv1a.dto.DisplayBookDto;

import java.util.List;
import java.util.Optional;

public interface BookApplicationService {
    Optional<DisplayBookDto> save(CreateBookDto bookDto);

    Optional<DisplayBookDto> update(Long id, CreateBookDto bookDto);

    void deleteById(Long id);

    List<DisplayBookDto> findAll();

    Optional<DisplayBookDto> findById(Long id);

    List<DisplayBookDto> findSorted();
}
