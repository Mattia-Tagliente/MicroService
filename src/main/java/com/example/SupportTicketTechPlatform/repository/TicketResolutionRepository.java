package com.example.SupportTicketTechPlatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.SupportTicketTechPlatform.entity.TicketResolution;
import java.util.List;


public interface TicketResolutionRepository extends JpaRepository<TicketResolution, Integer>{

    @Query("SELECT tr FROM TicketResolution tr WHERE tr.ticket.ticketCode = ?1")
    List<TicketResolution> findResolutionbyTicketCode(String ticketCode);

}
