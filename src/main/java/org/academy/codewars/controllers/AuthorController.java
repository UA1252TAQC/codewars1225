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
        return authorService.getAll();
    }

    public Author getById(int id) {
        if (id < 0) throw new IllegalArgumentException("ID must be a positive number.");
        return authorService.getById(id);
    }
}