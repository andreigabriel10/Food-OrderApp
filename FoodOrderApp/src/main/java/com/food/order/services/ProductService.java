package com.food.order.services;

import com.food.order.models.dtos.ProductDTO;

import java.util.List;

public interface ProductService {

    List<ProductDTO> findProductByNameAndDescriptionAndPriceAndIngredients(String name, String description, double price, String ingredients);
    List<ProductDTO> findAllProducts();
    void deleteProductById(long id);
}
