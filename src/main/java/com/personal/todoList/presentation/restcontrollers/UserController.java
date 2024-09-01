package com.personal.todoList.presentation.restcontrollers;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.personal.todoList.business.model.User;
import com.personal.todoList.business.model.dtos.UserDTO;
import com.personal.todoList.business.model.services.UserServices;

@RestController
@RequestMapping("/api/todolist/users")
public class UserController {
	
	private UserServices userServices;
	
	public UserController(UserServices userServices) {
		this.userServices = userServices;
	}
	
	@PostMapping
	public ResponseEntity<User> create(@RequestBody User user, UriComponentsBuilder ucb) {
		Long id = userServices.createUser(user);
		return ResponseEntity.created(ucb.path("/users/{id}").build(id)).build();
	}
	
    @GetMapping
    public List<UserDTO> getAllUsers() {
        return userServices.getAllDTO();
    }

}
