package org.academy.codewars.configurations;

import org.academy.codewars.controllers.AuthorController;
import org.academy.codewars.controllers.TaskController;
import org.academy.codewars.controllers.UIController;
import org.academy.codewars.repositories.AuthorRepository;
import org.academy.codewars.repositories.TaskRepository;
import org.academy.codewars.services.AuthorService;
import org.academy.codewars.services.TaskService;

public class StartupConfiguration {
    public static UIController initUIController() {
        AuthorRepository authorRepository = new AuthorRepository();
        TaskRepository taskRepository = new TaskRepository();

        AuthorService authorService = new AuthorService(authorRepository);
        TaskService taskService = new TaskService(taskRepository, authorService);

        AuthorController authorController = new AuthorController(authorService);
        TaskController taskController = new TaskController(taskService);

        return new UIController(authorController, taskController);
    }
}
