package com.microservice.microservice.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class CustomerDto {
    private Long id;
    private Number dni;
    private String name;
    private String lastname;
    private Number age;
    private String birth;
    private Boolean isAlive;
}

