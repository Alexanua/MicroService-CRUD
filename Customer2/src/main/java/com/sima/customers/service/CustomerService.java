package com.sima.customers.service;

import com.sima.customers.model.dto.AddCustomerDTO;
import com.sima.customers.model.dto.CustomerDTO;
import com.sima.customers.model.dto.UpdateCustomerDTO;
import com.sima.customers.model.entity.CustomerEntity;
import com.sima.customers.model.mapper.CustomerMapper;
import com.sima.customers.repository.CustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.persistence.EntityNotFoundException;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class CustomerService {

    private final CustomerRepo customerRepository;
    private final CustomerMapper customerMapper ;

    @Autowired
    public CustomerService(CustomerRepo customerRepository, CustomerMapper customerMapper) {
        this.customerRepository = customerRepository;
        this.customerMapper = customerMapper;
    }

    public List<CustomerDTO> findAllCustomers() {
        return customerRepository.findAll().stream()
                .map(customerMapper::toDto)
                .collect(Collectors.toList());
    }

    public CustomerDTO getCustomerById(Long id) {
        CustomerEntity customerEntity = customerRepository.findById(id)
                .orElseThrow(() -> new EntityNotFoundException("Customer not found with id: " + id));
        return customerMapper.toDto(customerEntity);
    }

    public AddCustomerDTO saveCustomer(AddCustomerDTO dto) {
        CustomerEntity customerEntity = customerMapper.toEntity(dto);
        CustomerEntity savedCustomer = customerRepository.save(customerEntity);
        return customerMapper.toAddDto(savedCustomer);
    }

    public UpdateCustomerDTO updateCustomer(UpdateCustomerDTO dto) {
        CustomerEntity customerEntity = customerMapper.toEntity(dto);
        CustomerEntity updatedCustomer = customerRepository.save(customerEntity);
        return customerMapper.toUpdateDto(updatedCustomer);
    }

    public void deleteCustomer(Long id) {
        if (!customerRepository.existsById(id)) {
            throw new EntityNotFoundException("Customer not found with id: " + id);
        }
        customerRepository.deleteById(id);
    }


}
