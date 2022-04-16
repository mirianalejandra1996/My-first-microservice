package com.microservice.microservice.web.controller;

import com.microservice.microservice.common.dto.CustomerDto;
import com.microservice.microservice.domain.entity.Customer;
import com.microservice.microservice.domain.service.CustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("v1/customers")
@RequiredArgsConstructor
public class CustomerController {
    private final CustomerService customerService;

    @RequestMapping("listclientes")
    @GetMapping(produces = "application/json")
    public ResponseEntity<List<Customer>> getAllCustomers(){
        //My package web will the domain packages (Where is all the business app logic)
        return new ResponseEntity<>(customerService.findAllCustomers(), HttpStatus.OK );
    }

    @RequestMapping("getById/{id}")
    @GetMapping(value = "/{id}", produces = "application/json")
    public ResponseEntity<Customer> getCustomerById(@PathVariable("id") int id){
        return new ResponseEntity<>(customerService.findCustomerById(id), HttpStatus.OK );
    }

    @RequestMapping("creacliente")
    @PostMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Customer> createCustomer(@RequestBody CustomerDto customerDto){
        return new ResponseEntity<>(customerService.createCustomer(customerDto), HttpStatus.CREATED );
    }

    @RequestMapping("updatecliente")
    @PutMapping(consumes = "application/json", produces = "application/json")
    public ResponseEntity<Customer> updateCustomer(@RequestBody CustomerDto customerDto){
        return new ResponseEntity<>(customerService.updateCustomer(customerDto), HttpStatus.OK );
    }

    @RequestMapping("deletecliente")
    @DeleteMapping( value = "/{id}")
    public ResponseEntity deleteCustomerById(@PathVariable("id") Integer id){
        customerService.deleteCustomerById(id);
        return new ResponseEntity(HttpStatus.OK );
    }
}
