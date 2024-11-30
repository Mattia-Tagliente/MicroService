package com.example.SupportTicketTechPlatform.mapper;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Component;

import com.example.SupportTicketTechPlatform.dto.NewResolutionDto;
import com.example.SupportTicketTechPlatform.dto.ResolutionDto;
import com.example.SupportTicketTechPlatform.dto.UserDto;
import com.example.SupportTicketTechPlatform.entity.Customer;
import com.example.SupportTicketTechPlatform.entity.Ticket;
import com.example.SupportTicketTechPlatform.entity.TicketResolution;
import com.example.SupportTicketTechPlatform.entity.User;

@Component
public class TicketResolutionMapper {

    public ResolutionDto toDto(TicketResolution resolutionEntity){

        ResolutionDto resolutionDto = new ResolutionDto();

        User admin = resolutionEntity.getAdmin();

        resolutionDto.setAdminEmail(admin.getUserEmail());
        resolutionDto.setAdminName(admin.getUserName());
        resolutionDto.setAdminSurname(admin.getUserSurname());
        resolutionDto.setNoteDate(resolutionEntity.getNoteDate());
        resolutionDto.setResolutionNote(resolutionEntity.getResolutionNote());

        return resolutionDto;

    }

    public List<ResolutionDto> toDto(Iterable<TicketResolution> resolutions){
        return StreamSupport.stream(resolutions.spliterator(), false)
                .map(resolution -> {

                    ResolutionDto resolutionDto = toDto(resolution);
                    return resolutionDto;

                })
                .collect(Collectors.toList());        
    }

    public TicketResolution toEntity(NewResolutionDto newTicket, Ticket ticket, User admin){

        TicketResolution newResolutionEntity = new TicketResolution();

        newResolutionEntity.setAdmin(admin);
        newResolutionEntity.setTicket(ticket);
        newResolutionEntity.setNoteDate(newTicket.getNoteDate());
        newResolutionEntity.setResolutionNote(newTicket.getResolutionNote());

        return newResolutionEntity;
        
    }
}
