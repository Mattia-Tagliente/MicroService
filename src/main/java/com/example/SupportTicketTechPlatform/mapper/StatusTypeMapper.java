package com.example.SupportTicketTechPlatform.mapper;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import com.example.SupportTicketTechPlatform.dto.StatusTypeDto;
import com.example.SupportTicketTechPlatform.dto.TicketDto;
import com.example.SupportTicketTechPlatform.entity.StatusType;

public class StatusTypeMapper {

    StatusTypeDto toDto(StatusType statusTypeEntity){

        StatusTypeDto statusTypeDto = new StatusTypeDto();

        statusTypeDto.setStatusId(statusTypeEntity.getTypeId());
        statusTypeDto.setStatusName(statusTypeEntity.getStatusName());

        return statusTypeDto;
    }

    List<StatusTypeDto> toDto(Iterable<StatusType> statusTypes){

        return StreamSupport.stream(statusTypes.spliterator(), false)
                .map(statusType -> {

                    StatusTypeDto statusTypeDto = toDto(statusType);
                    return statusTypeDto;

                })
                .collect(Collectors.toList());  

    }

}
