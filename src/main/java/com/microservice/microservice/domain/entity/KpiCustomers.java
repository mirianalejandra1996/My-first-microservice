package com.microservice.microservice.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.Entity;
import javax.persistence.Id;
import java.math.BigDecimal;

@Entity
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class KpiCustomers {
    @Id
    private BigDecimal averageAge;
    private BigDecimal devStandardAge;
}

