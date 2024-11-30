package com.example.SupportTicketTechPlatform.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SupportTicketTechPlatform.dto.NewResolutionDto;
import com.example.SupportTicketTechPlatform.dto.NewTicketDto;
import com.example.SupportTicketTechPlatform.dto.NewTicketStatusDto;
import com.example.SupportTicketTechPlatform.dto.ResolutionDto;
import com.example.SupportTicketTechPlatform.dto.StatusTypeDto;
import com.example.SupportTicketTechPlatform.dto.TicketDto;
import com.example.SupportTicketTechPlatform.dto.TicketStatusDto;
import com.example.SupportTicketTechPlatform.entity.Customer;
import com.example.SupportTicketTechPlatform.entity.StatusType;
import com.example.SupportTicketTechPlatform.entity.Ticket;
import com.example.SupportTicketTechPlatform.entity.TicketStatus;
import com.example.SupportTicketTechPlatform.entity.TicketStatusId;
import com.example.SupportTicketTechPlatform.entity.User;
import com.example.SupportTicketTechPlatform.mapper.StatusTypeMapper;
import com.example.SupportTicketTechPlatform.mapper.TicketMapper;
import com.example.SupportTicketTechPlatform.mapper.TicketResolutionMapper;
import com.example.SupportTicketTechPlatform.mapper.TicketStatusMapper;
import com.example.SupportTicketTechPlatform.repository.CustomerRepository;
import com.example.SupportTicketTechPlatform.repository.StatusTypeRepository;
import com.example.SupportTicketTechPlatform.repository.TicketRepository;
import com.example.SupportTicketTechPlatform.repository.TicketResolutionRepository;
import com.example.SupportTicketTechPlatform.repository.TicketStatusRepository;
import com.example.SupportTicketTechPlatform.repository.UserRepository;

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
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    UserRepository userRepository;

    public List<TicketDto> getTickets(){

        return ticketMapper.toDto(ticketRepository.findAll()); 
    
    }  
    

    public List<TicketDto> getTicketsByCustomer(String vatCode){

        return ticketMapper.toDto(ticketRepository.findTicketByCustomerVatNumber(vatCode));    
    
    }
    

    public Optional<TicketDto> getTicketByCode(String ticketCode){

        Optional<Ticket> ticketEntity = ticketRepository.findTicketByTicketCode(ticketCode);
        if (ticketEntity.isEmpty()){
            return Optional.empty();
        }

        return Optional.of(ticketMapper.toDto(ticketEntity.get()));

    }

    public boolean addNewTicket(NewTicketDto newTicket){

        String ticketCode = newTicket.getTicketCode();
        String vatNumber = newTicket.getCustomerVatNumber();
        Optional<Customer> customer = customerRepository.findCustomerByVatNumber(vatNumber);
        
        if (customer.isEmpty()){
            return false;
        }

        Optional<Ticket> ticketEntity = ticketRepository.findTicketByTicketCode(ticketCode);
        if (ticketEntity.isEmpty()){

            ticketRepository.save(ticketMapper.toEntity(newTicket, customer.get()));
            return true;

        }
        
        return false;
        
    }

    public List<TicketStatusDto> getTicketStatusRecord(String ticketCode){

        return ticketStatusMapper.toDto(ticketStatusRepository.getTicketStatusByTicketCode(ticketCode));
    }

    public boolean addTicketStatus(NewTicketStatusDto newTicketStatusDto){

        String ticketCode = newTicketStatusDto.getTicketCode();
        Optional<Ticket> ticket = ticketRepository.findTicketByTicketCode(ticketCode);

        if (ticket.isEmpty()){
            return false;
        }

        int statusTypeId = newTicketStatusDto.getStatusTypeId();
        Optional<StatusType> statusType = statusTypeRepository.findById(statusTypeId);
        
        if (statusType.isEmpty()){
            return false;
        }

        TicketStatusId ticketStatusId = new TicketStatusId();
        ticketStatusId.setTicketId(ticket.get());
        ticketStatusId.setTypeId(statusType.get());
        Optional<TicketStatus> ticketStatus = ticketStatusRepository.findById(ticketStatusId);

        if (ticketStatus.isEmpty()){
            ticketStatusRepository.save(ticketStatusMapper.toEntity(newTicketStatusDto, ticket.get(), statusType.get()));
            return true;
        }

        
        return false;
        
    }


    public List<ResolutionDto> getResolutionNotes(String ticketCode){

        return resolutionMapper.toDto(ticketResolutionRepository.findResolutionbyTicketCode(ticketCode));

    }

    public boolean addResolution(NewResolutionDto newRes){

        String ticketCode = newRes.getTicketCode();
        String adminUsername = newRes.getAdminUsername();

        Optional<Ticket> ticket = ticketRepository.findTicketByTicketCode(ticketCode);
        Optional<User> admin = userRepository.findUserByUsernameOrEmail(adminUsername);
        
        if (ticket.isEmpty() || admin.isEmpty()){
            return false;
        }

        ticketResolutionRepository.save(resolutionMapper.toEntity(newRes, ticket.get(), admin.get()));
        return true;

    }

    public boolean removeTicket(String ticketCode){

        Optional<Ticket> ticket = ticketRepository.findTicketByTicketCode(ticketCode);
        
        if (ticket.isEmpty()){
            return false;
        }

        ticketRepository.removeTicket(ticketCode);
        return true;
    }




}
