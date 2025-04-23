package mk.ukim.finki.emc.lv1a.web;

import mk.ukim.finki.emc.lv1a.model.projections.AuthorNameView;
import mk.ukim.finki.emc.lv1a.model.views.AuthorCountByCountry;
import mk.ukim.finki.emc.lv1a.repository.AuthorCountByCountryRepository;
import mk.ukim.finki.emc.lv1a.repository.AuthorRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/authors")
public class AuthorController {
    private final AuthorRepository authorRepository;
    private final AuthorCountByCountryRepository authorCountByCountryRepository;

    public AuthorController(AuthorRepository authorRepository, AuthorCountByCountryRepository authorCountByCountryRepository) {
        this.authorRepository = authorRepository;
        this.authorCountByCountryRepository = authorCountByCountryRepository;
    }

    @GetMapping("/names")
    public List<AuthorNameView> getAuthorNames() {
        return authorRepository.findAllProjectedBy();
    }

    @GetMapping("/by-country")
    public List<AuthorCountByCountry> getAuthorsByCountry() {
        return authorCountByCountryRepository.findAllCounts();
    }
}
