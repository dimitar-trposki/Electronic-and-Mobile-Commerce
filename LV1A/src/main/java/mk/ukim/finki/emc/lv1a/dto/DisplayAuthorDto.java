package mk.ukim.finki.emc.lv1a.dto;

import mk.ukim.finki.emc.lv1a.model.domain.Author;
import mk.ukim.finki.emc.lv1a.model.domain.Country;

import java.util.List;
import java.util.stream.Collectors;

public record DisplayAuthorDto(Long id, String name, String surname, Country country) {
    public static DisplayAuthorDto from(Author author) {
        return new DisplayAuthorDto(author.getId(), author.getName(), author.getSurname(), author.getCountry());
    }

    public static List<DisplayAuthorDto> from(List<Author> all) {
        return all.stream().map(DisplayAuthorDto::from).collect(Collectors.toList());
    }
}
