package se.lexicon.mvcthymeleaf.service;

import se.lexicon.mvcthymeleaf.model.dto.CategoryForm;
import se.lexicon.mvcthymeleaf.model.dto.CategoryView;

import java.util.List;

public interface CategoryService {

    CategoryView findById(int id);

    CategoryView create(CategoryForm form);

    List<CategoryView> findAll();

    boolean delete(int id);

    int categoriesSize();

}
