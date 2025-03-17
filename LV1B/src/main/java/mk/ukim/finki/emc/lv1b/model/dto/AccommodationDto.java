package mk.ukim.finki.emc.lv1b.model.dto;

import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import mk.ukim.finki.emc.lv1b.model.Category;
import mk.ukim.finki.emc.lv1b.model.Host;

@Data
@Getter
@Setter
public class AccommodationDto {

    private String name;

    private String category;

    private Long host;

    private Integer numRooms;

    public AccommodationDto() {
    }

    public AccommodationDto(String name, String category, Long host, Integer numRooms) {
        this.name = name;
        this.category = category;
        this.host = host;
        this.numRooms = numRooms;
    }

}
