package com.example.SupportTicketTechPlatform.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.SupportTicketTechPlatform.entity.User;

public interface UserRepository extends JpaRepository<User, Integer>{

    @Query("SELECT u FROM User u WHERE u.username = ?1 OR u.userEmail = ?1")
    Optional<User> findUserByUsernameOrEmail(String usernameOrEmail);

    @Query("SELECT u FROM User u WHERE (u.username = ?1 OR u.userEmail = ?1) AND u.userPassword = ?2")
    Optional<User> findUserByNameAndPassword(String usernameOrEmail, String password);

}
