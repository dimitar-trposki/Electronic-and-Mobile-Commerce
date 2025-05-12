package mk.ukim.finki.emc.bookeshop.service.domain.impl;

import mk.ukim.finki.emc.bookeshop.model.domain.Book;
import mk.ukim.finki.emc.bookeshop.model.enumerations.Category;
import mk.ukim.finki.emc.bookeshop.dto.BookDto;
import mk.ukim.finki.emc.bookeshop.repository.BookRepository;
import mk.ukim.finki.emc.bookeshop.service.domain.AuthorService;
import mk.ukim.finki.emc.bookeshop.service.domain.BookService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookServiceImpl implements BookService {

    private final BookRepository bookRepository;
    private final AuthorService authorService;

    public BookServiceImpl(BookRepository bookRepository, AuthorService authorService) {
        this.bookRepository = bookRepository;
        this.authorService = authorService;
    }

    @Override
    public List<Book> findAll() {
        return bookRepository.findAll();
    }

    @Override
    public Optional<Book> save(Book book) {
        if (book.getName() != null
                && book.getAvailableCopies() != null
                && book.getCategory() != null
                && book.getAuthor().getId() != null
                && authorService.findById(book.getAuthor().getId()).isPresent()) {
            return Optional.of(bookRepository.save(new Book(book.getName(),
                    book.getCategory(),
                    book.getAuthor(),
                    book.getAvailableCopies())));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> update(Long id, Book book) {
        return bookRepository.findById(id).map(existingBook -> {
            if (book.getName() != null) {
                existingBook.setName(book.getName());
            }
            if (book.getAuthor().getId() != null && authorService.findById(book.getAuthor().getId()).isPresent()) {
                existingBook.setAuthor(book.getAuthor());
            }
            if (book.getCategory() != null) {
                existingBook.setCategory(book.getCategory());
            }
            if (book.getAvailableCopies() != null) {
                existingBook.setAvailableCopies(book.getAvailableCopies());
            }
            return bookRepository.save(existingBook);
        });
    }

    @Override
    public void deleteById(Long id) {
        bookRepository.deleteById(id);
    }

}
