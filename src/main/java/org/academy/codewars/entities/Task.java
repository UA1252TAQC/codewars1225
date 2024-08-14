package org.academy.codewars.entities;

import java.util.List;
import java.util.function.Supplier;

public enum Task {
    TASK1("Title1", "Description1", () -> new Object(), List.of("Param1"), "Task1"),
    TASK2("Title2", "Description2", () -> new Object(), List.of("Param2"), "Task2"),
    TASK3("Title3", "Description3", () -> new Object(), List.of("Param3"), "Task3");

    private final String title;
    private final String description;
    private final Supplier<Object> supplier;
    private final List<String> requiredParams;
    private final String task;

    Task(String title, String description, Supplier<Object> supplier, List<String> requiredParams, String task) {
        this.title = title;
        this.description = description;
        this.supplier = supplier;
        this.requiredParams = requiredParams;
        this.task = task;
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

    public String getTask() {
        return task;
    }
}