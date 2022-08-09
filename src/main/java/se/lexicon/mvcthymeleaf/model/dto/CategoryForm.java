package se.lexicon.mvcthymeleaf.model.dto;


import lombok.*;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Setter
@Getter
@AllArgsConstructor
@NoArgsConstructor
@ToString
public class CategoryForm {

    @NotEmpty(message = "category name must not be empty")
    @Size(min = 2, max = 20, message = "category name must be between 2 to 20")
    private String name;

}
