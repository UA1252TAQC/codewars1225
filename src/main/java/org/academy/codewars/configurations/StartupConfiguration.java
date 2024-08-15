package org.academy.codewars.configurations;

import org.academy.codewars.ConsoleScanner;
import org.academy.codewars.controllers.AuthorController;
import org.academy.codewars.controllers.TaskController;
import org.academy.codewars.controllers.UIController;
import org.academy.codewars.repositories.AuthorRepository;
import org.academy.codewars.repositories.TaskRepository;
import org.academy.codewars.services.AuthorService;
import org.academy.codewars.services.TaskService;
import org.academy.codewars.services.UIService;

import java.util.Scanner;

public class StartupConfiguration {

    public static UIController initUIController() {
        ConsoleScanner consoleScanner = new ConsoleScanner(new Scanner(System.in));
        AuthorRepository authorRepository = new AuthorRepository();

        AuthorService authorService = new AuthorService(authorRepository);
        TaskService taskService = new TaskService();
        UIService uiService = new UIService(authorService, taskService, consoleScanner);

        AuthorController authorController = new AuthorController(authorService);
        TaskController taskController = new TaskController(taskService);

        return new UIController(uiService);
    }
}
