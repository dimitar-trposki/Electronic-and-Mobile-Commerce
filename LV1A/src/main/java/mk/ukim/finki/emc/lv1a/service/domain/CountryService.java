package mk.ukim.finki.emc.lv1a.service.domain;

import mk.ukim.finki.emc.lv1a.model.domain.Country;

import java.util.List;
import java.util.Optional;

public interface CountryService {

    List<Country> findAll();

    Optional<Country> save(Country country);

    Optional<Country> findById(Long id);

    Optional<Country> update(Long id, Country category);

    void deleteById(Long id);

}
