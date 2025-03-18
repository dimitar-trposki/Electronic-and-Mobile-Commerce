package mk.ukim.finki.emc.lv1b.service.impl;

import mk.ukim.finki.emc.lv1b.model.Host;
import mk.ukim.finki.emc.lv1b.model.dto.HostDto;
import mk.ukim.finki.emc.lv1b.repositrory.HostRepository;
import mk.ukim.finki.emc.lv1b.service.CountryService;
import mk.ukim.finki.emc.lv1b.service.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostServiceImpl implements HostService {

    private final HostRepository hostRepository;

    private final CountryService countryService;

    public HostServiceImpl(HostRepository hostRepository, CountryService countryService) {
        this.hostRepository = hostRepository;
        this.countryService = countryService;
    }

    @Override
    public List<Host> findAll() {
        return hostRepository.findAll();
    }

    @Override
    public Optional<Host> save(HostDto hostDto) {
        if (hostDto.getCountry() != null &&
                countryService.findById(hostDto.getCountry()).isPresent()) {
            return Optional.of(hostRepository.save(new Host(
                    hostDto.getName(),
                    hostDto.getSurname(),
                    countryService.findById(hostDto.getCountry()).get()
            )));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Host> findById(Long id) {
        return hostRepository.findById(id);
    }

    @Override
    public Optional<Host> update(Long id, HostDto hostDto) {
        return hostRepository.findById(id).map(existingHost -> {
            if (hostDto.getName() != null) {
                existingHost.setName(hostDto.getName());
            }
            if (hostDto.getSurname() != null) {
                existingHost.setSurname(hostDto.getSurname());
            }
            if (hostDto.getCountry() != null) {
                existingHost.setCountry(countryService.findById(hostDto.getCountry()).get());
            }
            return hostRepository.save(existingHost);
        });
    }

    @Override
    public void deleteById(Long id) {
        hostRepository.deleteById(id);
    }
}
