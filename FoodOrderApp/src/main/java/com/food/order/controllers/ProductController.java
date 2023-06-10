package com.food.order.controllers;

import com.food.order.models.dtos.ProductDTO;
import com.food.order.services.ProductService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@CrossOrigin(origins = "http://localhost:3000")
@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService productService;

    @Autowired
    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/filter")
    public ResponseEntity<List<ProductDTO>> findProductByNameAndDescriptionAndPriceAndIngredients(@RequestParam(required = false) String name,
                                                                                                  @RequestParam(required = false) String description,
                                                                                                  @RequestParam(required = false) Double price,
                                                                                                  @RequestParam(required = false) String ingredients) {
        return ResponseEntity.ok(productService.findProductByNameAndDescriptionAndPriceAndIngredients(name, description, price, ingredients));
    }

    @DeleteMapping("/{id}")
    public void deleteProductById(@PathVariable long id) {
        log.info("Product with id " + id + " was deleted.");
        productService.deleteProductById(id);
    }

    @GetMapping
    public ResponseEntity<List<ProductDTO>> findAllProducts() {
        log.info("Products retrieved.");
        return ResponseEntity.ok(productService.findAllProducts());
    }
}
