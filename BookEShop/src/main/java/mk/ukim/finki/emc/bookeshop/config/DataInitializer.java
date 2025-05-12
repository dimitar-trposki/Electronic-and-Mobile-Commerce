package mk.ukim.finki.emc.bookeshop.config;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.emc.bookeshop.model.domain.Author;
import mk.ukim.finki.emc.bookeshop.model.domain.Book;
import mk.ukim.finki.emc.bookeshop.model.enumerations.Category;
import mk.ukim.finki.emc.bookeshop.model.domain.Country;
import mk.ukim.finki.emc.bookeshop.repository.AuthorRepository;
import mk.ukim.finki.emc.bookeshop.repository.BookRepository;
import mk.ukim.finki.emc.bookeshop.repository.CountryRepository;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final AuthorRepository authorRepository;
    private final BookRepository bookRepository;
    private final CountryRepository countryRepository;

    public DataInitializer(AuthorRepository authorRepository,
                           BookRepository bookRepository,
                           CountryRepository countryRepository) {
        this.authorRepository = authorRepository;
        this.bookRepository = bookRepository;
        this.countryRepository = countryRepository;
    }

    @PostConstruct
    public void init() {
        Country USA = new Country("United States of America", "South America");
        Country UK = new Country("United Kingdom", "Europe");
        Country Spain = new Country("Spain", "Europe");

        countryRepository.save(USA);
        countryRepository.save(UK);
        countryRepository.save(Spain);

//        countryRepository.saveAll(List.of(USA, UK, Spain));

        Author HarperLee = new Author("Harper", "Lee", USA);
        Author JaneAusten = new Author("Jane", "Austen", UK);
        Author MigueldeCervantes = new Author("Miguel", "de Cervantes", Spain);

        authorRepository.save(HarperLee);
        authorRepository.save(JaneAusten);
        authorRepository.save(MigueldeCervantes);

//        authorRepository.saveAll(List.of(HarperLee, JaneAusten, MigueldeCervantes));

        Book ToKillAMockingbird = new Book("To Kill a Mockingbird", Category.NOVEL, HarperLee, 150);
        Book GoSetaWatchman = new Book("Go Set a Watchman", Category.NOVEL, HarperLee, 120);
        Book PrideAndPrejudice = new Book("To Kill a Mockingbird", Category.NOVEL, JaneAusten, 200);
        Book Emma = new Book("Emma", Category.DRAMA, JaneAusten, 230);
        Book DonQuixote = new Book("Don Quixote", Category.NOVEL, MigueldeCervantes, 170);
        Book Lagitanilla = new Book("La gitanilla", Category.NOVEL, MigueldeCervantes, 50);

        bookRepository.save(ToKillAMockingbird);
        bookRepository.save(GoSetaWatchman);
        bookRepository.save(PrideAndPrejudice);
        bookRepository.save(Emma);
        bookRepository.save(DonQuixote);
        bookRepository.save(Lagitanilla);

//        bookRepository.saveAll(List.of(ToKillAMockingbird, GoSetaWatchman, PrideAndPrejudice, Emma, DonQuixote, Lagitanilla));
    }

}