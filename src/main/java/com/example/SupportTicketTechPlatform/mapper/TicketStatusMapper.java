package com.example.SupportTicketTechPlatform.mapper;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.example.SupportTicketTechPlatform.dto.NewTicketStatusDto;
import com.example.SupportTicketTechPlatform.dto.StatusTypeDto;
import com.example.SupportTicketTechPlatform.dto.TicketStatusDto;
import com.example.SupportTicketTechPlatform.entity.StatusType;
import com.example.SupportTicketTechPlatform.entity.Ticket;
import com.example.SupportTicketTechPlatform.entity.TicketStatus;

public class TicketStatusMapper {

    public TicketStatusDto toDto(TicketStatus status){
        
        StatusType statusType = status.getStatusType();

        TicketStatusDto statusDto = new TicketStatusDto();
        statusDto.setStatusType(statusType.getStatusName());
        statusDto.setPostDate(status.getPostDate());
        return statusDto;
    }

    List<TicketStatusDto> toDto(Iterable<TicketStatus> statuses){
        return StreamSupport.stream(statuses.spliterator(), false)
        .map(status -> {
            
            StatusType statusType = status.getStatusType();
            TicketStatusDto ticketStatusDto = new TicketStatusDto();
            ticketStatusDto.setStatusType(statusType.getStatusName());
            ticketStatusDto.setPostDate(status.getPostDate());

            return ticketStatusDto;

        })
        .collect(Collectors.toList());
    } ;

    public TicketStatus toEntity(
    NewTicketStatusDto newTicketStatusDto, 
    Ticket ticket, 
    StatusType statusType ){

        TicketStatus newTicketStatus = new TicketStatus();
        newTicketStatus.setTicket(ticket);
        newTicketStatus.setStatusType(statusType);
        newTicketStatus.setPostDate(newTicketStatusDto.getPostDate());
        
        return newTicketStatus;

    }

}
