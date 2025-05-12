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
        if (/*book.getName() != null
                && book.getAvailableCopies() != null
                && book.getCategory() != null
                && */book.getAuthorId() != null
                && authorService.findById(book.getAuthorId()).isPresent()) {
            return Optional.of(bookRepository.save(new Book(book.getName(),
                    Category.valueOf(book.getCategory()),
                    authorService.findById(book.getAuthorId()).get(),
                    book.getAvailableCopies())));
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
            if (book.getName() != null) {
                existingBook.setName(book.getName());
            }
            if (book.getAuthorId() != null && authorService.findById(book.getAuthorId()).isPresent()) {
                existingBook.setAuthor(authorService.findById(book.getAuthorId()).get());
            }
            if (book.getCategory() != null) {
                existingBook.setCategory(Category.valueOf(book.getCategory()));
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
