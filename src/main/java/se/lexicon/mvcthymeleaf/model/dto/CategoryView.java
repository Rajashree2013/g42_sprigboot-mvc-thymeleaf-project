package se.lexicon.mvcthymeleaf.model.dto;

import lombok.*;

import java.time.LocalDate;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoryView {

    private int id;
    private String name;
    private LocalDate createDate;



}
