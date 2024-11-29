package com.example.SupportTicketTechPlatform.dto;

public class NewCustomerDto {

    private String companyName;
    private String vatNumber;
    
    public NewCustomerDto() {
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName= companyName;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    

}
