package org.academy.codewars.repositories;

import org.academy.codewars.entities.Author;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class AuthorRepository {

    private final List<Author> authors = Arrays.asList(Author.values());

    public List<Author> findAll() {
        return authors;
    }

    public Optional<Author> findById(int id) {
        return authors.stream()
                .filter(author -> author.getId() == id)
                .findFirst();
    }

}
