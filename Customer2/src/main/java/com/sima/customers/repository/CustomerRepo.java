package com.sima.customers.repository;


import com.sima.customers.model.entity.CustomerEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepo extends JpaRepository<CustomerEntity, Long> {
    // You can add custom methods if needed
}
