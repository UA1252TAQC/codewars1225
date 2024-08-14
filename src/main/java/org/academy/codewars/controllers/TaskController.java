package org.academy.codewars.controllers;

import org.academy.codewars.entities.Task;
import org.academy.codewars.services.TaskService;

import java.util.List;

public class TaskController {
    private final TaskService taskService;

    public TaskController(TaskService service) {
        this.taskService = service;
    }

    public List<Task> getAll() {
        return taskService.getAll();
    }

    public Task getById(int id) {
        if (id < 0) throw new IllegalArgumentException("id can't be negative");
        return taskService.getById(id);
    }
}
