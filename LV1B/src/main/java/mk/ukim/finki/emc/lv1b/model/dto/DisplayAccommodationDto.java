package mk.ukim.finki.emc.lv1b.model.dto;

import mk.ukim.finki.emc.lv1b.model.domain.Accommodation;
import mk.ukim.finki.emc.lv1b.model.enumerations.AccommodationCategory;
import mk.ukim.finki.emc.lv1b.model.domain.Host;

import java.util.List;
import java.util.stream.Collectors;

public record DisplayAccommodationDto(
        Long id,
        String name,
        String category,
        Long hostId,
        Integer numRooms
) {

    public static DisplayAccommodationDto from(Accommodation accommodation) {
        return new DisplayAccommodationDto(
                accommodation.getId(),
                accommodation.getName(),
                accommodation.getCategory().toString(),
                accommodation.getHost().getId(),
                accommodation.getNumRooms()
        );
    }

    public static List<DisplayAccommodationDto> from(List<Accommodation> accommodations) {
        return accommodations.stream().map(DisplayAccommodationDto::from).collect(Collectors.toList());
    }

    public Accommodation toAccommodation(Host host) {
        return new Accommodation(name, AccommodationCategory.valueOf(category), host, numRooms);
    }

}
