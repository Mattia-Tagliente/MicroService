package com.example.SupportTicketTechPlatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.SupportTicketTechPlatform.entity.TicketStatus;
import com.example.SupportTicketTechPlatform.entity.TicketStatusId;

public interface TicketStatusRepository extends JpaRepository<TicketStatus, TicketStatusId>{

    @Query("SELECT t FROM TicketStatus t WHERE ticket.ticketCode = ?1")
    TicketStatus getTicketStatusByTicketCode(String ticketCode);

}
