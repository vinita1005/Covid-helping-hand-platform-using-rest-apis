package com.webservice.kanban.vo;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import com.sun.istack.NotNull;

@Entity
@Table // (uniqueConstraints = @UniqueConstraint(columnNames = "id"))
public class Task implements Serializable {

	private static final long serialVersionUID = 1L;

	public Task() {
		super();
	}

	public Task(Long id, String taskName, int status) {
		super();
		this.id = id;
		this.taskName = taskName;
		Status = status;
	}

	@Id
	@GeneratedValue
	private Long id;

	@NotNull
	private String taskName;

	@NotNull
	private int Status;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTaskName() {
		return taskName;
	}

	public void setTaskName(String taskName) {
		this.taskName = taskName;
	}

	public int getStatus() {
		return Status;
	}

	public void setStatus(int status) {
		Status = status;
	}

	@Override
	public String toString() {
		return "Task [id=" + id + ", taskName=" + taskName + ", Status=" + Status + "]";
	}

}
