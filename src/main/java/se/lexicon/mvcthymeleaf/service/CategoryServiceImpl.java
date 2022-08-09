package se.lexicon.mvcthymeleaf.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import se.lexicon.mvcthymeleaf.converter.CategoryConverter;
import se.lexicon.mvcthymeleaf.model.dto.CategoryForm;
import se.lexicon.mvcthymeleaf.model.dto.CategoryView;
import se.lexicon.mvcthymeleaf.model.entity.Category;
import se.lexicon.mvcthymeleaf.repository.CategoryRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class CategoryServiceImpl implements CategoryService {

    CategoryRepository repository;
    CategoryConverter converter;

    @Autowired
    public CategoryServiceImpl(CategoryRepository repository, CategoryConverter converter) {
        this.repository = repository;
        this.converter = converter;
    }

    @Override
    public CategoryView findById(int id) {
        if (id == 0) throw new IllegalArgumentException("id is not valid");
        Optional<Category> categoryOptional = repository.findById(id);

        if (categoryOptional.isPresent()) {
            Category categoryEntity = categoryOptional.get();

            CategoryView categoryView = converter.toView(categoryEntity);

            return categoryView;
        } else {
            return null;
        }

    }

    @Override
    public CategoryView create(CategoryForm form) {
        if (form == null) throw new IllegalArgumentException("Category Form data is null");
        Category convertedToEntity = new Category(form.getName());

        Category createdCategory = repository.save(convertedToEntity);


        CategoryView convertedToView = converter.toView(createdCategory);

        return convertedToView;
    }

    @Override
    public List<CategoryView> findAll() {
       List<Category> entities = repository.findAll();
        return new ArrayList<>(converter.toViews(entities));
    }

    @Override
    public boolean delete(int id) {
        if (findById(id) != null){
            repository.deleteById(id);
            return true;
        }
        return false;
    }

    @Override
    public int categoriesSize() {
        return findAll().size();
    }
}
