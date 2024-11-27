package com.example.SupportTicketTechPlatform.entity;

import java.time.LocalDateTime;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.MapsId;
import jakarta.persistence.Table;

@Entity
@Table(name = "ticket_status")
public class TicketStatus {

    @EmbeddedId
    private TicketStatusId ticketStatusId;

    @ManyToOne
    @MapsId("ticketId") 
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

    @ManyToOne
    @MapsId("typeId") 
    @JoinColumn(name = "status_type", referencedColumnName = "type_id", nullable = false)
    private StatusType statusType;

    @Column(name = "status_date", nullable = false)
    private LocalDateTime timestamp;

    public TicketStatus() {
    }

    public TicketStatusId getTicketStatusId() {
        return ticketStatusId;
    }

    public void setTicketStatusId(TicketStatusId ticketStatusId) {
        this.ticketStatusId = ticketStatusId;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public StatusType getStatusType() {
        return statusType;
    }

    public void setStatusType(StatusType statusType) {
        this.statusType = statusType;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    



}
