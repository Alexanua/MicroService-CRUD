package com.sima.customers.model.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;

@Entity
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor

@Table(name = "Customers")
public class CustomerEntity {
    @Id
    @Column(name ="id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name= "customer_name")
    private String customerName;

    @Column(name = "customer_age")
    private Integer customerAge;
}