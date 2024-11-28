package com.example.SupportTicketTechPlatform.dto;

import java.sql.Timestamp;

public class TicketStatusDto {

    String statusType;
    Timestamp postDate;
    
    public TicketStatusDto() {
    }

    public String getStatusType() {
        return statusType;
    }

    public void setStatusType(String statusType) {
        this.statusType = statusType;
    }

    public Timestamp getPostDate() {
        return postDate;
    }

    public void setTimestamp(Timestamp postDate) {
        this.postDate = postDate;
    }

    

}
