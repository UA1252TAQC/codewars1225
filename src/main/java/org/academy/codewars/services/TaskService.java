package org.academy.codewars.services;

import org.academy.codewars.entities.Task;

import java.util.List;
import java.util.NoSuchElementException;


public class TaskService {

    public List<Task> getAll() {
        return Task.findAll();
    }

    public Task getById(int id) {
        final Task task = Task.findById(id);
        if (task == null) {
            throw new NoSuchElementException("Task not found with id: " + id);
        }
        return task;
    }
}
