package com.example.SupportTicketTechPlatform.mapper;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.stereotype.Component;

import com.example.SupportTicketTechPlatform.dto.NewUserDto;
import com.example.SupportTicketTechPlatform.dto.UserDetailsDto;
import com.example.SupportTicketTechPlatform.dto.UserDto;
import com.example.SupportTicketTechPlatform.entity.Customer;
import com.example.SupportTicketTechPlatform.entity.User;

@Component
public class UserMapper {

    public User toUser(NewUserDto newUserDto, Customer customer){
        
        User newUserEntity = new User();

        newUserEntity.setUsername(newUserDto.getUsername());
        newUserEntity.setUserName(newUserDto.getUserName());
        newUserEntity.setUserSurname(newUserDto.getUserSurname());
        newUserEntity.setUserEmail(newUserDto.getUserEmail());
        newUserEntity.setCodiceFiscale(newUserDto.getCodiceFiscale());
        newUserEntity.setUserPassword(newUserDto.getUserPassword());
        newUserEntity.setPhoneNumber(newUserDto.getPhoneNumber());
        newUserEntity.setRegistrationDate(newUserDto.getRegistrationDate());
        newUserEntity.setLastLogin(newUserDto.getRegistrationDate());
        newUserEntity.setCustomer(customer);
        newUserEntity.setAdminRole(newUserDto.getAdminRole());

        return newUserEntity;

    }

    public User toUser(NewUserDto newUserDto){
        
        User newUserEntity = new User();

        newUserEntity.setUsername(newUserDto.getUsername());
        newUserEntity.setUserName(newUserDto.getUserName());
        newUserEntity.setUserSurname(newUserDto.getUserSurname());
        newUserEntity.setUserEmail(newUserDto.getUserEmail());
        newUserEntity.setCodiceFiscale(newUserDto.getCodiceFiscale());
        newUserEntity.setUserPassword(newUserDto.getUserPassword());
        newUserEntity.setPhoneNumber(newUserDto.getPhoneNumber());
        newUserEntity.setRegistrationDate(newUserDto.getRegistrationDate());
        newUserEntity.setLastLogin(newUserDto.getRegistrationDate());
        newUserEntity.setAdminRole(newUserDto.getAdminRole());

        return newUserEntity;

    }

    public UserDto toUserDto(User user){

        UserDto userDto = new UserDto();

        Customer userCustomer = user.getCustomer();

        userDto.setCodiceFiscale(user.getCodiceFiscale());
        userDto.setCompanyName(userCustomer.getDenominazioneSociale());
        userDto.setPhoneNumber(user.getPhoneNumber());
        userDto.setUserEmail(user.getPhoneNumber());
        userDto.setUserName(user.getUserName());
        userDto.setUserSurname(user.getUserSurname());

        return userDto;

    }

    public UserDetailsDto toUserDetailsDto(User user){

        UserDetailsDto userDetailsDto = new UserDetailsDto();

        userDetailsDto.setUsername(user.getUsername());
        userDetailsDto.setUserName(user.getUserName());
        userDetailsDto.setUserSurname(user.getUserSurname());
        userDetailsDto.setUserEmail(user.getUserEmail());
        userDetailsDto.setCodiceFiscale(user.getCodiceFiscale());
        userDetailsDto.setPhoneNumber(user.getPhoneNumber());
        userDetailsDto.setRegistrationDate(user.getRegistrationDate());
        userDetailsDto.setLastLogin(user.getLastLogin());

        return userDetailsDto;

    }

    public List<UserDto> toUserDto(Iterable<User> users){

        return StreamSupport.stream(users.spliterator(), false)
                .map(user -> {

                    Customer userCustomer = user.getCustomer();

                    UserDto userDto = new UserDto();
                    userDto.setCodiceFiscale(user.getCodiceFiscale());
                    userDto.setCompanyName(userCustomer.getDenominazioneSociale());
                    userDto.setPhoneNumber(user.getPhoneNumber());
                    userDto.setUserEmail(user.getPhoneNumber());
                    userDto.setUserName(user.getUserName());
                    userDto.setUserSurname(user.getUserSurname());
                    return userDto;

                })
                .collect(Collectors.toList());        
    }

}
