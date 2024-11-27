package com.example.SupportTicketTechPlatform.entity;


import java.sql.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name="ticket_resolution")
public class TicketResolution {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int resolutionId;

    @ManyToOne
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticket;

    @OneToOne
    @JoinColumn(name = "task_type", nullable = false)
    private TaskType taskType;

    @Column(name = "resolution_post", nullable = false)
    private String resolutionPost;

    @Column(name = "post_date", nullable = false)
    private Timestamp postDate;

    @Column(name = "admin_name", nullable = false)
    private String adminName;

    @Column(name = "admin_surname", nullable = false)
    private String adminSurname;

    @Column(name = "admin_email", nullable = false)
    private String adminEmail;

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

    public TaskType getTaskType() {
        return taskType;
    }

    public void setTaskType(TaskType taskType) {
        this.taskType = taskType;
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
