package com.example.SupportTicketTechPlatform.mapper;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Component;

import com.example.SupportTicketTechPlatform.dto.CustomerDto;
import com.example.SupportTicketTechPlatform.dto.NewCustomerDto;
import com.example.SupportTicketTechPlatform.dto.StatusTypeDto;
import com.example.SupportTicketTechPlatform.entity.Customer;

@Component
public class CustomerMapper {

    public CustomerDto toDto(Customer customerEntity){

        CustomerDto customerDto = new CustomerDto();

        customerDto.setCompanyName(customerEntity.getCompanyName());
        customerDto.setVatNumber(customerEntity.getVatNumber());

        return customerDto;
    }

    public List<CustomerDto> toDto(Iterable<Customer> customers){
        
        return StreamSupport.stream(customers.spliterator(), false)
                .map(customer -> {

                    CustomerDto customerDto = toDto(customer);
                    return customerDto;

                })
                .collect(Collectors.toList());

    }

    public Customer toEntity(NewCustomerDto newCustomerDto){

        Customer newCustomerEntity = new Customer();

        newCustomerEntity.setCompanyName(newCustomerDto.getCompanyName());
        newCustomerEntity.setVatNumber(newCustomerDto.getVatNumber());

        return newCustomerEntity;

    }

}
