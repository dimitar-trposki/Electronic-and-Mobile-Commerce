package mk.ukim.finki.emc.lv1a.config;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.emc.lv1a.model.Author;
import mk.ukim.finki.emc.lv1a.model.Book;
import mk.ukim.finki.emc.lv1a.model.Category;
import mk.ukim.finki.emc.lv1a.model.Country;
import mk.ukim.finki.emc.lv1a.repository.AuthorRepository;
import mk.ukim.finki.emc.lv1a.repository.BookRepository;
import mk.ukim.finki.emc.lv1a.repository.CountryRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer {

    private final BookRepository bookRepository;
    private final AuthorRepository authorRepository;
    private final CountryRepository countryRepository;

    public DataInitializer(BookRepository bookRepository, AuthorRepository authorRepository, CountryRepository countryRepository) {
        this.bookRepository = bookRepository;
        this.authorRepository = authorRepository;
        this.countryRepository = countryRepository;
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

        Book Hamlet = new Book("Hamlet", Category.DRAMA, WilliamShakespeare, 5);
        Book Pride_and_Prejudice = new Book("Pride and Prejudice", Category.NOVEL, JaneAusten, 7);
        Book JaneEyre = new Book("Jane Eyre", Category.NOVEL, CharlotteBronte, 9);

        bookRepository.save(Hamlet);
        bookRepository.save(Pride_and_Prejudice);
        bookRepository.save(JaneEyre);

        bookRepository.saveAll(List.of(Hamlet, Pride_and_Prejudice, JaneEyre));
    }
}
