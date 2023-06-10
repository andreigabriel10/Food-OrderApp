package com.food.order.models.dtos;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

@Data
public class ProductDTO implements Serializable {

    private long id;
    private String name;
    private String description;
    private double price;
    private String category;
    private List<String> ingredients;
}
