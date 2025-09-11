package mk.ukim.finki.emc.lv1b.service.domain;

import mk.ukim.finki.emc.lv1b.model.domain.Accommodation;

import java.util.List;
import java.util.Optional;

public interface AccommodationService {

    List<Accommodation> findAll();

    Optional<Accommodation> findById(Long id);

    Optional<Accommodation> save(Accommodation accommodation);

    Optional<Accommodation> update(Long id, Accommodation accommodation);

    void deleteById(Long id);

    void rent(Long id);

}
