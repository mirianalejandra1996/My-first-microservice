package com.microservice.microservice.domain.service;


import com.microservice.microservice.common.dto.CustomerDto;
import com.microservice.microservice.domain.entity.Customer;

import java.util.List;

public interface CustomerService {
    // Creation of methods of CategoryCustomer interface.
    List<Customer> findAllCustomers();
    Customer findCustomerById (Long id);
    Customer createCustomer (CustomerDto customerDto);
    Customer updateCustomer (CustomerDto customerDto);

    void deleteCustomerById(Long id);
}
