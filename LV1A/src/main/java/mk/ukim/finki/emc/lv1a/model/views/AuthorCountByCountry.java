package mk.ukim.finki.emc.lv1a.model.views;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import org.hibernate.annotations.Immutable;

@Entity
@Table(name = "author_count_by_country")
@Immutable
public class AuthorCountByCountry {
    @Id
    private Long countryId;

    private String countryName;

    private Long authorCount;

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public Long getAuthorCount() {
        return authorCount;
    }

    public void setAuthorCount(Long authorCount) {
        this.authorCount = authorCount;
    }
}
