package mk.ukim.finki.emc.bookeshop.service.application;

import mk.ukim.finki.emc.bookeshop.dto.CreateBookDto;
import mk.ukim.finki.emc.bookeshop.dto.DisplayBookDto;

import java.util.List;
import java.util.Optional;

public interface BookApplicationService {

    List<DisplayBookDto> findAll();

    Optional<DisplayBookDto> save(CreateBookDto book);

    Optional<DisplayBookDto> findById(Long id);

    Optional<DisplayBookDto> update(Long id, CreateBookDto book);

    void deleteById(Long id);

}
