package com.food.order.repositories;

import com.food.order.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    List<Product> findProductByNameAndDescriptionAndPriceAndIngredients(String name, String description, double price, String ingredients);
}
