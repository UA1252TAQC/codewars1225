package org.academy.codewars.repositories;

import org.academy.codewars.entities.Task;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class TaskRepository {
    private final List<Task> tasks = Arrays.asList(Task.values());

    public List<Task> findAll() {
        return tasks;
    }

    public Optional<Task> findById(int id) {
        return tasks.stream()
                .filter(task -> task.getId() == id)
                .findFirst();
    }
}
