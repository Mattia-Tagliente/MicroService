package com.example.SupportTicketTechPlatform.mapper;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.example.SupportTicketTechPlatform.dto.NewResolutionDto;
import com.example.SupportTicketTechPlatform.dto.ResolutionDto;
import com.example.SupportTicketTechPlatform.dto.UserDto;
import com.example.SupportTicketTechPlatform.entity.Customer;
import com.example.SupportTicketTechPlatform.entity.Ticket;
import com.example.SupportTicketTechPlatform.entity.TicketResolution;
import com.example.SupportTicketTechPlatform.entity.User;

public class TicketResolutionMapper {

    ResolutionDto toDto(TicketResolution resolutionEntity){

        ResolutionDto resolutionDto = new ResolutionDto();

        User admin = resolutionEntity.getAdmin();

        resolutionDto.setAdminEmail(admin.getUserEmail());
        resolutionDto.setAdminName(admin.getUserName());
        resolutionDto.setAdminSurname(admin.getUserSurname());
        resolutionDto.setPostDate(resolutionEntity.getPostDate());
        resolutionDto.setResolutionPost(resolutionEntity.getResolutionPost());

        return resolutionDto;

    }

    List<ResolutionDto> toDto(Iterable<TicketResolution> resolutions){
        return StreamSupport.stream(resolutions.spliterator(), false)
                .map(resolution -> {

                    ResolutionDto resolutionDto = toDto(resolution);
                    return resolutionDto;

                })
                .collect(Collectors.toList());        
    }

    TicketResolution toEntity(NewResolutionDto newTicket, Ticket ticket, User admin){

        TicketResolution newResolutionEntity = new TicketResolution();

        newResolutionEntity.setAdmin(admin);
        newResolutionEntity.setTicket(ticket);
        newResolutionEntity.setPostDate(newTicket.getPostDate());
        newResolutionEntity.setResolutionPost(newTicket.getResolutionPost());

        return newResolutionEntity;
        
    }
}
