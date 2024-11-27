package com.example.SupportTicketTechPlatform.dto;

import java.sql.Timestamp;

public class NewTicketStatusDto {

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

    





}
