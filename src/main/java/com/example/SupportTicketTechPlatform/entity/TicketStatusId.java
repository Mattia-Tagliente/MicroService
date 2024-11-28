package com.example.SupportTicketTechPlatform.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Embeddable
public class TicketStatusId implements Serializable {

    @ManyToOne
    @JoinColumn(name = "ticket_id", nullable = false)
    private Ticket ticketId;

    @ManyToOne
    @JoinColumn(name = "status_type", referencedColumnName = "type_id", nullable = false)
    private StatusType typeId;

    public TicketStatusId() {}

    public TicketStatusId(Ticket ticketId, StatusType typeId) {
        this.ticketId = ticketId;
        this.typeId = typeId;
    }

    public Ticket getTicketId() {
        return ticketId;
    }

    public void setTicketId(Ticket ticketId) {
        this.ticketId = ticketId;
    }

    public StatusType getTypeId() {
        return typeId;
    }

    public void setTypeId(StatusType typeId) {
        this.typeId = typeId;
    }    

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((ticketId == null) ? 0 : ticketId.hashCode());
        result = prime * result + ((typeId == null) ? 0 : typeId.hashCode());
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
        if (ticketId == null) {
            if (other.ticketId != null)
                return false;
        } else if (!ticketId.equals(other.ticketId))
            return false;
        if (typeId == null) {
            if (other.typeId != null)
                return false;
        } else if (!typeId.equals(other.typeId))
            return false;
        return true;
    }

    

}
