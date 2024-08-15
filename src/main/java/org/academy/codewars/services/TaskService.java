package org.academy.codewars.services;

import org.academy.codewars.entities.Task;
import java.util.List;


public class TaskService {
    public List<Task> getAll() {
        return Task.findAll();
    }

    public Task getById(int id) {
        Task task = Task.findById(id);
        if (task == null) {
            throw new RuntimeException("Task with ID " + id + " not found");
        }
        return task;
    }
}
