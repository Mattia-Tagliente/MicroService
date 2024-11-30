package com.example.SupportTicketTechPlatform.dto;

import java.sql.Timestamp;

public class NewResolutionDto {

    private String ticketCode;
    private String resolutionNote;
    private Timestamp  noteDate;
    private String adminUsername;
    
    public NewResolutionDto() {
    }

    public String getTicketCode() {
        return ticketCode;
    }

    public void setTicketCode(String ticketCode) {
        this.ticketCode = ticketCode;
    }


    public String getResolutionNote() {
        return resolutionNote;
    }

    public void setResolutionPost(String resolutionNote) {
        this.resolutionNote = resolutionNote;
    }

    public Timestamp getNoteDate() {
        return noteDate;
    }

    public void setNoteDate(Timestamp noteDate) {
        this.noteDate = noteDate;
    }

    public String getAdminUsername() {
        return adminUsername;
    }

    public void setAdminUsername(String adminUsername) {
        this.adminUsername = adminUsername;
    }

    

}
