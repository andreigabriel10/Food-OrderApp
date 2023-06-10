package com.food.order.services;

import com.food.order.models.dtos.ProductDTO;
import com.food.order.models.entities.Product;
import com.food.order.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductDTO> findProductByNameAndDescriptionAndPriceAndIngredients(String name, String description, double price, String ingredients) {
        List<Product> products = productRepository.findProductByNameAndDescriptionAndPriceAndIngredients(name, description, price, ingredients);
        List<ProductDTO> productDTOList = new ArrayList<>();
        products.forEach(product -> fromProductEntityToProductDTO(productDTOList, product));

        return productDTOList;
    }

    @Override
    public List<ProductDTO> findAllProducts() {
        List<ProductDTO> productDTOList = new ArrayList<>();
        productRepository.findAll().forEach(product -> fromProductEntityToProductDTO(productDTOList, product));

        return productDTOList;
    }

    @Override
    public void deleteProductById(long id) {
        productRepository.deleteById(id);
    }

    private void fromProductEntityToProductDTO(List<ProductDTO> productDTOS, Product product) {
        ProductDTO productDTO = new ProductDTO();
        productDTO.setId(product.getId());
        productDTO.setName(product.getName());
        productDTO.setDescription(product.getDescription());
        productDTO.setPrice(product.getPrice());
        productDTO.setIngredients(product.getIngredients());
        productDTOS.add(productDTO);
    }
}
