package mk.ukim.finki.emc.lv1b.model.dto;

import mk.ukim.finki.emc.lv1b.model.domain.Booking;
import mk.ukim.finki.emc.lv1b.model.enumerations.BookingStatus;

import java.time.LocalDateTime;
import java.util.List;

public record BookingDto(
        Long id,
        LocalDateTime dateCreated,
        DisplayUserDto user,
        List<DisplayAccommodationDto> accommodations,
        BookingStatus status
) {

    public static BookingDto from(Booking shoppingCart) {
        return new BookingDto(
                shoppingCart.getId(),
                shoppingCart.getDateCreated(),
                DisplayUserDto.from(shoppingCart.getUser()),
                DisplayAccommodationDto.from(shoppingCart.getAccommodations()),
                shoppingCart.getStatus()
        );
    }

}
