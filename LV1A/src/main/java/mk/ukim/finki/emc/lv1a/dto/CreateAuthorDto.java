package mk.ukim.finki.emc.lv1a.dto;

import mk.ukim.finki.emc.lv1a.model.domain.Author;
import mk.ukim.finki.emc.lv1a.model.domain.Country;

public record CreateAuthorDto(String name, String surname, Country country) {
    public Author toAuthor() {
        return new Author(name, surname, country);
    }
}
