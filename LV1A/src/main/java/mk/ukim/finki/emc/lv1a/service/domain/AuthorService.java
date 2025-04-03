package mk.ukim.finki.emc.lv1a.service.domain;

import mk.ukim.finki.emc.lv1a.model.domain.Author;
import mk.ukim.finki.emc.lv1a.dto.AuthorDto;

import java.util.List;
import java.util.Optional;

public interface AuthorService {

    List<Author> findAll();

    Optional<Author> save(Author author);

    Optional<Author> findById(Long id);

    Optional<Author> update(Long id, Author author);

    void deleteById(Long id);
}
