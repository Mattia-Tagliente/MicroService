package com.example.SupportTicketTechPlatform.entity;

import java.io.Serializable;

import jakarta.persistence.Embeddable;

@Embeddable
public class TicketStatusId implements Serializable {

    private int ticketId;
    private int typeId;

    public TicketStatusId() {}

    public TicketStatusId(int ticketId, int typeId) {
        this.ticketId = ticketId;
        this.typeId = typeId;
    }

    public int getTicketId() {
        return ticketId;
    }

    public void setTicketId(int ticketId) {
        this.ticketId = ticketId;
    }

    public int getTypeId() {
        return typeId;
    }

    public void setTypeId(int typeId) {
        this.typeId = typeId;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ticketId;
        result = prime * result + typeId;
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        TicketStatusId other = (TicketStatusId) obj;
        if (ticketId != other.ticketId)
            return false;
        if (typeId != other.typeId)
            return false;
        return true;
    }

    

}
