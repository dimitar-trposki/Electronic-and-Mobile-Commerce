package mk.ukim.finki.emc.lv1b.service;

import mk.ukim.finki.emc.lv1b.model.Accommodation;
import mk.ukim.finki.emc.lv1b.model.dto.AccommodationDto;

import java.util.List;
import java.util.Optional;

public interface AccommodationService {

    List<Accommodation> findAll();

    Optional<Accommodation> save(AccommodationDto accommodationDto);

    Optional<Accommodation> findById(Long id);

    Optional<Accommodation> update(Long id, AccommodationDto accommodationDto);

    void deleteById(Long id);

    void rented(Long id);

}
