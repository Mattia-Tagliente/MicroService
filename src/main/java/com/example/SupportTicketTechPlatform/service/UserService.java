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
import com.example.SupportTicketTechPlatform.repository.CustomerRepository;
import com.example.SupportTicketTechPlatform.repository.UserRepository;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;
    @Autowired
    CustomerRepository customerRepository;
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

        String customerVat =  newUserDto.getCustomerVat();
        String username =  newUserDto.getUsername();
        String email =  newUserDto.getUserEmail();

        if (userExists(username, email)){
            return false;
        }

        if (customerVat != null){            

            Customer customer = customerRepository.findCustomerByVatNumber(customerVat).get();
            User newUserEntity = userMapper.toUser(newUserDto, customer);
            userRepository.save(newUserEntity);
            return true;
        }     

        User newUserEntity = userMapper.toUser(newUserDto);
        userRepository.save(newUserEntity);
        return true;
        
    }


    public List<UserDto> getAllUsers(){        
        return userMapper.toUserDto(userRepository.findAll());
    }

    public Optional<UserDetailsDto> getUser(String usernameOrEmail, String password){

        Optional<User> entity = userRepository.findUserByNameAndPassword(usernameOrEmail, password);

        if (entity.isPresent()){
            UserDetailsDto user = userMapper.toUserDetailsDto(entity.get());
            return Optional.of(user);
        }else {
            return Optional.empty();
        }

    }

}
