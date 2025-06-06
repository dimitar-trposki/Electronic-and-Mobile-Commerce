package mk.ukim.finki.emc.lv1b.service.impl;

import mk.ukim.finki.emc.lv1b.model.Accommodation;
import mk.ukim.finki.emc.lv1b.model.Category;
import mk.ukim.finki.emc.lv1b.model.dto.AccommodationDto;
import mk.ukim.finki.emc.lv1b.repositrory.AccommodationRepository;
import mk.ukim.finki.emc.lv1b.service.AccommodationService;
import mk.ukim.finki.emc.lv1b.service.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationServiceImpl implements AccommodationService {

    private final AccommodationRepository accommodationRepository;

    private final HostService hostService;

    public AccommodationServiceImpl(AccommodationRepository accommodationRepository, HostService hostService) {
        this.accommodationRepository = accommodationRepository;
        this.hostService = hostService;
    }

    @Override
    public List<Accommodation> findAll() {
        return accommodationRepository.findAll();
    }

    @Override
    public Optional<Accommodation> save(AccommodationDto accommodationDto) {
        if (accommodationDto.getHost() != null &&
                hostService.findById(accommodationDto.getHost()).isPresent()) {
            return Optional.of(accommodationRepository.save(new Accommodation(
                    accommodationDto.getName(),
                    Category.valueOf(accommodationDto.getCategory()),
                    hostService.findById(accommodationDto.getHost()).get(),
                    accommodationDto.getNumRooms()
            )));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Accommodation> findById(Long id) {
        return accommodationRepository.findById(id);
    }

    @Override
    public Optional<Accommodation> update(Long id, AccommodationDto accommodationDto) {
        return accommodationRepository.findById(id).map(existingAccommodation -> {
            if (accommodationDto.getName() != null) {
                existingAccommodation.setName(accommodationDto.getName());
            }
            if (accommodationDto.getCategory() != null) {
                existingAccommodation.setCategory(Category.valueOf(accommodationDto.getCategory()));
            }
            if (accommodationDto.getHost() != null) {
                existingAccommodation.setHost(hostService.findById(accommodationDto.getHost()).get());
            }
            if (accommodationDto.getNumRooms() != null) {
                existingAccommodation.setNumRooms(accommodationDto.getNumRooms());
            }
            return accommodationRepository.save(existingAccommodation);
        });
    }

    @Override
    public void deleteById(Long id) {
        accommodationRepository.deleteById(id);
    }

    @Override
    public void rented(Long id) {
        Accommodation accommodation = accommodationRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Accommodation not found"));

        if (accommodation.getNumRooms() >= 1) {
            accommodation.setNumRooms(accommodation.getNumRooms() - 1);
            accommodationRepository.save(accommodation);
        }
    }
}
