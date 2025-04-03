package mk.ukim.finki.emc.lv1a.dto;

import mk.ukim.finki.emc.lv1a.model.domain.Book;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

public record DisplayBookDto(Long Id,
                             String title,
                             String category,
                             Integer availableCopies,
                             Long author,
                             Date date) {
    public static DisplayBookDto from(Book book) {
        return new DisplayBookDto(book.getId(), book.getTitle(), book.getCategory().name(), book.getAvailableCopies(), book.getAuthor().getId(), book.getCreated());
    }

    public static List<DisplayBookDto> from(List<Book> all) {
        return all.stream().map(DisplayBookDto::from).collect(Collectors.toList());
    }
}
