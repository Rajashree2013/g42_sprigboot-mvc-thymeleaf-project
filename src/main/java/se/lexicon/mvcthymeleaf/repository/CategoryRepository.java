package se.lexicon.mvcthymeleaf.repository;

import org.springframework.data.repository.CrudRepository;
import se.lexicon.mvcthymeleaf.model.entity.Category;

import java.util.List;
import java.util.Optional;

public interface CategoryRepository extends CrudRepository<Category, Integer> {

    Optional<Category> findByName(String name);

    List<Category> findAll();

}
