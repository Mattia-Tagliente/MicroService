package com.example.SupportTicketTechPlatform.dto;

public class NewCustomerDto {

    private String denominazioneSociale;
    private String partitaIva;
    
    public NewCustomerDto() {
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
