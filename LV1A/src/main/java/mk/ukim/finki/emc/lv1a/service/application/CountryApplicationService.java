package mk.ukim.finki.emc.lv1a.service.application;

import mk.ukim.finki.emc.lv1a.dto.CreateCountryDto;
import mk.ukim.finki.emc.lv1a.dto.DisplayCountryDto;

import java.util.List;
import java.util.Optional;

public interface CountryApplicationService {
    List<DisplayCountryDto> findAll();

    Optional<DisplayCountryDto> findById(Long id);

    Optional<DisplayCountryDto> save(CreateCountryDto countryDto);

    Optional<DisplayCountryDto> update(Long id, CreateCountryDto countryDto);

    void deleteById(Long id);
}
