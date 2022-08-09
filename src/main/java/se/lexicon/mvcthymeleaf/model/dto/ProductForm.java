package se.lexicon.mvcthymeleaf.model.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.time.LocalDate;
@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductForm {

    private int id;
    @NotEmpty(message = "product name should not be empty!")
    @Size(min = 2, max = 200)
    private String name;
    private double price;
    @NotNull
    private Integer categoryId;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    @NotNull
    private LocalDate date;


}
