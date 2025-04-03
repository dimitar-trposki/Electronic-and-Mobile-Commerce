package mk.ukim.finki.emc.lv1a.dto;

import mk.ukim.finki.emc.lv1a.model.domain.Author;
import mk.ukim.finki.emc.lv1a.model.domain.Book;
import mk.ukim.finki.emc.lv1a.model.domain.Country;
import mk.ukim.finki.emc.lv1a.model.enumerations.Category;

public record CreateCountryDto(String name, String continent) {
    public Country toCountry() {
        return new Country(name, continent);
    }
}
