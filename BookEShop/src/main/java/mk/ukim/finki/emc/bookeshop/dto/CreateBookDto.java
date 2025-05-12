package mk.ukim.finki.emc.bookeshop.dto;

import mk.ukim.finki.emc.bookeshop.model.domain.Author;
import mk.ukim.finki.emc.bookeshop.model.domain.Book;
import mk.ukim.finki.emc.bookeshop.model.enumerations.Category;

import java.util.List;

public record CreateBookDto(String name, Category category, Long authorId, Integer availableCopies) {

    public static CreateBookDto from(Book book) {
        return new CreateBookDto(book.getName(), book.getCategory(), book.getAuthor().getId(), book.getAvailableCopies());
    }

    public Book toBook(Author author) {
        return new Book(name, category, author, availableCopies);
    }

    public static List<CreateBookDto> from(List<Book> books) {
        return books.stream().map(CreateBookDto::from).toList();
    }

}
