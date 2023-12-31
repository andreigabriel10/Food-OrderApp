package com.food.order.services;

import org.springframework.stereotype.Service;

@Service
public class CustomerValidationServiceImpl implements CustomerValidationService {

    @Override
    public void emailValidation(String email) {
        if(!email.trim().contains("@") || email.trim().length() < 5){
            throw new RuntimeException("Email is not valid.");
        }
    }
}
