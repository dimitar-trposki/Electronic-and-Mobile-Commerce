package mk.ukim.finki.emc.lv1b.repository;

import mk.ukim.finki.emc.lv1b.model.views.AccommodationsPerHostView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.transaction.annotation.Transactional;

public interface AccommodationsPerHostRepository extends JpaRepository<AccommodationsPerHostView, Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "REFRESH MATERIALIZED VIEW public.accommodations_per_host", nativeQuery = true)
    void refreshMaterializedView();
}
