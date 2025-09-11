package mk.ukim.finki.emc.lv1b.service.domain.impl;

import mk.ukim.finki.emc.lv1b.events.HostChangedEvent;
import mk.ukim.finki.emc.lv1b.events.HostCreatedEvent;
import mk.ukim.finki.emc.lv1b.events.HostDeletedEvent;
import mk.ukim.finki.emc.lv1b.model.domain.Host;
import mk.ukim.finki.emc.lv1b.repository.HostRepository;
import mk.ukim.finki.emc.lv1b.repository.HostsPerCountryRepository;
import mk.ukim.finki.emc.lv1b.service.domain.CountryService;
import mk.ukim.finki.emc.lv1b.service.domain.HostService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostServiceImpl implements HostService {

    private final HostRepository hostRepository;
    private final CountryService countryService;
    private final HostsPerCountryRepository hostsPerCountryRepository;
    private final ApplicationEventPublisher applicationEventPublisher;

    public HostServiceImpl(HostRepository hostRepository, CountryService countryService, HostsPerCountryRepository hostsPerCountryRepository, ApplicationEventPublisher applicationEventPublisher) {
        this.hostRepository = hostRepository;
        this.countryService = countryService;
        this.hostsPerCountryRepository = hostsPerCountryRepository;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public List<Host> findAll() {
        return hostRepository.findAll();
    }

    @Override
    public Optional<Host> findById(Long id) {
        return hostRepository.findById(id);
    }

    @Override
    public Optional<Host> save(Host host) {
        this.applicationEventPublisher.publishEvent(new HostCreatedEvent(host));
        return Optional.of(hostRepository.save(host));
    }

    @Override
    public Optional<Host> update(Long id, Host host) {
        return hostRepository.findById(id)
                .map(existingHost -> {
                    if (host.getName() != null) {
                        existingHost.setName(host.getName());
                    }
                    if (host.getSurname() != null) {
                        existingHost.setSurname(host.getSurname());
                    }
                    if (host.getCountry() != null && countryService.findById(host.getCountry().getId()).isPresent()) {
                        existingHost.setCountry(host.getCountry());
                    }
                    this.applicationEventPublisher.publishEvent(new HostChangedEvent(existingHost));
                    return hostRepository.save(existingHost);
                });
    }

    @Override
    public void deleteById(Long id) {
        this.applicationEventPublisher.publishEvent(new HostDeletedEvent(hostRepository.findById(id)));
        hostRepository.deleteById(id);
    }

    @Override
    public void refreshMaterializedView() {
        this.hostsPerCountryRepository.refreshMaterializedView();
    }

}
