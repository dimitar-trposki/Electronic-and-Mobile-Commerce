package mk.ukim.finki.emc.lv1b.repository;

import mk.ukim.finki.emc.lv1b.model.domain.Host;
import mk.ukim.finki.emc.lv1b.model.projections.HostProjection;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface HostRepository extends JpaRepository<Host, Long> {

    @Query("SELECT h FROM Host h")
    List<HostProjection> getHostsByNameAndSurname();
}
