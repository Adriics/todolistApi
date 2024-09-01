package com.personal.todoList.business.model.services.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import org.dozer.DozerBeanMapper;
import org.springframework.stereotype.Service;

import com.personal.todoList.business.model.Task;
import com.personal.todoList.business.model.dtos.TaskDTO;
import com.personal.todoList.business.model.services.TaskServices;
import com.personal.todoList.integration.model.TaskPL;
import com.personal.todoList.integration.model.UserPL;
import com.personal.todoList.integration.repositories.TaskPLRepository;

@Service
public class TaskServicesImpl implements TaskServices {

	private TaskPLRepository taskPLRepository;
	private DozerBeanMapper mapper;

	public TaskServicesImpl(TaskPLRepository taskPLRepository, DozerBeanMapper mapper) {
		this.mapper = mapper;
		this.taskPLRepository = taskPLRepository;
	}

	@Override
	public Long createTask(Task task) {

		if(task.getId() != null) {
			throw new IllegalStateException("Para crear una tarea, el id tiene que ser null");
		}
		
		return taskPLRepository.save(mapper.map(task, TaskPL.class)).getId();

	}

	@Override
	public Optional<Task> read(Long id) {

		Optional<TaskPL> optionalPL = taskPLRepository.findById(id);
		
		Task task = null;
		
		if(optionalPL.isEmpty()) {
			throw new IllegalStateException("Tarea no existente");
		}
		
		task = mapper.map(optionalPL.get(), Task.class);
		
		return Optional.ofNullable(task);
		
	}

	@Override
	public void update(Task task) {

		boolean exists = taskPLRepository.existsById(task.getId());
		
		if(!exists) {
			throw new IllegalStateException("Tarea no existente");
		}
		
		taskPLRepository.save(mapper.map(task, TaskPL.class));
		
	}

	@Override
	public void delete(Long id) {

		boolean exists = taskPLRepository.existsById(id);
		
		if(!exists) {
			throw new IllegalStateException("Tarea no existente");
		}
		
		taskPLRepository.deleteById(id);
		
	}

	@Override
	public List<Task> getAll() {
		List<TaskPL> tasksPL = taskPLRepository.findAll();
		
		List<Task> tasks = new ArrayList<Task>();
		
		for(TaskPL taskPL: tasksPL) {
			tasks.add(mapper.map(taskPL, Task.class));
		}
		
		return tasks;
	}

	@Override
	public List<TaskDTO> getAllDTO() {
		List<TaskPL> tasksPL = taskPLRepository.findAll();
		
		return tasksPL.stream()
				.map(taskPL -> mapper.map(taskPL, TaskDTO.class))
				.collect(Collectors.toList());
	}

}
