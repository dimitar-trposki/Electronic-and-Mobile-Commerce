package mk.ukim.finki.emc.lv1a.service.domain.impl;

import mk.ukim.finki.emc.lv1a.model.domain.Book;
import mk.ukim.finki.emc.lv1a.model.enumerations.Category;
import mk.ukim.finki.emc.lv1a.dto.BookDto;
import mk.ukim.finki.emc.lv1a.repository.BookRepository;
import mk.ukim.finki.emc.lv1a.service.domain.AuthorService;
import mk.ukim.finki.emc.lv1a.service.domain.BookService;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

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
        return bookRepository.findAll().stream().filter(book -> !book.isDeleted()).toList();
    }

    @Override
    public Optional<Book> save(Book book) {
        if (book.getAuthor() != null &&
                authorService.findById(book.getAuthor().getId()).isPresent()) {
            return Optional.of(bookRepository.save(new Book(book.getTitle(), Category.valueOf(book.getCategory().name()),
                    authorService.findById(book.getAuthor().getId()).get(), book.getAvailableCopies(), book.getCreated())));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Book> findById(Long id) {
        Book book = bookRepository.findById(id).get();
        if (!book.isDeleted()) {
            return Optional.of(book);
        }
        return Optional.empty();
    }

    @Override
    public Optional<Book> update(Long id, Book book) {
        return bookRepository.findById(id).map(existingBook -> {
            if (book.isDeleted()) {
                return bookRepository.save(existingBook);
            }
            if (book.getTitle() != null) {
                existingBook.setTitle(book.getTitle());
            }
            if (book.getCategory() != null) {
                existingBook.setCategory(Category.valueOf(book.getCategory().name()));
            }
            if (book.getAuthor() != null) {
                existingBook.setAuthor(authorService.findById(book.getAuthor().getId()).get());
            }
            if (book.getAvailableCopies() != null) {
                existingBook.setAvailableCopies(book.getAvailableCopies());
            }
            if (!book.isDeleted()) {
                existingBook.setDeleted(false);
            }
            return bookRepository.save(existingBook);
        });
    }

    @Override
    public void deleteById(Long id) {
        Book book = bookRepository.findById(id).get();
        book.setDeleted(true);
        bookRepository.save(book);
    }

    @Override
    public List<Book> findSorted() {
        return bookRepository.findAll().stream()
                .filter(book -> !book.isDeleted())
                .sorted(Comparator.comparing(Book::getCreated).reversed())
                .limit(10)
                .collect(Collectors.toList());
    }

    @Override
    public void rented(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book ID"));

        if (book.getAvailableCopies() >= 1 && !book.isDeleted()) {
            book.setAvailableCopies(book.getAvailableCopies() - 1);
            bookRepository.save(book);
        }
    }
}
