package ua.mate.hwspringboot.dto;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class BookDto {
    @NotNull
    @NotEmpty
    private String title;

    @NotNull
    @NotEmpty
    private Double price;

    @NotNull
    @NotEmpty
    private Integer year;
    private String description;

    public BookDto(@NotNull @NotEmpty String title, @NotNull @NotEmpty Double price, @NotNull @NotEmpty Integer year) {
        this.title = title;
        this.price = price;
        this.year = year;
    }
}
