package mk.ukim.finki.emc.lv1b.service.application;

import mk.ukim.finki.emc.lv1b.model.dto.BookingDto;
import mk.ukim.finki.emc.lv1b.model.dto.DisplayAccommodationDto;

import java.util.List;
import java.util.Optional;

public interface BookingApplicationService {

    List<DisplayAccommodationDto> listAllAccommodationsInBooking(Long bookingId);

    Optional<BookingDto> getActiveBooking(String username);

    Optional<BookingDto> addAccommodationToBooking(String username, Long accommodationId);

    void bookBooking(String username);

    void cancelBooking(String username);

}
