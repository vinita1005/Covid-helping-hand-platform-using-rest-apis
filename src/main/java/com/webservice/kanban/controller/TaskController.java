package com.webservice.kanban.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.webservice.kanban.repo.TaskDao;
import com.webservice.kanban.vo.Task;

@RestController
@RequestMapping("/kanban")
public class TaskController {

	@Autowired
	private TaskDao taskDao;
	
	@GetMapping("/greeting")
	public String greeting() {
		return "Hello World";
	}
	
	@GetMapping("/getAll")
	public @ResponseBody List<Task> listAllTasks(){
		return taskDao.findAll();
	}
	
	@PostMapping("/saveTask")
	public @ResponseBody Task saveTask(@RequestBody Task task) {
		return taskDao.save(task);
	}
	
	@PutMapping("/updateTask")
	public @ResponseBody Task updateTask(@RequestBody Task task) {
		Optional<Task> tempTask = taskDao.findById(task.getId());
		tempTask.get().setTaskName(task.getTaskName());
		tempTask.get().setStatus(task.getStatus());
		
		return taskDao.save(tempTask.get());
	}
	
	@DeleteMapping("/deleteTask")
	public @ResponseBody List<Task> deleteTask(@RequestParam Long id) {
		taskDao.deleteById(id);
		return taskDao.findAll();
	}
}
