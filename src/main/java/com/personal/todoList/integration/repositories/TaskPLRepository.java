package com.personal.todoList.integration.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personal.todoList.integration.model.TaskPL;

public interface TaskPLRepository extends JpaRepository<TaskPL, Long>{

}
