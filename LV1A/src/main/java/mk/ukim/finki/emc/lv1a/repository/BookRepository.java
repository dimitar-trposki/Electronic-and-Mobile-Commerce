package mk.ukim.finki.emc.lv1a.repository;

import mk.ukim.finki.emc.lv1a.model.domain.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookRepository extends JpaRepository<Book, Long> {
}
