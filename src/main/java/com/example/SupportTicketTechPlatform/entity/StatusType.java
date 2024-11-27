package com.example.SupportTicketTechPlatform.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "ticket_status_type")
public class StatusType {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "type_id")
    private int typeId;

    @Column(name = "status_name")
    private String statusName;


    public StatusType() {
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    public String getStatusName() {
        return statusName;
    }

    public void setStatusName(String statusName) {
        this.statusName = statusName;
    } 


}
