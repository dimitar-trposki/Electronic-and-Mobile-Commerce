package mk.ukim.finki.emc.lv1b.service.impl;

import mk.ukim.finki.emc.lv1b.model.Host;
import mk.ukim.finki.emc.lv1b.model.dto.HostDto;
import mk.ukim.finki.emc.lv1b.service.HostService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class HostServiceImpl implements HostService {

    @Override
    public List<Host> findAll() {
        return List.of();
    }

    @Override
    public Optional<Host> save(HostDto hostDto) {
        return Optional.empty();
    }

    @Override
    public Optional<Host> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Optional<Host> update(Long id, HostDto hostDto) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {

    }
}
