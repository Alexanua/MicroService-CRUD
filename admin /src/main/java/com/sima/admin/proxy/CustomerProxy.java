package com.sima.admin.proxy;

import com.sima.admin.model.dto.AddCustomerDTO;
import com.sima.admin.model.dto.CustomerDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerProxy {
    @GetMapping("/get-customer")
    CustomerDTO getCustomer(@RequestParam Long id);


    @PostMapping("/add-customer")
    CustomerDTO addCustomer(@RequestBody AddCustomerDTO customerDTO);
}
//localhost:12000/admin/get-customer?id=5
