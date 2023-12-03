package com.sima.admin.controller;

import com.sima.admin.model.dto.AddCustomerDTO;
import com.sima.admin.model.dto.CustomerDTO;
import com.sima.admin.service.AdminCustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/admin")
public class AdminCustomerController {

    private final AdminCustomerService customerService;

    @Autowired
    public AdminCustomerController(AdminCustomerService customerService) {
        this.customerService = customerService;
    }

    @GetMapping("/get-customer")
    public ResponseEntity<CustomerDTO> getCustomer(@RequestParam Long id) {
        CustomerDTO customer = customerService.getCustomer(id);
        return ResponseEntity.ok(customer);
    }

    @PostMapping("/add-customer")
    public ResponseEntity<CustomerDTO> addCustomer(@RequestBody AddCustomerDTO customerDTO) {
        CustomerDTO response = customerService.addCustomer(customerDTO);
        return ResponseEntity.ok(response);
    }
}
