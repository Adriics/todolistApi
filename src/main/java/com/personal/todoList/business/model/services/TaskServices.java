package com.personal.todoList.business.model.services;

import java.util.List;
import java.util.Optional;

import com.personal.todoList.business.model.Task;
import com.personal.todoList.business.model.dtos.TaskDTO;

public interface TaskServices {
	
	Long createTask(Task task);
	
	Optional<Task> read(Long id);
	
	void update(Task task);
	
	void delete(Long id);
	
	List<Task> getAll();
	
	List<TaskDTO> getAllDTO();

}
