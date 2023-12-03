package com.sima.admin.service;

import com.sima.admin.model.dto.AddCustomerDTO;
import com.sima.admin.model.dto.CustomerDTO;
import com.sima.admin.proxy.CustomerProxy;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AdminCustomerService {

    private final CustomerProxy customerProxy;

    @Autowired
    public AdminCustomerService(CustomerProxy customerProxy) {
        this.customerProxy = customerProxy;
    }

    public CustomerDTO getCustomer(Long id) {
        return customerProxy.getCustomer(id);
    }

    public CustomerDTO addCustomer(AddCustomerDTO customerDTO) {
        return customerProxy.addCustomer(customerDTO);
    }
}
