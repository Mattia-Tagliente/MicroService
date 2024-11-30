package com.example.SupportTicketTechPlatform.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import com.example.SupportTicketTechPlatform.entity.Ticket;

import jakarta.transaction.Transactional;

public interface TicketRepository extends JpaRepository<Ticket, Integer> {

    @Query("SELECT t FROM Ticket t WHERE t.customer.vatNumber = ?1")
    List<Ticket> findTicketByCustomerVatNumber(String customerVatNumber);

    @Query("SELECT t FROM Ticket t WHERE t.ticketCode = ?1")
    Optional<Ticket> findTicketByTicketCode(String ticketCode);

    @Modifying
    @Transactional
    @Query("DELETE FROM Ticket t WHERE t.ticketCode = ?1")
    void removeTicket(String ticketCode);
}
