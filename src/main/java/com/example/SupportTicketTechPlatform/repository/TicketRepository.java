package com.example.SupportTicketTechPlatform.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.SupportTicketTechPlatform.entity.Ticket;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    @Query("SELECT t FROM Ticket t WHERE t.customer.vatNumber = ?1")
    List<Ticket> findTicketByCustomerVatNumber(String customerVatNumber);

    
}
