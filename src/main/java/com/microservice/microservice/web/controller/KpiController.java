package com.microservice.microservice.web.controller;

import com.microservice.microservice.domain.entity.Customer;
import com.microservice.microservice.domain.entity.KpiCustomers;
import com.microservice.microservice.domain.service.CustomerService;
import com.microservice.microservice.domain.service.KpiCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("kpideclientes")
@RequiredArgsConstructor
public class KpiController {

    private final KpiCustomerService kpiCustomerService;

    private final CustomerService customerService;

    @GetMapping(produces = "application/json")
    public ResponseEntity<KpiCustomers> getKPI(){
        List<Customer> lista = customerService.findAllCustomers();
        //My package web will the domain packages (Where is all the business app logic)
        return new ResponseEntity<>(kpiCustomerService.calculateKpi(), HttpStatus.OK );
    }
}
