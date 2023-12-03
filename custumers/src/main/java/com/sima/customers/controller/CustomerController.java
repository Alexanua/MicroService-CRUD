package com.sima.customers.controller;

import com.sima.customers.model.dto.AddCustomerDTO;
import com.sima.customers.model.dto.CustomerDTO;

import com.sima.customers.model.dto.UpdateCustomerDTO;
import com.sima.customers.service.CustomerService;
import lombok.extern.slf4j.Slf4j;  // Korrekt Lombok-import
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@Slf4j  // Lombok genererar en log-instans
public class CustomerController {

    @Autowired
    private CustomerService customerService;


    @PostMapping("/add-customer")
    public AddCustomerDTO save(@RequestBody AddCustomerDTO dto){
        return  this.customerService.saveCustomer(dto);



    }



    @PutMapping("/update-customer")
    public UpdateCustomerDTO update(@RequestBody UpdateCustomerDTO dto){
        return this.customerService.updateCustomer(dto);


    }


    @DeleteMapping ("/delete-customer")
    public void delete(@RequestParam Long id){
        this.customerService.deleteCustomer(id);

        //localhost:8000/delete-customer?id=5


    }


    @GetMapping("/get-customer")
    public CustomerDTO get(@RequestParam Long id ){
        return this.customerService.getCustomerById(id);

        //localhost:8000/get-customer?id=5
    }

    // @GetMapping("/search/{name}")
    //public String getCustomerName(@PathVariable("name") String name) {
    //log.info("new request : " + UUID.randomUUID());

    //return this.customerService.getName(name)+ "   Service 1";
    // }
}