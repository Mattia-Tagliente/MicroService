package com.example.SupportTicketTechPlatform.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "customer")
public class Customer {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name = "customer_id")
    private int customerId;

    @Column(name = "denominazione_sociale")
    private String denominazioneSociale;

    @Column(name = "partita_iva")
    private String partitaIva;

    public Customer() {
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public String getDenominazioneSociale() {
        return denominazioneSociale;
    }

    public void setDenominazioneSociale(String denominazioneSociale) {
        this.denominazioneSociale = denominazioneSociale;
    }

    public String getPartitaIva() {
        return partitaIva;
    }

    public void setPartitaIva(String partitaIva) {
        this.partitaIva = partitaIva;
    }

}
