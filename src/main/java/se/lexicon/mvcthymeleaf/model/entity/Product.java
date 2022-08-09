package se.lexicon.mvcthymeleaf.model.entity;

import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;
@Setter
@Getter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode

@Entity
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;
    private double price;
    @ManyToOne(cascade = {CascadeType.REFRESH, CascadeType.DETACH}, fetch = FetchType.EAGER)
    private Category category;
    private LocalDate date;


    public Product(String name, double price, Category category, LocalDate date) {
        this.name = name;
        this.price = price;
        this.category = category;
        this.date = date;
    }


}
