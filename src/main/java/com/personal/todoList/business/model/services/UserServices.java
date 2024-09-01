package com.personal.todoList.business.model.services;

import java.util.List;
import java.util.Optional;

import com.personal.todoList.business.model.User;
import com.personal.todoList.business.model.dtos.UserDTO;

public interface UserServices {
	
	Long createUser(User user);
	
	Optional<User> read(Long id);
	
	void update(User user);
	
	void delete(Long id);
	
	List<User> getAll();
	
	List<UserDTO> getAllDTO();

}
