package mk.ukim.finki.emc.lv1a.repository;

import mk.ukim.finki.emc.lv1a.model.views.AuthorCountByCountry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AuthorCountByCountryRepository extends JpaRepository<AuthorCountByCountry, Long> {
    @Query(value = "SELECT * FROM author_count_by_country", nativeQuery = true)
    List<AuthorCountByCountry> findAllCounts();
}
