package se.lexicon.mvcthymeleaf.model.dto;

import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class ProductView {

    private int id;
    private String name;
    private double price;
    private CategoryView categoryView;
    @DateTimeFormat(iso = DateTimeFormat.ISO.DATE)
    private LocalDate date;



}
