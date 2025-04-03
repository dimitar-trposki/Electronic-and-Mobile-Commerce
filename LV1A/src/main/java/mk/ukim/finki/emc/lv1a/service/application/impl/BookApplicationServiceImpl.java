package mk.ukim.finki.emc.lv1a.service.application.impl;

import mk.ukim.finki.emc.lv1a.dto.CreateBookDto;
import mk.ukim.finki.emc.lv1a.dto.DisplayBookDto;
import mk.ukim.finki.emc.lv1a.model.domain.Author;
import mk.ukim.finki.emc.lv1a.model.enumerations.Category;
import mk.ukim.finki.emc.lv1a.service.application.BookApplicationService;
import mk.ukim.finki.emc.lv1a.service.domain.AuthorService;
import mk.ukim.finki.emc.lv1a.service.domain.BookService;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class BookApplicationServiceImpl implements BookApplicationService {
    private final BookService bookService;
    private final AuthorService authorService;

    public BookApplicationServiceImpl(BookService bookService, AuthorService authorService) {
        this.bookService = bookService;
        this.authorService = authorService;
    }

    @Override
    public Optional<DisplayBookDto> save(CreateBookDto bookDto) {
        Optional<Author> author = authorService.findById(bookDto.authorId());
        Category bookCategory = Category.valueOf(bookDto._category());
        return bookService.save(bookDto.toBook(bookCategory, author.get())).map(DisplayBookDto::from);
    }

    @Override
    public Optional<DisplayBookDto> update(Long id, CreateBookDto bookDto) {
        Optional<Author> author = authorService.findById(bookDto.authorId());
        Category bookCategory = Category.valueOf(bookDto._category());
        return bookService.update(id, bookDto.toBook(bookCategory, author.get())).map(DisplayBookDto::from);
    }

    @Override
    public void deleteById(Long id) {
        bookService.deleteById(id);
    }

    @Override
    public List<DisplayBookDto> findAll() {
        return bookService.findAll().stream().map(DisplayBookDto::from).collect(Collectors.toList());
    }

    @Override
    public List<DisplayBookDto> findSorted() {
        return bookService.findSorted().stream().map(DisplayBookDto::from).collect(Collectors.toList());
    }

    @Override
    public Optional<DisplayBookDto> findById(Long id) {
        return bookService.findById(id).map(DisplayBookDto::from);
    }
}
