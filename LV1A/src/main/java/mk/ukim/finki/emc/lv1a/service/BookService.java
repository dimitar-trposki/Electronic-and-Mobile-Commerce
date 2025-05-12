package mk.ukim.finki.emc.lv1a.service;

import mk.ukim.finki.emc.lv1a.model.Book;
import mk.ukim.finki.emc.lv1a.model.dto.BookDto;

import java.util.List;
import java.util.Optional;

public interface BookService {

    List<Book> findAll();

    Optional<Book> save(BookDto book);

    Optional<Book> findById(Long id);

    Optional<Book> update(Long id, BookDto book);

    void deleteById(Long id);

}
