package mk.ukim.finki.emc.lv1a.repository;

import mk.ukim.finki.emc.lv1a.model.domain.Author;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AuthorRepository extends JpaRepository<Author, Long> {
}
