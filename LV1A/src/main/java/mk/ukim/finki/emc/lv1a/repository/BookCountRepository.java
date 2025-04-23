package mk.ukim.finki.emc.lv1a.repository;

import mk.ukim.finki.emc.lv1a.model.projections.BookCountView;
import mk.ukim.finki.emc.lv1a.model.views.BookCountEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface BookCountRepository extends JpaRepository<BookCountEntity, Long> {
    @Query(value = "SELECT * FROM book_count_by_author", nativeQuery = true)
    List<BookCountView> findAllBookCounts();
}
