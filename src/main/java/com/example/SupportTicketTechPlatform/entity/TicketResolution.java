package com.example.SupportTicketTechPlatform.entity;


import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ticket_resolution")
public class TicketResolution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="resolution_id")
    private int resolutionId;

    @ManyToOne
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

    @Column(name = "resolution_post", nullable = false)
    private String resolutionPost;

    @Column(name = "post_date", nullable = false)
    private Timestamp postDate;

    @ManyToOne
    @JoinColumn(name = "admin_id", nullable = false)
    private User admin;

    public TicketResolution() {
    }

    public int getResolutionId() {
        return resolutionId;
    }

    public void setResolutionId(int resolutionId) {
        this.resolutionId = resolutionId;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
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

    public User getAdmin() {
        return admin;
    }

    public void setAdmin(User admin) {
        this.admin = admin;
    }

    

}
