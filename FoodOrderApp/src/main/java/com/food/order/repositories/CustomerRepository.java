package com.food.order.repositories;

import com.food.order.models.entities.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long> {


    List<Customer> findByFirstNameAndLastNameAndEmail(String firstName, String lastName, String email);


    @Query(value = "SELECT * FROM customers WHERE first_name = :firstName AND last_name = :lastName AND email = :email", nativeQuery = true)
    List<Customer> findByFirstNameAndLastNameAndEmail2(String firstName, String lastName, String email);


}
