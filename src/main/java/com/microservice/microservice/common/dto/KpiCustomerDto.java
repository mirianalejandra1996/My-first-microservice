package com.microservice.microservice.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class KpiCustomerDto {

    private BigDecimal averageAge;
    private BigDecimal devStandardAge;
}
