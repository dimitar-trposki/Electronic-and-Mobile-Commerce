package mk.ukim.finki.emc.lv1b.service.application;

import mk.ukim.finki.emc.lv1b.model.dto.CreateCountryDto;
import mk.ukim.finki.emc.lv1b.model.dto.DisplayCountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryApplicationService {

    List<DisplayCountryDto> findAll();

    Optional<DisplayCountryDto> findById(Long id);

    Optional<DisplayCountryDto> save(CreateCountryDto createCountryDto);

    Optional<DisplayCountryDto> update(Long id, CreateCountryDto createCountryDto);

    void deleteById(Long id);

}
