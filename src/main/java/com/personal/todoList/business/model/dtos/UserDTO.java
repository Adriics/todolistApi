package com.personal.todoList.business.model.dtos;

import java.util.Date;
import java.util.List;

public class UserDTO {

	private Long id;
	private String username;
	private String email;
	private Date createdAt;
	private Date updatedDate;
	
	private List<TaskDTO> taskPL;

	public UserDTO() {
	}

	public UserDTO(Long id, String username, String email, Date createdAt) {
		this.id = id;
		this.username = username;
		this.email = email;
		this.createdAt = createdAt;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Date getCreatedAt() {
		return createdAt;
	}

	public void setCreatedAt(Date createdAt) {
		this.createdAt = createdAt;
	}
	
	public Date getUpdatedDate() {
		return updatedDate;
	}

	public void setUpdatedDate(Date updatedDate) {
		this.updatedDate = updatedDate;
	}

}
