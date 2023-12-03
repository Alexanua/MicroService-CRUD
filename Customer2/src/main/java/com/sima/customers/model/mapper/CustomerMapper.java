package com.sima.customers.model.mapper;

import com.sima.customers.model.dto.AddCustomerDTO;
import com.sima.customers.model.dto.CustomerDTO;
import com.sima.customers.model.dto.UpdateCustomerDTO;
import com.sima.customers.model.entity.CustomerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface CustomerMapper {

    CustomerMapper INSTANCE = Mappers.getMapper(CustomerMapper.class);

    CustomerDTO toDto(CustomerEntity entity);
    CustomerEntity toEntity(CustomerDTO dto);

    AddCustomerDTO toAddDto(CustomerEntity entity);
    CustomerEntity toEntity(AddCustomerDTO dto);

    UpdateCustomerDTO toUpdateDto(CustomerEntity entity);
    CustomerEntity toEntity(UpdateCustomerDTO dto);
}
