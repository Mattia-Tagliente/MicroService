package com.example.SupportTicketTechPlatform.dto;

import java.sql.Timestamp;

public class NewTicketDto {

    private String ticketCode;
    private String customerVatNumber;
    private String ticketName;
    private String ticketDescription;
    private Timestamp issueDate;
    
    public NewTicketDto() {
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    public String getCustomerVatNumber() {
        return customerVatNumber;
    }

    public void setCustomerId(String customerVatNumber) {
        this.customerVatNumber = customerVatNumber;
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

    public Timestamp getIssueDate() {
        return issueDate;
    }

    public void setIssueDate(Timestamp issueDate) {
        this.issueDate = issueDate;
    }

    

}
