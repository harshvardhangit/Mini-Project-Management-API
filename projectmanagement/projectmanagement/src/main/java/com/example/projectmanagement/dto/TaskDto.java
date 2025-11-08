package com.example.projectmanagement.dto;

import java.time.LocalDate;

import com.example.projectmanagement.model.Task;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public class TaskDto {

	@NotBlank(message = "Title cannot be blank")
	@NotNull(message = "Title cannot be null")
	private String title;
	private String description;
	private Task.Status status;
	private Task.Priority priority;
	private LocalDate dueDate;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Task.Status getStatus() {
		return status;
	}

	public void setStatus(Task.Status status) {
		this.status = status;
	}

	public Task.Priority getPriority() {
		return priority;
	}

	public void setPriority(Task.Priority priority) {
		this.priority = priority;
	}

	public LocalDate getDueDate() {
		return dueDate;
	}

	public void setDueDate(LocalDate dueDate) {
		this.dueDate = dueDate;
	}

}
