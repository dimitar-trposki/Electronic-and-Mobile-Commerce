package mk.ukim.finki.emc.lv1b.model.domain;

import jakarta.persistence.*;
import lombok.Data;
import mk.ukim.finki.emc.lv1b.model.enumerations.BookingStatus;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Data
@Entity
public class Booking {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private LocalDateTime dateCreated;

    @ManyToOne(fetch = FetchType.LAZY)
    private User user;

    @ManyToMany
    private List<Accommodation> accommodations;

    @Enumerated(EnumType.STRING)
    private BookingStatus status;

    public Booking() {
    }

    public Booking(User user) {
        this.dateCreated = LocalDateTime.now();
        this.user = user;
        this.accommodations = new ArrayList<>();
        this.status = BookingStatus.CREATED;
    }

}
