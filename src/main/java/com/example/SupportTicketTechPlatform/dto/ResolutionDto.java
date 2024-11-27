package com.example.SupportTicketTechPlatform.dto;

import java.sql.Timestamp;

public class ResolutionDto {

    private String taskName;
    private String resolutionPost;
    private Timestamp postDate;
    private String adminName;
    private String adminSurname;
    private String adminEmail;
    
    public ResolutionDto() {
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
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

    public String getAdminName() {
        return adminName;
    }

    public void setAdminName(String adminName) {
        this.adminName = adminName;
    }

    public String getAdminSurname() {
        return adminSurname;
    }

    public void setAdminSurname(String adminSurname) {
        this.adminSurname = adminSurname;
    }

    public String getAdminEmail() {
        return adminEmail;
    }

    public void setAdminEmail(String adminEmail) {
        this.adminEmail = adminEmail;
    }

    

}
