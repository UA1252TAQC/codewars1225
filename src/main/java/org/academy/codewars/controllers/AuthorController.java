package org.academy.codewars.controllers;

import org.academy.codewars.entities.Author;
import org.academy.codewars.services.AuthorService;

import java.util.List;

public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }

    public List<Author> getAll() {
        List<Author> authors = authorService.getAll();
        if (authors == null) {
            throw new IllegalStateException("List of Authors can't be null.");
        }

        if (authors.isEmpty()) {
            System.out.println("Map of authors is empty");
        }
        return authors;
    }

    public Author getByID(int id) {
        if (id <= 0) {
            throw new IllegalArgumentException("ID must be a positive number.");
        }
        Author author = authorService.getByID(id);
        if (author == null) {
            throw new IllegalArgumentException("No author with this ID was found.");
        }
        return author;
    }

}