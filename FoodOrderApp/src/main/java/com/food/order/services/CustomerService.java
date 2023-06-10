package com.food.order.services;

import com.food.order.models.dtos.CustomerDTO;

public interface CustomerService {

    CustomerDTO createCustomer(CustomerDTO customerDTO);
}
