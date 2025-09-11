package mk.ukim.finki.emc.lv1b.service.application;

import mk.ukim.finki.emc.lv1b.model.dto.CreateAccommodationDto;
import mk.ukim.finki.emc.lv1b.model.dto.DisplayAccommodationDto;

import java.util.List;
import java.util.Optional;

public interface AccommodationApplicationService {

    List<DisplayAccommodationDto> findAll();

    Optional<DisplayAccommodationDto> findById(Long id);

    Optional<DisplayAccommodationDto> save(CreateAccommodationDto createAccommodationDto);

    Optional<DisplayAccommodationDto> update(Long id, CreateAccommodationDto createAccommodationDto);

    void deleteById(Long id);

    void rent(Long id);

}
