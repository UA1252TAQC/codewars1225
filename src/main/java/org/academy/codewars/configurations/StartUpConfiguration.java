package org.academy.codewars.configurations;

import org.academy.codewars.ConsoleScanner;
import org.academy.codewars.controllers.UIController;
import org.academy.codewars.services.AuthorService;
import org.academy.codewars.services.TaskService;
import org.academy.codewars.services.UIService;

import java.util.Scanner;

public class StartUpConfiguration {

    public static UIController initUIController() {
        final ConsoleScanner consoleScanner = new ConsoleScanner(new Scanner(System.in));

        final AuthorService authorService = new AuthorService();
        final TaskService taskService = new TaskService();

        final UIService uiService = new UIService(authorService, taskService, consoleScanner);

        return new UIController(uiService);
    }
}
