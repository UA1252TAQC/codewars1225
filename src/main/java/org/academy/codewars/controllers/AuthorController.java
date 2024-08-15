package org.academy.codewars.controllers;

import org.academy.codewars.entities.Author;
import org.academy.codewars.services.AuthorService;

import java.util.Optional;

public class AuthorController {
    private final AuthorService authorService;

    public AuthorController(AuthorService authorService) {
        this.authorService = authorService;
    }


    public Author getById(int id) {
        return Optional.ofNullable(Author.findById(id))
                .orElseThrow(() -> new IllegalArgumentException("ID must be in a correct range"));
    }
}