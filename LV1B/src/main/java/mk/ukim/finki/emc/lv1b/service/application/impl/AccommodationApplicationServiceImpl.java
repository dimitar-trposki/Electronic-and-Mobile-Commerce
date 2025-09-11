package mk.ukim.finki.emc.lv1b.service.application.impl;

import mk.ukim.finki.emc.lv1b.model.domain.Host;
import mk.ukim.finki.emc.lv1b.model.dto.CreateAccommodationDto;
import mk.ukim.finki.emc.lv1b.model.dto.DisplayAccommodationDto;
import mk.ukim.finki.emc.lv1b.service.application.AccommodationApplicationService;
import mk.ukim.finki.emc.lv1b.service.domain.AccommodationService;
import mk.ukim.finki.emc.lv1b.service.domain.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AccommodationApplicationServiceImpl implements AccommodationApplicationService {

    private final AccommodationService accommodationService;
    private final HostService hostService;

    public AccommodationApplicationServiceImpl(AccommodationService accommodationService, HostService hostService) {
        this.accommodationService = accommodationService;
        this.hostService = hostService;
    }

    @Override
    public List<DisplayAccommodationDto> findAll() {
        return DisplayAccommodationDto.from(accommodationService.findAll());
    }

    @Override
    public Optional<DisplayAccommodationDto> findById(Long id) {
        return accommodationService.findById(id).map(DisplayAccommodationDto::from);
    }

    @Override
    public Optional<DisplayAccommodationDto> save(CreateAccommodationDto createAccommodationDto) {
        Optional<Host> host = hostService.findById(createAccommodationDto.hostId());
        return accommodationService.save(createAccommodationDto.toAccommodation(host.get())).map(DisplayAccommodationDto::from);
    }

    @Override
    public Optional<DisplayAccommodationDto> update(Long id, CreateAccommodationDto createAccommodationDto) {
        Optional<Host> host = hostService.findById(createAccommodationDto.hostId());
        return accommodationService.update(id, createAccommodationDto.toAccommodation(host.get())).map(DisplayAccommodationDto::from);
    }

    @Override
    public void deleteById(Long id) {
        accommodationService.deleteById(id);
    }

    @Override
    public void rent(Long id) {
        accommodationService.rent(id);
    }

}
