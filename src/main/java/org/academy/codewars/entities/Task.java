package org.academy.codewars.entities;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Supplier;

public enum Task {
    TASK1("Title1", "Description1", () -> new Object(), new ArrayList<>()),
    TASK2("Title2", "Description2", () -> new Object(), new ArrayList<>()),
    TASK3("Title3", "Description3", () -> new Object(), new ArrayList<>());

    private final String title;
    private final String description;
    private final Supplier<Object> supplier;
    private final List<String> requiredParams;

    Task(String title, String description, Supplier<Object> supplier, List<String> requiredParams) {
        this.title = title;
        this.description = description;
        this.supplier = supplier;
        this.requiredParams = requiredParams;
    }

    public int getId() {
        return this.ordinal();
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public Supplier<Object> getSupplier() {
        return supplier;
    }

    public List<String> getRequiredParams() {
        return requiredParams;
    }
}