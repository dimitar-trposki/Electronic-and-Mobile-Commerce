package mk.ukim.finki.emc.lv1b.config;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.emc.lv1b.model.domain.Accommodation;
import mk.ukim.finki.emc.lv1b.model.domain.User;
import mk.ukim.finki.emc.lv1b.model.enumerations.AccommodationCategory;
import mk.ukim.finki.emc.lv1b.model.domain.Country;
import mk.ukim.finki.emc.lv1b.model.domain.Host;
import mk.ukim.finki.emc.lv1b.model.enumerations.Role;
import mk.ukim.finki.emc.lv1b.repository.AccommodationRepository;
import mk.ukim.finki.emc.lv1b.repository.CountryRepository;
import mk.ukim.finki.emc.lv1b.repository.HostRepository;
import mk.ukim.finki.emc.lv1b.repository.UserRepository;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;

@Component
public class DataInitializer {

    private final AccommodationRepository accommodationRepository;
    private final HostRepository hostRepository;
    private final CountryRepository countryRepository;
    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;

    public DataInitializer(AccommodationRepository accommodationRepository, HostRepository hostRepository, CountryRepository countryRepository, UserRepository userRepository, PasswordEncoder passwordEncoder) {
        this.accommodationRepository = accommodationRepository;
        this.hostRepository = hostRepository;
        this.countryRepository = countryRepository;
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
    }

    //@PostConstruct
    public void init() {
        Country England = new Country("England", "Europe");
        countryRepository.save(England);

        Host WilliamShakespeare = new Host("William", "Shakespeare", England);
        Host JaneAusten = new Host("Jane", "Austen", England);
        Host CharlotteBronte = new Host("Charlotte", "Bronte", England);

        hostRepository.save(WilliamShakespeare);
        hostRepository.save(JaneAusten);
        hostRepository.save(CharlotteBronte);

        Accommodation Hamlet = new Accommodation("One Hyde Park", AccommodationCategory.FLAT, WilliamShakespeare, 9);
        Accommodation Pride_and_Prejudice = new Accommodation("Canary Wharf", AccommodationCategory.APARTMENT, JaneAusten, 5);
        Accommodation JaneEyre = new Accommodation("The Ritz London", AccommodationCategory.HOTEL, CharlotteBronte, 135);

        accommodationRepository.save(Hamlet);
        accommodationRepository.save(Pride_and_Prejudice);
        accommodationRepository.save(JaneEyre);

        userRepository.save(new User(
                "dt",
                passwordEncoder.encode("dt"),
                "Dimitar",
                "Trposki",
                Role.ROLE_HOST
        ));

        userRepository.save(new User(
                "at",
                passwordEncoder.encode("at"),
                "Ana",
                "Todorovska",
                Role.ROLE_USER
        ));
    }

}
