package mk.ukim.finki.emc.lv1b.service.application.impl;

import mk.ukim.finki.emc.lv1b.model.dto.BookingDto;
import mk.ukim.finki.emc.lv1b.model.dto.DisplayAccommodationDto;
import mk.ukim.finki.emc.lv1b.service.application.BookingApplicationService;
import mk.ukim.finki.emc.lv1b.service.domain.BookingService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BookingApplicationServiceImpl implements BookingApplicationService {

    private final BookingService bookingService;

    public BookingApplicationServiceImpl(BookingService bookingService) {
        this.bookingService = bookingService;
    }

    @Override
    public List<DisplayAccommodationDto> listAllAccommodationsInBooking(Long bookingId) {
        return DisplayAccommodationDto.from(bookingService.listAllAccommodationsInBooking(bookingId));
    }

    @Override
    public Optional<BookingDto> getActiveBooking(String username) {
        return bookingService.getActiveBooking(username).map(BookingDto::from);
    }

    @Override
    public Optional<BookingDto> addAccommodationToBooking(String username, Long accommodationId) {
        return bookingService.addAccommodationToBooking(username, accommodationId).map(BookingDto::from);
    }

    @Override
    public void bookBooking(String username) {
        bookingService.bookBooking(username);
    }

    @Override
    public void cancelBooking(String username) {
        bookingService.cancelBooking(username);
    }

}
