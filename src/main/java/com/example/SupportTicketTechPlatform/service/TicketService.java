package com.example.SupportTicketTechPlatform.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SupportTicketTechPlatform.dto.NewTicketDto;
import com.example.SupportTicketTechPlatform.dto.NewTicketStatusDto;
import com.example.SupportTicketTechPlatform.dto.StatusTypeDto;
import com.example.SupportTicketTechPlatform.dto.TicketDto;
import com.example.SupportTicketTechPlatform.dto.TicketStatusDto;
import com.example.SupportTicketTechPlatform.entity.Customer;
import com.example.SupportTicketTechPlatform.entity.StatusType;
import com.example.SupportTicketTechPlatform.entity.Ticket;
import com.example.SupportTicketTechPlatform.entity.TicketStatus;
import com.example.SupportTicketTechPlatform.entity.TicketStatusId;
import com.example.SupportTicketTechPlatform.mapper.StatusTypeMapper;
import com.example.SupportTicketTechPlatform.mapper.TicketMapper;
import com.example.SupportTicketTechPlatform.mapper.TicketResolutionMapper;
import com.example.SupportTicketTechPlatform.mapper.TicketStatusMapper;
import com.example.SupportTicketTechPlatform.repository.StatusTypeRepository;
import com.example.SupportTicketTechPlatform.repository.TicketRepository;
import com.example.SupportTicketTechPlatform.repository.TicketResolutionRepository;
import com.example.SupportTicketTechPlatform.repository.TicketStatusRepository;

@Service
public class TicketService {

    @Autowired
    TicketMapper ticketMapper;
    @Autowired 
    StatusTypeMapper statusTypeMapper;
    @Autowired
    TicketStatusMapper ticketStatusMapper;
    @Autowired
    TicketResolutionMapper resolutionMapper;


    @Autowired
    TicketRepository ticketRepository;
    @Autowired
    StatusTypeRepository statusTypeRepository;
    @Autowired
    TicketStatusRepository ticketStatusRepository;
    @Autowired
    TicketResolutionRepository ticketResolutionRepository;


    List<TicketDto> getTickets(){

        return ticketMapper.toDto(ticketRepository.findAll()); 
    
    }  
    

    List<TicketDto> getTicketsByCustomer(String vatCode){

        return ticketMapper.toDto(ticketRepository.findTicketByCustomerVatNumber(vatCode));    
    
    }
    

    TicketDto getTicketByCode(String ticketCode){

        return ticketMapper.toDto(ticketRepository.findTicketByTicketCode(ticketCode));

    }

    void addNewTicket(NewTicketDto newTicket, Customer customer){
        
        ticketRepository.save(ticketMapper.toEntity(newTicket, customer));
        
    }

    List<TicketStatusDto> getTicketStatusRecord(String ticketCode){

        return ticketStatusMapper.toDto(ticketStatusRepository.getTicketStatusByTicketCode(ticketCode));
    }

    boolean addTicketStatus(NewTicketStatusDto newTicketStatusDto){

        String ticketCode = newTicketStatusDto.getTicketCode();
        Ticket ticket = ticketRepository.findTicketByTicketCode(ticketCode);

        int statusTypeId = newTicketStatusDto.getStatusTypeId();
        StatusType statusType = statusTypeRepository.findById(statusTypeId).get();

        TicketStatusId ticketStatusId = new TicketStatusId();
        ticketStatusId.setTicketId(ticket);
        ticketStatusId.setTypeId(statusType);
        Optional<TicketStatus> ticketStatus = ticketStatusRepository.findById(ticketStatusId);

        if (ticketStatus.isEmpty()){
            return false;
        }

        ticketStatusRepository.save(ticketStatusMapper.toEntity(newTicketStatusDto, ticket, statusType));
        return true;
        
    }

}
