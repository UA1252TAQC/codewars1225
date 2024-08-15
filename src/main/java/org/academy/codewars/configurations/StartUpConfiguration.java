package org.academy.codewars.configurations;

import org.academy.codewars.ConsoleScanner;
import org.academy.codewars.controllers.UIController;
import org.academy.codewars.services.AuthorService;
import org.academy.codewars.services.TaskService;
import org.academy.codewars.services.UIService;

import java.util.Scanner;

public class StartUpConfiguration {

    public static UIController initUIController() {
        ConsoleScanner consoleScanner = new ConsoleScanner(new Scanner(System.in));

        AuthorService authorService = new AuthorService();
        TaskService taskService = new TaskService();
        UIService uiService = new UIService(authorService, taskService, consoleScanner);

        return new UIController(uiService);
    }
}
