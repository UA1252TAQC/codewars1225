# codewars1225

## Description
This project is a console application written in Java that allows running specific tasks collected from the Codewars platform. The application provides an interface for selecting a task author and executing their method to perform a specific task.

## Requirements
- Java 8 or later
- IDE to run the application (e.g., IntelliJ IDEA, Eclipse)

## Architecture

### Enums

- **Enum `Authors`:** Contains a list of authors and their corresponding identifiers.
- **Enum `Tasks`:** Contains a list of tasks, including their descriptions and the required parameters for execution.

### Components

- **UIController:** Responsible for interacting with the user through the console, handling user input, and invoking corresponding actions.
- **AuthorController:** Manages operations related to authors (retrieving the list of authors, selecting a specific author).
- **TaskController:** Manages the execution of tasks selected by the user.
- **Services (AuthorService, TaskService):** Provide the logic for working with authors and tasks.
- **Repositories (AuthorRepository, TaskRepository):** Store data about authors and tasks.

## Usage

1. **Running the Application:**
    - Launch the `UIController` in your IDE.

2. **Choosing an Action:**
    - Once started, the user will be prompted to choose one of the options:
        1. View the list of authors.
        2. View the list of tasks.
        3. Run an author’s method to execute a task.

3. **Executing a Task:**
    - The user selects an author, a task, enters the required parameters, after which the task is executed, and the result is displayed in the console.

## Example Usage

To run the program, follow these steps:

1. Open your IDE and make sure you have Java 8 or later installed.
2. Import the project and locate the `UIController` class.
3. Run the `UIController` class.
4. Follow the on-screen prompts to select an author and task, enter parameters, and execute the task.

## Contributing

If you would like to contribute to this project, please follow these steps:

1. Fork the repository.
2. Create a new branch for your feature or bug fix.
3. Commit your changes and push the branch to your fork.
4. Submit a pull request with a detailed explanation of your changes.

## Authors

This project is made by the UA-1252TAQC team.
