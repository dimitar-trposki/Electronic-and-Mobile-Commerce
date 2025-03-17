package mk.ukim.finki.emc.lv1b.config;

import jakarta.annotation.PostConstruct;
import mk.ukim.finki.emc.lv1b.model.Accommodation;
import mk.ukim.finki.emc.lv1b.model.Category;
import mk.ukim.finki.emc.lv1b.model.Country;
import mk.ukim.finki.emc.lv1b.model.Host;
import mk.ukim.finki.emc.lv1b.repositrory.AccommodationRepository;
import mk.ukim.finki.emc.lv1b.repositrory.CountryRepository;
import mk.ukim.finki.emc.lv1b.repositrory.HostRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class DataInitializer {

    private final CountryRepository countryRepository;
    private final HostRepository hostRepository;
    private final AccommodationRepository accommodationRepository;

    public DataInitializer(CountryRepository countryRepository, HostRepository hostRepository, AccommodationRepository accommodationRepository) {
        this.countryRepository = countryRepository;
        this.hostRepository = hostRepository;
        this.accommodationRepository = accommodationRepository;
    }

    @PostConstruct
    public void init() {
        Country USA = new Country("USA", "North America");

        countryRepository.save(USA);

        Host StephCurry = new Host("Stephen", "Curry", USA);
        Host LeBronJames = new Host("LeBron", "James", USA);
        Host KevinDurant = new Host("Kevin", "Durant", USA);

        hostRepository.save(StephCurry);
        hostRepository.save(LeBronJames);
        hostRepository.save(KevinDurant);

        Accommodation Staypineapple = new Accommodation("Staypineapple", Category.HOTEL, StephCurry, 500);
        Accommodation Hilton = new Accommodation("Hilton Los Angeles", Category.HOTEL, LeBronJames, 450);
        Accommodation LunaBear = new Accommodation("Luna Bear", Category.APARTMENT, KevinDurant, 7);

        accommodationRepository.save(Staypineapple);
        accommodationRepository.save(Hilton);
        accommodationRepository.save(LunaBear);

        accommodationRepository.saveAll(List.of(Staypineapple, Hilton, LunaBear));
    }
}
