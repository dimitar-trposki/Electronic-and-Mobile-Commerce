package mk.ukim.finki.emc.lv1b.service.domain;

import mk.ukim.finki.emc.lv1b.model.domain.Accommodation;
import mk.ukim.finki.emc.lv1b.model.domain.Booking;

import java.util.List;
import java.util.Optional;

public interface BookingService {

    List<Accommodation> listAllAccommodationsInBooking(Long bookingId);

    Optional<Booking> getActiveBooking(String username);

    Optional<Booking> addAccommodationToBooking(String username, Long accommodationId);

    void bookBooking(String username);

    void cancelBooking(String username);

}
