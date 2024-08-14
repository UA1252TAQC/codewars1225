package org.academy.codewars.controllers;

import java.util.Scanner;

import org.academy.codewars.entities.Author;
import org.academy.codewars.entities.Task;

public class UIController {
    private enum MenuActions {AUTHORS, TASKS, RUN, NOT_FOUND}

    private final AuthorController authorController;
    private final TaskController taskController;

    public UIController(AuthorController authorController, TaskController taskController) {
        this.authorController = authorController;
        this.taskController = taskController;
    }

    public void start() {
        Scanner scanner = new Scanner(System.in);
        String userInput;
        while (true) {
            System.out.println("Main menu:");
            System.out.println("\t1) Show all authors");
            System.out.println("\t2) Show all tasks");
            System.out.println("\t3) Run author's method");
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
        int i = 1;
        for (Author author : authorController.getAll()) {
            System.out.printf("\t%d) %s%n", i, author.getName());
        }
    }

    private void getAllTasks() {
        System.out.println("All tasks:");
        int i = 1;
        for (Task task : taskController.getAll()) {
            System.out.printf("\t%d) %s%n", i, task.getTitle());
        }
    }

    private void executeTask() {
        //TODO
    }

    private void actionNotFound() {
        System.out.println("Action not found. Please choose a valid option.");
    }
}
