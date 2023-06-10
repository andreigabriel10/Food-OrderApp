package com.food.order.services;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.food.order.models.dtos.CustomerDTO;
import com.food.order.models.entities.Customer;
import com.food.order.repositories.CustomerRepository;
import jakarta.transaction.Transactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class CustomerServiceImpl implements CustomerService {

    private final ObjectMapper objectMapper;
    private final CustomerValidationService customerValidationService;
    private final CustomerRepository customerRepository;

    @Autowired
    public CustomerServiceImpl(ObjectMapper objectMapper,
                               CustomerValidationService customerValidationService,
                               CustomerRepository customerRepository) {
        this.objectMapper = objectMapper;
        this.customerValidationService = customerValidationService;
        this.customerRepository = customerRepository;
    }

    @Transactional
    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        customerValidationService.emailValidation(customerDTO.getEmail());
        Customer customer = objectMapper.convertValue(customerDTO, Customer.class);
        Customer savedCustomer = customerRepository.save(customer);



        log.info("Customer " + savedCustomer.getFirstName() + " was created.");
        return objectMapper.convertValue(savedCustomer, CustomerDTO.class);
    }
}
