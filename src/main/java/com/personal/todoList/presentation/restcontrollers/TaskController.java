package com.personal.todoList.presentation.restcontrollers;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.personal.todoList.business.model.dtos.TaskDTO;
import com.personal.todoList.business.model.services.TaskServices;

@RestController
@RequestMapping("api/todolist/tasks")
public class TaskController {

	private TaskServices taskServices;
	
	public TaskController(TaskServices taskServices) {
		this.taskServices = taskServices;
	}
	
	@GetMapping
	public List<TaskDTO> getAll() {
		return taskServices.getAllDTO();
	}
	
	
}
