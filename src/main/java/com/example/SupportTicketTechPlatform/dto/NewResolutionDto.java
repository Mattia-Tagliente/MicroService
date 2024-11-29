package com.example.SupportTicketTechPlatform.dto;

import java.sql.Timestamp;

public class NewResolutionDto {

    private int ticketId;
    private String resolutionPost;
    private Timestamp postDate;
    private int adminId;
    
    public NewResolutionDto() {
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }


    public String getResolutionPost() {
        return resolutionPost;
    }

    public void setResolutionPost(String resolutionPost) {
        this.resolutionPost = resolutionPost;
    }

    public Timestamp getPostDate() {
        return postDate;
    }

    public void setPostDate(Timestamp postDate) {
        this.postDate = postDate;
    }

    public int getAdminId() {
        return adminId;
    }

    public void setAdminId(int adminId) {
        this.adminId = adminId;
    }

    

}
