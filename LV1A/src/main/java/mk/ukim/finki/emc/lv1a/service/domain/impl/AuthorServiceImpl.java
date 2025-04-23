package mk.ukim.finki.emc.lv1a.service.domain.impl;

import mk.ukim.finki.emc.lv1a.events.AuthorChangedEvent;
import mk.ukim.finki.emc.lv1a.model.domain.Author;
import mk.ukim.finki.emc.lv1a.repository.AuthorRepository;
import mk.ukim.finki.emc.lv1a.service.domain.AuthorService;
import mk.ukim.finki.emc.lv1a.service.domain.CountryService;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class AuthorServiceImpl implements AuthorService {

    private final AuthorRepository authorRepository;
    private final CountryService countryService;
    private final ApplicationEventPublisher applicationEventPublisher;

    public AuthorServiceImpl(AuthorRepository authorRepository, CountryService countryService, ApplicationEventPublisher applicationEventPublisher) {
        this.authorRepository = authorRepository;
        this.countryService = countryService;
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @Override
    public List<Author> findAll() {
        return authorRepository.findAll();
    }

    @Override
    public Optional<Author> save(Author author) {
        if (author.getCountry().getId() != null &&
                countryService.findById(author.getCountry().getId()).isPresent()) {
            applicationEventPublisher.publishEvent(new AuthorChangedEvent(author));
            return Optional.of(authorRepository.save(new Author(author.getName(), author.getSurname(),
                    countryService.findById(author.getCountry().getId()).get())));
        }
        return Optional.empty();
    }

    @Override
    public Optional<Author> findById(Long id) {
        return authorRepository.findById(id);
    }

    @Override
    public Optional<Author> update(Long id, Author author) {
        return authorRepository.findById(id).map(existingAuthor -> {
            if (author.getName() != null) {
                existingAuthor.setName(author.getName());
            }
            if (author.getSurname() != null) {
                existingAuthor.setSurname(author.getSurname());
            }
            if (author.getCountry().getId() != null && countryService.findById(author.getCountry().getId()).isPresent()) {
                existingAuthor.setCountry(countryService.findById(author.getCountry().getId()).get());
            }
            applicationEventPublisher.publishEvent(new AuthorChangedEvent(existingAuthor));
            return authorRepository.save(existingAuthor);
        });
    }

    @Override
    public void deleteById(Long id) {
        authorRepository.deleteById(id);
        applicationEventPublisher.publishEvent(new AuthorChangedEvent(this));
    }
}
