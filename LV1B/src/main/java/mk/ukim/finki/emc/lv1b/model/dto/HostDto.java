package mk.ukim.finki.emc.lv1b.model.dto;

import jakarta.persistence.ManyToOne;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import mk.ukim.finki.emc.lv1b.model.Country;

@Data
@Getter
@Setter
public class HostDto {

    private String name;

    private String surname;

    private Long country;

    public HostDto() {
    }

    public HostDto(String name, String surname, Long country) {
        this.name = name;
        this.surname = surname;
        this.country = country;
    }

}
