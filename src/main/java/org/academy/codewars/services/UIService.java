package org.academy.codewars.services;

import org.academy.codewars.ConsoleScanner;
import org.academy.codewars.entities.Author;
import org.academy.codewars.entities.Task;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
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
        Scanner scanner = new Scanner(System.in);
        String userInput;
        while (true) {
            System.out.println("Main menu:");
            System.out.println("\t1) Show all authors");
            System.out.println("\t2) Show all tasks");
            System.out.println("\t3) Run author's method");
            System.out.println("\tq) Quit");
            userInput = scanner.next();
            switch (userInput.trim()) {
                case "1":
                    getAllAuthors();
                    break;
                case "2":
                    getAllTasks();
                    break;
                case "3":
                    executeTask();
                    break;
                case "q":
                    return;
                default:
                    actionNotFound();
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
        Author author = requestAuthor();
        Task task = requestTask();
        System.out.println("Author: " + author.getName());
        System.out.println("Task description: " + task.getDescription());
        List<Object> params = requestParams(task);

         //TODO exception handler
        String result = task.getSupplier().applyString(author, params);

        System.out.println("Result: " + result);
    }

    private List<Object> requestParams(Task task) {
        List<Object> params =  new ArrayList<>();
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
