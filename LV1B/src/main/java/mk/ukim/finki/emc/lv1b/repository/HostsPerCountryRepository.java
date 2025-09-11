package mk.ukim.finki.emc.lv1b.repository;

import mk.ukim.finki.emc.lv1b.model.views.HostsPerCountryView;
import org.hibernate.sql.ast.tree.expression.JdbcParameter;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
public interface HostsPerCountryRepository extends JpaRepository<HostsPerCountryView, Long> {

    @Transactional
    @Modifying(clearAutomatically = true)
    @Query(value = "REFRESH MATERIALIZED VIEW public.hosts_per_country", nativeQuery = true)
    void refreshMaterializedView();
}
