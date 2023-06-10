package com.food.order.repositories;

import com.food.order.models.entities.Customer;
import com.food.order.models.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerProductRepository extends JpaRepository<Product, Long> {

    @Query(value = "SELECT products. * FROM products JOIN customers_products ON products.id = customers_products.products_id WHERE customers_products.customers_id = :productId",
            nativeQuery = true)
    List<Customer> findProductsByCustomerId(@Param("productId") Long customerId);
}
