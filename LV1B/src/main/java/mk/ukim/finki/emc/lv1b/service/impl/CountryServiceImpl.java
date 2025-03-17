package mk.ukim.finki.emc.lv1b.service.impl;

import mk.ukim.finki.emc.lv1b.model.Country;
import mk.ukim.finki.emc.lv1b.service.CountryService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CountryServiceImpl implements CountryService {
    @Override
    public List<Country> findAll() {
        return List.of();
    }

    @Override
    public Optional<Country> save(Country country) {
        return Optional.empty();
    }

    @Override
    public Optional<Country> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Country> update(Long id, Country category) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {

    }
}
