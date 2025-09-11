package mk.ukim.finki.emc.lv1b.service.application.impl;

import mk.ukim.finki.emc.lv1b.model.domain.Country;
import mk.ukim.finki.emc.lv1b.model.dto.CreateHostDto;
import mk.ukim.finki.emc.lv1b.model.dto.DisplayHostDto;
import mk.ukim.finki.emc.lv1b.service.application.HostApplicationService;
import mk.ukim.finki.emc.lv1b.service.domain.CountryService;
import mk.ukim.finki.emc.lv1b.service.domain.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostApplicationServiceImpl implements HostApplicationService {

    private final HostService hostService;
    private final CountryService countryService;

    public HostApplicationServiceImpl(HostService hostService, CountryService countryService) {
        this.hostService = hostService;
        this.countryService = countryService;
    }

    @Override
    public List<DisplayHostDto> findAll() {
        return DisplayHostDto.from(hostService.findAll());
    }

    @Override
    public Optional<DisplayHostDto> findById(Long id) {
        return hostService.findById(id).map(DisplayHostDto::from);
    }

    @Override
    public Optional<DisplayHostDto> save(CreateHostDto createHostDto) {
        Optional<Country> country = countryService.findById(createHostDto.countryId());
        return hostService.save(createHostDto.toHost(country.get())).map(DisplayHostDto::from);
    }

    @Override
    public Optional<DisplayHostDto> update(Long id, CreateHostDto createHostDto) {
        Optional<Country> country = countryService.findById(createHostDto.countryId());
        return hostService.update(id, createHostDto.toHost(country.get())).map(DisplayHostDto::from);
    }

    @Override
    public void deleteById(Long id) {
        hostService.deleteById(id);
    }

}
