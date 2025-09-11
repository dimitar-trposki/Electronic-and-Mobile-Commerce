package mk.ukim.finki.emc.lv1b.service.application;

import mk.ukim.finki.emc.lv1b.model.dto.CreateHostDto;
import mk.ukim.finki.emc.lv1b.model.dto.DisplayHostDto;

import java.util.List;
import java.util.Optional;

public interface HostApplicationService {

    List<DisplayHostDto> findAll();

    Optional<DisplayHostDto> findById(Long id);

    Optional<DisplayHostDto> save(CreateHostDto createHostDto);

    Optional<DisplayHostDto> update(Long id, CreateHostDto createHostDto);

    void deleteById(Long id);

}
