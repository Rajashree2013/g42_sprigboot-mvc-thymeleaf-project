package se.lexicon.mvcthymeleaf.converter;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import se.lexicon.mvcthymeleaf.model.dto.CategoryView;
import se.lexicon.mvcthymeleaf.model.dto.ProductView;
import se.lexicon.mvcthymeleaf.model.entity.Category;
import se.lexicon.mvcthymeleaf.model.entity.Product;

import java.util.Collection;
import java.util.stream.Collectors;

@Component
public class ProductConverter implements Converter<Product, ProductView> {

    CategoryConverter categoryConverter;

    @Autowired
    public ProductConverter(CategoryConverter categoryConverter) {
        this.categoryConverter = categoryConverter;
    }

    @Override
    public ProductView toView(Product entity) {
        CategoryView categoryView = categoryConverter.toView(entity.getCategory());
        ProductView view = new ProductView(entity.getId(), entity.getName(), entity.getPrice(), categoryView, entity.getDate());
        return view;
    }

    @Override
    public Product toEntity(ProductView view) {
        Category category = categoryConverter.toEntity(view.getCategoryView());
        Product entity = new Product(view.getId(), view.getName(), view.getPrice(), category, view.getDate());
        return entity;
    }

    @Override
    public Collection<ProductView> toViews(Collection<Product> entities) {
        return entities.stream().map(this::toView).collect(Collectors.toList());
    }

    @Override
    public Collection<Product> toEntities(Collection<ProductView> views) {
        return views.stream().map(this::toEntity).collect(Collectors.toList());
    }


}
