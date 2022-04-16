package com.microservice.microservice.domain.service.implementation;

import com.microservice.microservice.common.dto.CustomerDto;
import com.microservice.microservice.domain.entity.Customer;
import com.microservice.microservice.domain.service.CustomerService;
import com.microservice.microservice.persistence.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.dao.DuplicateKeyException;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;

//In this file I will import my repository file (CustomerRepository)
//Here's the logic of my app
@Service
@RequiredArgsConstructor
public class CustomerImpl implements CustomerService {

    private final CustomerRepository customerRepository;

    //void will not return anything
    // private void customerExist(Long id){
    private void customerDniExist(int dni){
        //if (customerRepository.existsById(id)){
        if (customerRepository.existsByDni(dni)){
            throw new DuplicateKeyException("The dni of the customer is already registered");
        }
    }


    @Override
    public List<Customer> findAllCustomers() {
        // findAll() is iterable, that's why we put (List<Customer>)
        return (List<Customer>) customerRepository.findAll();
    }

    @Override
    public Customer findCustomerById(int id) {

        //In case if customerNotExist I can create this variable "Customer"
        Customer customer = customerRepository.findCustomerById(id);
        if (customer == null ){
            throw new EntityNotFoundException("The customer with id " + id + " is not found");
        }
        return customer;
    }

    @Override
    public Customer createCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        // I have to check first if this new customer already existed, so I've created the "customerExist" method
        //this.customerExist(customerDto.getId());
        this.customerDniExist(customerDto.getDni());
        // With Bean, we can pass the values properties of customerDto to Customer Entity
        BeanUtils.copyProperties(customerDto, customer);
        return customerRepository.save(customer);
    }

    @Override
    public Customer updateCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();

        this.findCustomerById(customerDto.getId());

        BeanUtils.copyProperties(customerDto, customer);
        return customerRepository.save(customer);
    }

    @Override
    public void deleteCustomerById(int id){
        this.findCustomerById(id);
        customerRepository.deleteById(id);
    }
}
