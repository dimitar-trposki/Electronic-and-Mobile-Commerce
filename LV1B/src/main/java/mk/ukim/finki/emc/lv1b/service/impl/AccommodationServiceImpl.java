package mk.ukim.finki.emc.lv1b.service.impl;

import mk.ukim.finki.emc.lv1b.model.Accommodation;
import mk.ukim.finki.emc.lv1b.model.dto.AccommodationDto;
import mk.ukim.finki.emc.lv1b.service.AccommodationService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationServiceImpl implements AccommodationService {
    @Override
    public List<Accommodation> findAll() {
        return List.of();
    }

    @Override
    public Optional<Accommodation> save(AccommodationDto accommodationDto) {
        return Optional.empty();
    }

    @Override
    public Optional<Accommodation> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Accommodation> update(Long id, AccommodationDto accommodationDto) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public void rented(Long id) {

    }
}
