package com.microservice.microservice.persistence.repository;

import com.microservice.microservice.domain.entity.Customer;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends CrudRepository<Customer, Long> {
    //Methods that will be the database request

    // Find a customer by id
    Customer findCustomerById(Long id);

    Boolean existsByDni(Number dni);


}
