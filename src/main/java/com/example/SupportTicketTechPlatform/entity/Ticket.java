package com.example.SupportTicketTechPlatform.entity;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name="ticket")
public class Ticket {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int ticketId;

    @Column(name = "ticket_code", nullable = false, unique = true)
    private String ticketCode;

    @ManyToOne
    @JoinColumn(name = "ticket_customer", nullable = false)
    private Customer customer;

    @Column(name = "ticket_name", nullable = false)
    private String ticketName;

    @Column(name = "ticket_description", nullable = false)
    private String ticketDescription;

    @Column(name = "ticket_issue_date", nullable = false)
    private Timestamp issueDate;

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TicketResolution> resolutions = new ArrayList<>();

    @OneToMany(mappedBy = "ticket", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<TicketStatus> statuses = new ArrayList<>();

    public Ticket() {
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public String getTicketName() {
        return ticketName;
    }

    public void setTicketName(String ticketName) {
        this.ticketName = ticketName;
    }

    public String getTicketDescription() {
        return ticketDescription;
    }

    public void setTicketDescription(String ticketDescription) {
        this.ticketDescription = ticketDescription;
    }

    public List<TicketResolution> getResolutions() {
        return resolutions;
    }

    public void setResolutions(List<TicketResolution> resolutions) {
        this.resolutions = resolutions;
    }

    

}
