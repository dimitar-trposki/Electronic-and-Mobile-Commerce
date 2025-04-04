package mk.ukim.finki.emc.lv1a.service.domain;

import mk.ukim.finki.emc.lv1a.model.domain.Book;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> save(Book book);

    Optional<Book> findById(Long id);

    Optional<Book> update(Long id, Book book);

    void deleteById(Long id);

    List<Book> findSorted();

    void rented(Long id);

}
