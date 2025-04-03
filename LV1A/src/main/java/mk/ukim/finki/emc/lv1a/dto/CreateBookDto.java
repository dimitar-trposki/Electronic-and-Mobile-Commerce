package mk.ukim.finki.emc.lv1a.dto;

import mk.ukim.finki.emc.lv1a.model.domain.Author;
import mk.ukim.finki.emc.lv1a.model.domain.Book;
import mk.ukim.finki.emc.lv1a.model.enumerations.Category;

import java.util.Date;

public record CreateBookDto(String name, String _category, Long authorId, Integer availableCopies, Date date) {
    public Book toBook(Category category, Author author) {
        return new Book(name, category, author, availableCopies, date);
    }
}
