package com.microservice.microservice.domain.service.implementation;

import com.microservice.microservice.domain.entity.Customer;
import com.microservice.microservice.domain.entity.KpiCustomers;
import com.microservice.microservice.domain.service.CustomerService;
import com.microservice.microservice.domain.service.KpiCustomerService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;

@Service
@RequiredArgsConstructor
public class KpiCustomerImpl implements KpiCustomerService {
    private final CustomerService customerService;

    public KpiCustomers calculateKpi() {
        List<Customer> listAllCustomers = customerService.findAllCustomers();

        //Calculate media (average)
        double suma = 0;
        for(Customer customer : listAllCustomers) {
            int edad = customer.getAge();
            suma = (suma + edad);
        }

        double media = suma / listAllCustomers.size();

        //Calculate variance
        double variance = 0;
        double summation = 0;

        for(Customer customer : listAllCustomers) {
            int age = customer.getAge();
            summation = Math.pow(age - media, 2);
            variance = variance + summation;
        }

        variance = variance / (listAllCustomers.size() - 1);

        //Calculate deviation
        double deviation = Math.sqrt(variance);

        KpiCustomers result = new KpiCustomers();

        result.setAverageAge(new BigDecimal(media));
        result.setDevStandardAge(new BigDecimal(deviation));

        return result;
    }
}
