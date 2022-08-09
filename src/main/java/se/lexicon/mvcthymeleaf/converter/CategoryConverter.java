package se.lexicon.mvcthymeleaf.converter;

import org.springframework.stereotype.Component;
import se.lexicon.mvcthymeleaf.model.dto.CategoryView;
import se.lexicon.mvcthymeleaf.model.entity.Category;

import javax.swing.text.html.parser.Entity;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class CategoryConverter implements Converter<Category, CategoryView> {


    @Override
    public CategoryView toView(Category entity) {
        return new CategoryView(entity.getId(), entity.getName(), entity.getCreateDate());
    }

    @Override
    public Category toEntity(CategoryView view) {
        return new Category(view.getId(), view.getName(), view.getCreateDate());
    }

    @Override
    public Collection<CategoryView> toViews(Collection<Category> entities) {
        /*List<CategoryView> views = new ArrayList<>();
        for(Category entity : entities){
            views.add(toView(entity));
        }
        return views;*/
        //return entities.stream().map(entity -> toView(entity)).collect(Collectors.toList());
        return entities.stream().map(this::toView).collect(Collectors.toList());
    }

    @Override
    public Collection<Category> toEntities(Collection<CategoryView> views) {
        /*List<Category> entities = new ArrayList<>();
        for (CategoryView view : views){
            //Category entity = toEntity(view);
            entities.add(toEntity(view));
        }
        return entities;*/
        return views.stream().map(this::toEntity).collect(Collectors.toList());
    }
}
