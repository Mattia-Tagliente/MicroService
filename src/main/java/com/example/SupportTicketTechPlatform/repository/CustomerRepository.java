package com.example.SupportTicketTechPlatform.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.SupportTicketTechPlatform.entity.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Integer> {

    @Query("SELECT c FROM Customer c WHERE c.vatNumber = ?1")
    Optional<Customer> findCustomerByVatNumber(String vatNumber);

}
