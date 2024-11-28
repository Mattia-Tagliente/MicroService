package com.example.SupportTicketTechPlatform.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.SupportTicketTechPlatform.dto.NewUserDto;
import com.example.SupportTicketTechPlatform.dto.UserDetailsDto;
import com.example.SupportTicketTechPlatform.dto.UserDto;
import com.example.SupportTicketTechPlatform.entity.Customer;
import com.example.SupportTicketTechPlatform.entity.User;
import com.example.SupportTicketTechPlatform.mapper.UserMapper;
import com.example.SupportTicketTechPlatform.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    UserMapper userMapper;

    public boolean userExists(String username, String email){
        Optional<User> userByEmail = userRepository.findUserByUsernameOrEmail(email);
        Optional<User> userByUsername = userRepository.findUserByUsernameOrEmail(username);
        if (userByEmail.isPresent() || userByUsername.isPresent()){
            return true;
        } else {
            return false;
        } 
    }

    public boolean addUser(NewUserDto newUserDto){

        String username =  newUserDto.getUsername();
        String email =  newUserDto.getUserEmail();

        if (userExists(username, email) == false){

            User newUserEntity = userMapper.toUser(newUserDto);
            userRepository.save(newUserEntity);
            return true;

        } else {
            return false;
        }
    }

    public boolean addUser(NewUserDto newUserDto, Customer customer){

        String username =  newUserDto.getUsername();
        String email =  newUserDto.getUserEmail();

        if (userExists(username, email) == false){

            User newUserEntity = userMapper.toUser(newUserDto, customer);
            userRepository.save(newUserEntity);
            return true;

        } else {
            return false;
        }
    }


    public List<UserDto> getAllUsers(){        
        return userMapper.toUserDto(userRepository.findAll());
    }

    public UserDetailsDto getUser(String usernameOrEmail, String password){

        Optional<User> userOptional = userRepository.findUserByNameAndPassword(usernameOrEmail, password);

        return userMapper.toUserDetailsDto(
            userOptional.get()
        );

    }

}