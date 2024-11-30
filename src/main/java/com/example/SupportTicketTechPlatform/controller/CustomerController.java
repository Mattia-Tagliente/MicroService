package com.example.SupportTicketTechPlatform.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SupportTicketTechPlatform.dto.CustomerDto;
import com.example.SupportTicketTechPlatform.dto.NewCustomerDto;
import com.example.SupportTicketTechPlatform.service.CustomerService;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("api/v1/app/customer")
public class CustomerController {

    @Autowired
    CustomerService customerService;

    @GetMapping()
    public ResponseEntity<List<CustomerDto>> getCustomers() {
        
        List<CustomerDto> result = customerService.getAllCustomers();

        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @GetMapping("/{vatNumber}")
    public ResponseEntity<CustomerDto> getCustomerByVat(@PathVariable String vatNumber) {
        
        Optional<CustomerDto> result = customerService.getCustomer(vatNumber);

        if (result.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result.get(), HttpStatus.OK);

    }

    @PostMapping("/new")
    public ResponseEntity<Boolean> addCustomer(@RequestBody NewCustomerDto newCustomerDto) {
        
        boolean result = customerService.addCustomer(newCustomerDto);

        if (result == false){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }
        
        return new ResponseEntity<>(result, HttpStatus.OK);

    }
    
    
    

}
