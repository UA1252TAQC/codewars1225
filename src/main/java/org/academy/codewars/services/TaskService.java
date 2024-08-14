package org.academy.codewars.services;

import org.academy.codewars.entities.Author;
import org.academy.codewars.entities.Task;

import java.util.ArrayList;
import java.util.List;

public class TaskService {

    public List<Task> getAll(int authorId) {
        Author author = Author.values()[authorId];
        List<Task> authorTasks = new ArrayList<>();

        authorTasks.add(Task.TASK1);
        authorTasks.add(Task.TASK2);
        authorTasks.add(Task.TASK3);

        return authorTasks;
    }

    public Task getById(int authorId, String taskName) {
        Author author = Author.values()[authorId];

        for (Task task : getAll(authorId)) {
            if (task.name().equals(taskName)) {
                return task;
            }
        }

        throw new IllegalArgumentException("Task " + taskName + " is not associated with author " + author.getName());
    }
}
