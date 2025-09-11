package mk.ukim.finki.emc.lv1b.repository;

import mk.ukim.finki.emc.lv1b.model.domain.Booking;
import mk.ukim.finki.emc.lv1b.model.domain.User;
import mk.ukim.finki.emc.lv1b.model.enumerations.BookingStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface BookingRepository extends JpaRepository<Booking, Long> {

    Optional<Booking> findByUserAndStatus(User user, BookingStatus status);

}
