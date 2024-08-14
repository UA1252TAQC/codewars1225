package org.academy.codewars.controllers;

import org.academy.codewars.entities.Task;
import org.academy.codewars.services.TaskService;

import java.util.List;

public class TaskController {
    private TaskService taskService;
    public TaskController(TaskService service){
        taskService = service;
    }
    public List<Task> getAll() {
        return taskService.getAll();
    }
    public Task getById(int id){
        return taskService.getById(id);
    }
}
