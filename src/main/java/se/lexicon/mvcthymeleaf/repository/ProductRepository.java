package se.lexicon.mvcthymeleaf.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.mvcthymeleaf.model.entity.Product;

import java.util.List;

public interface ProductRepository extends CrudRepository<Product, Integer> {

    @Override
    List<Product> findAll();

    List<Product> findAllByNameIgnoreCase(String name);

    //...

}
