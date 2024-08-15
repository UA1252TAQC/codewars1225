package org.academy.codewars.services;

import org.academy.codewars.entities.Author;

import java.util.List;

public class AuthorService {

    public List<Author> getAll() {
        return Author.findAll();
    }

    public Author getById(int id) {
        Author author = Author.findById(id);
        if (author == null) {
            throw new RuntimeException("Author not found with id: " + id);
        }
        return author;
    }
}