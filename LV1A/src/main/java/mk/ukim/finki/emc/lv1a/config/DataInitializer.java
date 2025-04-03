package mk.ukim.finki.emc.lv1a.config;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.emc.lv1a.model.domain.Author;
import mk.ukim.finki.emc.lv1a.model.domain.Book;
import mk.ukim.finki.emc.lv1a.model.domain.User;
import mk.ukim.finki.emc.lv1a.model.enumerations.Category;
import mk.ukim.finki.emc.lv1a.model.domain.Country;
import mk.ukim.finki.emc.lv1a.model.enumerations.Role;
import mk.ukim.finki.emc.lv1a.repository.AuthorRepository;
import mk.ukim.finki.emc.lv1a.repository.BookRepository;
import mk.ukim.finki.emc.lv1a.repository.CountryRepository;
import mk.ukim.finki.emc.lv1a.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.List;

@Component
public class DataInitializer {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(BookRepository bookRepository,
                           AuthorRepository authorRepository,
                           CountryRepository countryRepository,
                           UserRepository userRepository,
                           PasswordEncoder passwordEncoder) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    @PostConstruct
    public void init() {
        Country England = new Country("England", "Europe");
        countryRepository.save(England);

        Author WilliamShakespeare = new Author("William", "Shakespeare", England);
        Author JaneAusten = new Author("Jane", "Austen", England);
        Author CharlotteBronte = new Author("Charlotte", "Bronte", England);

        authorRepository.save(WilliamShakespeare);
        authorRepository.save(JaneAusten);
        authorRepository.save(CharlotteBronte);

        Book Hamlet = new Book("Hamlet", Category.DRAMA, WilliamShakespeare, 5, Date.valueOf("2010-01-01"));
        Book Pride_and_Prejudice = new Book("Pride and Prejudice", Category.NOVEL, JaneAusten, 7, Date.valueOf("2012-01-01"));
        Book JaneEyre = new Book("Jane Eyre", Category.NOVEL, CharlotteBronte, 9, Date.valueOf("2015-01-01"));

        bookRepository.save(Hamlet);
        bookRepository.save(Pride_and_Prejudice);
        bookRepository.save(JaneEyre);

        bookRepository.saveAll(List.of(Hamlet, Pride_and_Prejudice, JaneEyre));

        userRepository.save(new User(
                "dt",
                passwordEncoder.encode("dt"),
                "Dimitar",
                "Trposki",
                Role.ROLE_USER
        ));

        userRepository.save(new User(
                "librarian",
                passwordEncoder.encode("librarian"),
                "librarian",
                "librarian",
                Role.ROLE_LIBRARIAN
        ));

    }
}
