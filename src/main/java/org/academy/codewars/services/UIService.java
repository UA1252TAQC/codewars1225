package org.academy.codewars.services;

import org.academy.codewars.ConsoleScanner;
import org.academy.codewars.entities.Author;
import org.academy.codewars.entities.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.NoSuchElementException;
import java.util.function.Function;

public class UIService {
    private final AuthorService authorService;
    private final TaskService taskService;
    private final ConsoleScanner consoleScanner;

    public UIService(AuthorService authorService, TaskService taskService, ConsoleScanner consoleScanner) {
        this.authorService = authorService;
        this.taskService = taskService;
        this.consoleScanner = consoleScanner;
    }

    public void start() {
        while (true) {
            System.out.println("Main menu:");
            System.out.println("\t1) Show all authors");
            System.out.println("\t2) Show all tasks");
            System.out.println("\t3) Run author's method");
            System.out.println("\tq) Quit");
            final String userInput = consoleScanner.readString("value");
            switch (userInput) {
                case "1" -> getAllAuthors();
                case "2" -> getAllTasks();
                case "3" -> executeTask();
                case "0" -> {
                    return;
                }
                default -> actionNotFound();
            }
        }
    }


    private void getAllAuthors() {
        System.out.println("All authors:");
        for (Author author : authorService.getAll()) {
            System.out.printf("\t%d) %s%n", author.getId(), author.getName());
        }
        for (Author author : Author.values()) {
            System.out.printf("\t%d) %s%n", author.getId(), author.getName());
        }
    }

    private void getAllTasks() {
        System.out.println("All tasks:");
        for (Task task : taskService.getAll()) {
            System.out.printf("\t%d) %s%n", task.getId(), task.getTitle());
        }
    }

    private void executeTask() {
        try {
            final Author author = requestAuthor();
            final Task task = requestTask();
            System.out.println("Author: " + author.getName());
            System.out.println("Task description: " + task.getDescription());
            final List<Object> params = requestParams(task);
            try {
                final String result = task.getSupplier().applyString(author, params);
                System.out.println("Result: " + result);
            } catch (Exception e) {
                System.out.println("Result: Thrown exception: " + e.getClass() + ", with message: " + e.getMessage());
            }
        } catch (NoSuchElementException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }

    private List<Object> requestParams(Task task) {
        final List<Object> params = new ArrayList<>();
        for (Function<ConsoleScanner, ?> param : task.getRequiredParams()) {
            params.add(param.apply(consoleScanner));
        }
        return params;
    }

    private Task requestTask() {
        System.out.println("Choose the task:");
        for (Task task : taskService.getAll()) {
            System.out.printf("\t%d) %s%n", task.getId(), task.getTitle());
        }
        return taskService.getById(consoleScanner.readInt("task id"));
    }

    private Author requestAuthor() {
        System.out.println("Choose the author:");
        for (Author author : authorService.getAll()) {
            System.out.printf("\t%d) %s%n", author.getId(), author.getName());
        }
        return authorService.getById(consoleScanner.readInt("author id"));
    }

    private void actionNotFound() {
        System.out.println("Action not found. Please choose a valid option.");
    }
}
