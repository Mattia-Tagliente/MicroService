package com.example.SupportTicketTechPlatform.mapper;

import java.security.Timestamp;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.example.SupportTicketTechPlatform.dto.NewTicketDto;
import com.example.SupportTicketTechPlatform.dto.TicketDto;
import com.example.SupportTicketTechPlatform.entity.Customer;
import com.example.SupportTicketTechPlatform.entity.Ticket;

public class TicketMapper {

    public TicketDto toDto(Ticket ticketEntity){
        
        TicketDto ticketDto = new TicketDto();

        Customer customer = ticketEntity.getCustomer();

        ticketDto.setCustomerName(customer.getCompanyName());
        ticketDto.setIssueDate(ticketEntity.getIssueDate());
        ticketDto.setTicketCode(ticketEntity.getTicketCode());
        ticketDto.setTicketDescription(ticketEntity.getTicketDescription());
        ticketDto.setTicketName(ticketEntity.getTicketName());

        return ticketDto;

    }

    public List<TicketDto> toDto(Iterable<Ticket> tickets){

        return StreamSupport.stream(tickets.spliterator(), false)
                .map(ticket -> {

                    TicketDto ticketDto = toDto(ticket);
                    return ticketDto;

                })
                .collect(Collectors.toList());   
    }

    public Ticket toEntity(NewTicketDto newTicketDto, Customer customer){
        
        Ticket newTicketEntity = new Ticket();

        newTicketEntity.setCustomer(customer);
        newTicketEntity.setIssueDate(newTicketDto.getIssueDate());
        newTicketEntity.setTicketCode(newTicketDto.getTicketCode());
        newTicketEntity.setTicketDescription(newTicketDto.getTicketDescription());
        newTicketEntity.setTicketDescription(newTicketDto.getTicketDescription());
        newTicketEntity.setTicketName(newTicketDto.getTicketName());

        return newTicketEntity;
    }


}
