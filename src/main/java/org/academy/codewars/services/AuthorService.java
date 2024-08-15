package org.academy.codewars.services;

import org.academy.codewars.entities.Author;

import java.util.List;
import java.util.NoSuchElementException;

public class AuthorService {

    public List<Author> getAll() {
        return Author.findAll();
    }

    public Author getById(int id) {
        Author author = Author.findById(id);
        if (author == null) {
            throw new NoSuchElementException("Author not found with id: " + id);
        }
        return author;
    }
}