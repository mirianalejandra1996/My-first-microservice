package com.microservice.microservice.common.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class CustomerDto {
    private int id;
    private int dni;
    private String name;
    private String lastname;
    private int age;
    private String birth;
    private Boolean isAlive;
}

