package com.example.SupportTicketTechPlatform.dto;

import java.sql.Timestamp;

public class NewTicketStatusDto {

    String ticketCode;
    int statusTypeId;
    Timestamp postDate;
    
    public NewTicketStatusDto() {
    }

    public int getStatusTypeId() {
        return statusTypeId;
    }

    public void setStatusTypeId(int statusTypeId) {
        this.statusTypeId = statusTypeId;
    }

    public Timestamp getPostDate() {
        return postDate;
    }

    public void setPostDate(Timestamp postDate) {
        this.postDate = postDate;
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }

    

    





}
