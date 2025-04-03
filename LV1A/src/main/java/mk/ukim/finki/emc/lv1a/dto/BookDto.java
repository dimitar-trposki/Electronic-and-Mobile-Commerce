package mk.ukim.finki.emc.lv1a.dto;

import lombok.Data;

@Data
public class BookDto {

    private String title;

    private String category;

    private Long author;

    private Integer availableCopies;

    private boolean deleted;

    public BookDto() {
    }

    public BookDto(String title, String category, Long author, Integer availableCopies) {
        this.title = title;
        this.category = category;
        this.author = author;
        this.availableCopies = availableCopies;
        this.deleted = false;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    public Long getAuthor() {
        return author;
    }

    public void setAuthor(Long author) {
        this.author = author;
    }

    public Integer getAvailableCopies() {
        return availableCopies;
    }

    public void setAvailableCopies(Integer availableCopies) {
        this.availableCopies = availableCopies;
    }

    public boolean isDeleted() {
        return deleted;
    }

    public void setDeleted(boolean deleted) {
        this.deleted = deleted;
    }
}
