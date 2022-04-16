package com.microservice.microservice.domain.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "customers")
@AllArgsConstructor @NoArgsConstructor @Getter @Setter
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)

    private int id;
    @Column(nullable = false)
    private int dni;
    @Column(nullable = false, length = 30)
    private String name;
    @Column(nullable = false, length = 30)
    private String lastname;
    @Column(nullable = false)
    private int age;
    @Column(nullable = false, length = 30)
    private String birth;
    @Column(nullable = false)
    private Boolean isAlive;
}
