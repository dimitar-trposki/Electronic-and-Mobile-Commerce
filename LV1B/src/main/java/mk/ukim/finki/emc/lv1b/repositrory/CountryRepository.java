package mk.ukim.finki.emc.lv1b.repositrory;

import mk.ukim.finki.emc.lv1b.model.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
