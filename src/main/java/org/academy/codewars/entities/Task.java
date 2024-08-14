package org.academy.codewars.entities;

import org.academy.codewars.ConsoleScanner;

import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Function;

public enum Task {
    TASK1("Keep Hydrated!",
            "You get given the time in hours and you need to return the number of litres Nathan will drink, rounded to the smallest value.",
            (author, params) -> author.getEight().liters((double) params.get(0)),
            getRequiredArgs((scanner) -> scanner.readDouble("time"))),
    TASK2("Volume of a Cuboid",
            "Bob needs a fast way to calculate the volume of a cuboid with three values: the length, width and height of the cuboid.",
            (author, params) -> author.getEight().getVolumeOfCuboid((double) params.get(0), (double) params.get(1), (double) params.get(2)),
            getRequiredArgs((scanner) -> scanner.readDouble("length"), (scanner) -> scanner.readDouble("width"), (scanner) -> scanner.readDouble("heigth")));

    @SafeVarargs
    private static Function<ConsoleScanner, Object>[] getRequiredArgs(Function<ConsoleScanner, Object>... args) {
        return args;
    }

    private final String title;
    private final String description;
    private final BiFunction<Author, List<Object>, ?> supplier;
    private final Function<ConsoleScanner, ?>[] requiredParams;

    Task(String title, String description, BiFunction<Author, List<Object>, ?> supplier, Function<ConsoleScanner, ?>[] requiredParams) {
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

    public BiFunction<Author, List<Object>, ?> getSupplier() {
        return supplier;
    }

    public Function<ConsoleScanner, ?>[] getRequiredParams() {
        return requiredParams;
    }
}
