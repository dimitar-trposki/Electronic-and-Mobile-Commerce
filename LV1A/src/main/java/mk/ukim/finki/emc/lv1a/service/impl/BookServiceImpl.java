package mk.ukim.finki.emc.lv1a.service.impl;

import mk.ukim.finki.emc.lv1a.model.Book;
import mk.ukim.finki.emc.lv1a.model.Category;
import mk.ukim.finki.emc.lv1a.model.dto.BookDto;
import mk.ukim.finki.emc.lv1a.repository.BookRepository;
import mk.ukim.finki.emc.lv1a.service.AuthorService;
import mk.ukim.finki.emc.lv1a.service.BookService;
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
    public Optional<Book> save(BookDto book) {
        if (book.getAuthor() != null &&
                authorService.findById(book.getAuthor()).isPresent()) {
            return Optional.of(bookRepository.save(new Book(book.getTitle(), Category.valueOf(book.getCategory()),
                    authorService.findById(book.getAuthor()).get(), book.getAvailableCopies())));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Book> findById(Long id) {
        return bookRepository.findById(id);
    }

    @Override
    public Optional<Book> update(Long id, BookDto book) {
        return bookRepository.findById(id).map(existingBook -> {
            if (book.getTitle() != null) {
                existingBook.setTitle(book.getTitle());
            }
            if (book.getCategory() != null) {
                existingBook.setCategory(Category.valueOf(book.getCategory()));
            }
            if (book.getAuthor() != null) {
                existingBook.setAuthor(authorService.findById(book.getAuthor()).get());
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

    @Override
    public void rented(Long id) {
        Book book = bookRepository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid book ID"));

        if (book.getAvailableCopies() >= 1) {
            book.setAvailableCopies(book.getAvailableCopies() - 1);
            bookRepository.save(book);
        }
    }
}
