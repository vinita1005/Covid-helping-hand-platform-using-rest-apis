package com.webservice.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.webservice.vo.Task;

public interface TaskDao extends JpaRepository<Task, Long>{

//	public Task findById(Long id);
	public Task findByTaskName(String taskName);
	
}
