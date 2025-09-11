package mk.ukim.finki.emc.lv1b.repository;

import mk.ukim.finki.emc.lv1b.model.domain.Host;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HostRepository extends JpaRepository<Host, Long> {
}
