package com.example.SupportTicketTechPlatform.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.SupportTicketTechPlatform.entity.TaskType;

public interface TaskTypeRepository extends JpaRepository<TaskType, Integer> {

}
