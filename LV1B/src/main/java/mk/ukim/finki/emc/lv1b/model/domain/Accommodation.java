package mk.ukim.finki.emc.lv1b.model.domain;

import jakarta.persistence.*;
import lombok.Data;
import mk.ukim.finki.emc.lv1b.model.enumerations.AccommodationCategory;

@Data
@Entity
public class Accommodation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    @Enumerated(EnumType.STRING)
    private AccommodationCategory category;

    @ManyToOne
    private Host host;

    private Integer numRooms;

    private boolean isRented;

    public Accommodation() {
    }

    public Accommodation(String name, AccommodationCategory category, Host host, Integer numRooms) {
        this.name = name;
        this.category = category;
        this.host = host;
        this.numRooms = numRooms;
        this.isRented = false;
    }

    public Accommodation(String name, AccommodationCategory category, Host host, Integer numRooms, boolean isRented) {
        this.name = name;
        this.category = category;
        this.host = host;
        this.numRooms = numRooms;
        this.isRented = isRented;
    }

}
