package org.academy.codewars.services;

import org.academy.codewars.entities.Task;
import org.academy.codewars.repositories.TaskRepository;


import java.util.List;
import java.util.Optional;



public class TaskService {
    private TaskRepository taskRepository;
    private AuthorService authorService;

    public TaskService(TaskRepository taskRepository, AuthorService authorService) {
        this.taskRepository = taskRepository;
        this.authorService = authorService;
    }

    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    public Task getById(int id) {
        return taskRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Task with ID " + id + " not found"));
    }
}
