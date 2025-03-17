package mk.ukim.finki.emc.lv1b.repositrory;

import mk.ukim.finki.emc.lv1b.model.Host;
import org.springframework.data.jpa.repository.JpaRepository;

public interface HostRepository extends JpaRepository<Host, Long> {
}
