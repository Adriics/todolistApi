package com.personal.todoList.integration.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.personal.todoList.integration.model.UserPL;

public interface UserPLRepository extends JpaRepository<UserPL, Long>{

}
