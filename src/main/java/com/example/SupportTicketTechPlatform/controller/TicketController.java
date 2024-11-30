package com.example.SupportTicketTechPlatform.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.Mapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.SupportTicketTechPlatform.dto.NewResolutionDto;
import com.example.SupportTicketTechPlatform.dto.NewTicketDto;
import com.example.SupportTicketTechPlatform.dto.NewTicketStatusDto;
import com.example.SupportTicketTechPlatform.dto.ResolutionDto;
import com.example.SupportTicketTechPlatform.dto.TicketDto;
import com.example.SupportTicketTechPlatform.dto.TicketStatusDto;
import com.example.SupportTicketTechPlatform.service.TicketService;

import org.springframework.web.bind.annotation.RequestBody;



@Controller
@RequestMapping("api/v1/app/ticket")
public class TicketController {

    @Autowired
    TicketService ticketService;
    @Autowired

    @GetMapping()
    public ResponseEntity<List<TicketDto>> getAllTickets() {
        List<TicketDto> result = ticketService.getTickets();

        if (result.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("/customer/{vatNumber}")
    public ResponseEntity<List<TicketDto>> getTicketByCustomer(@PathVariable String vatNumber) {
        
        List<TicketDto> result = ticketService.getTicketsByCustomer(vatNumber);
        
        if (result.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        
        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("resolution/{ticketCode}")
    public ResponseEntity<List<ResolutionDto>> getResolutionRecordByTicket(@PathVariable String ticketCode) {
        
        List<ResolutionDto> result = ticketService.getResolutionNotes(ticketCode);

        if (result.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);
    }

    @GetMapping("status/{ticketCode}")
    public  ResponseEntity<List<TicketStatusDto>>  getStatusRecordByTicket(@PathVariable String ticketCode){
        
        List<TicketStatusDto> result = ticketService.getTicketStatusRecord(ticketCode);
        
        if (result.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }

        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @GetMapping("remove/{ticketCode}")
    public ResponseEntity<Void> removeTicket(@PathVariable String ticketCode){

        boolean result = ticketService.removeTicket(ticketCode);

        if (result == false){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/new")
    public ResponseEntity<Void> addTicket(@RequestBody NewTicketDto newTicketDto) {
        
        boolean result = ticketService.addNewTicket(newTicketDto);

        if (result == false){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(HttpStatus.OK);

    }    

    @PostMapping("resolution/new")
    public ResponseEntity<Void> addResolution(@RequestBody NewResolutionDto newResolutionDto) {

        boolean result = ticketService.addResolution(newResolutionDto);

        if (result == false){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("status/new")
    public ResponseEntity<Void> addStatus(@RequestBody NewTicketStatusDto newStatusDto){

        boolean result = ticketService.addTicketStatus(newStatusDto);

        if (result == false){
            return new ResponseEntity<>(HttpStatus.CONFLICT);
        }

        return new ResponseEntity<>(HttpStatus.OK);
    }

}

    
    
    
    
    


