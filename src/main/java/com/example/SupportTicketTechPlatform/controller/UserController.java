package com.example.SupportTicketTechPlatform.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.SupportTicketTechPlatform.dto.NewUserDto;
import com.example.SupportTicketTechPlatform.dto.UserDetailsDto;
import com.example.SupportTicketTechPlatform.dto.UserDto;
import com.example.SupportTicketTechPlatform.dto.UserLoginDto;
import com.example.SupportTicketTechPlatform.mapper.UserMapper;
import com.example.SupportTicketTechPlatform.service.UserService;

@Controller
@RequestMapping("api/v1/app/user")
public class UserController {

    @Autowired
    UserService userService;

    @GetMapping
    public ResponseEntity<List<UserDto>> getUsers(){

        List<UserDto> result = userService.getAllUsers();

        return new ResponseEntity<>(result, HttpStatus.OK);

    }

    @PostMapping("/login")
    public ResponseEntity<UserDetailsDto> validateUser(@RequestBody UserLoginDto loginCredential){
        
        Optional<UserDetailsDto> result = userService.getUser(
            loginCredential.getUsernameOrEmail(), 
            loginCredential.getPassword())
        ;

        if (result.isEmpty()){
            return new ResponseEntity<>(HttpStatus.UNAUTHORIZED);
        }
        
        return new ResponseEntity<>(result.get(), HttpStatus.OK);

    }


    @PostMapping("/register")
    public ResponseEntity<Boolean> addUser(@RequestBody NewUserDto newUser){

        boolean result = userService.addUser(newUser);

        if(result == false){
            return new ResponseEntity<>(HttpStatus.I_AM_A_TEAPOT);
        }
        return new ResponseEntity<>(result, HttpStatus.OK);

    }
}

