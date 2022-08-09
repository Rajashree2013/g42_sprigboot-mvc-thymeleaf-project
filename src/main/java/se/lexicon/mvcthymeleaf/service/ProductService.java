package se.lexicon.mvcthymeleaf.service;

import se.lexicon.mvcthymeleaf.model.dto.ProductForm;
import se.lexicon.mvcthymeleaf.model.dto.ProductView;

import java.util.List;

public interface ProductService {

    List<ProductView> findAll();

    ProductView findById(int id);

    ProductView create(ProductForm productForm);

    int productListSize();

    ProductView update(ProductForm productForm);

    boolean delete(int id);
}
