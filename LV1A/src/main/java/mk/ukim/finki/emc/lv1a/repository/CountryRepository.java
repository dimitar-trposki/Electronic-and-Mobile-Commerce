package mk.ukim.finki.emc.lv1a.repository;

import mk.ukim.finki.emc.lv1a.model.domain.Country;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CountryRepository extends JpaRepository<Country, Long> {
}
