package mk.ukim.finki.emc.lv1b.service.domain.impl;

import mk.ukim.finki.emc.lv1b.model.domain.Accommodation;
import mk.ukim.finki.emc.lv1b.model.domain.Booking;
import mk.ukim.finki.emc.lv1b.model.domain.User;
import mk.ukim.finki.emc.lv1b.model.enumerations.BookingStatus;
import mk.ukim.finki.emc.lv1b.repository.BookingRepository;
import mk.ukim.finki.emc.lv1b.service.domain.AccommodationService;
import mk.ukim.finki.emc.lv1b.service.domain.BookingService;
import mk.ukim.finki.emc.lv1b.service.domain.UserService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class BookingServiceImpl implements BookingService {

    private final BookingRepository bookingRepository;
    private final UserService userService;
    private final AccommodationService accommodationService;

    public BookingServiceImpl(BookingRepository bookingRepository, UserService userService, AccommodationService accommodationService) {
        this.bookingRepository = bookingRepository;
        this.userService = userService;
        this.accommodationService = accommodationService;
    }

    @Override
    public List<Accommodation> listAllAccommodationsInBooking(Long bookingId) {
        if (bookingRepository.findById(bookingId).isEmpty()) {
            throw new RuntimeException("Booking not found.");
        }
        return bookingRepository.findById(bookingId).get().getAccommodations();
    }

    @Override
    public Optional<Booking> getActiveBooking(String username) {
        User user = userService.findByUsername(username);
        return Optional.of(bookingRepository.findByUserAndStatus(user, BookingStatus.CREATED)
                .orElseGet(() -> bookingRepository.save(new Booking(user))));
    }

    @Override
    public Optional<Booking> addAccommodationToBooking(String username, Long accommodationId) {
        if (getActiveBooking(username).isPresent()) {
            Booking booking = getActiveBooking(username).get();
            Accommodation accommodation = accommodationService.findById(accommodationId).get();
            if (!accommodation.isRented()) {
                booking.getAccommodations().add(accommodation);
                return Optional.of(bookingRepository.save(booking));
            }
        }
        return Optional.empty();
    }

    @Override
    public void bookBooking(String username) {
        if (getActiveBooking(username).isPresent()) {
            Booking booking = getActiveBooking(username).get();
            for (int i = 0; i < (long) booking.getAccommodations().size(); i++) {
                accommodationService.rent(booking.getAccommodations().get(i).getId());
            }
        }
    }

    @Override
    public void cancelBooking(String username) {
        if (getActiveBooking(username).isPresent()) {
            Booking booking = getActiveBooking(username).get();
            booking.setAccommodations(new ArrayList<>());
        }
    }
}
