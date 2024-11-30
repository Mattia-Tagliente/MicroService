package com.example.SupportTicketTechPlatform.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SupportTicketTechPlatform.dto.CustomerDto;
import com.example.SupportTicketTechPlatform.dto.NewCustomerDto;
import com.example.SupportTicketTechPlatform.entity.Customer;
import com.example.SupportTicketTechPlatform.mapper.CustomerMapper;
import com.example.SupportTicketTechPlatform.repository.CustomerRepository;

@Service
public class CustomerService {

    @Autowired
    CustomerMapper customerMapper;
    @Autowired
    CustomerRepository customerRepository;

    public List<CustomerDto>  getAllCustomers(){

        return customerMapper.toDto(customerRepository.findAll());

    }

    public Optional<CustomerDto> getCustomer(String vatNumber){

        Optional<Customer> customerEntity = customerRepository.findCustomerByVatNumber(vatNumber);

        if (customerEntity.isEmpty()){
            return Optional.empty();
        }
        
        CustomerDto customerDto = customerMapper.toDto(customerEntity.get());
        Optional<CustomerDto>  optional = Optional.of(customerDto);
        return optional;
    }

    public boolean addCustomer(NewCustomerDto newCustomerDto){

        String vatNumber = newCustomerDto.getVatNumber();
        Optional<CustomerDto> customer = getCustomer(vatNumber);
        if (customer.isEmpty()){

            customerRepository.save(customerMapper.toEntity(newCustomerDto));
            return true;
            
        }

        return false;
        
    }

}
