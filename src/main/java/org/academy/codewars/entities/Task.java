package org.academy.codewars.entities;

import java.util.List;
import java.util.function.BiFunction;

public enum Task {
    TASK1("Keep Hydrated!",
            "You get given the time in hours and you need to return the number of litres Nathan will drink, rounded to the smallest value.",
            (author, params) -> author.getEight().liters((Double) params.get(0)),
            new String[]{"Enter time(Ex: 7.32)"}),
    TASK2("Volume of a Cuboid",
            "Bob needs a fast way to calculate the volume of a cuboid with three values: the length, width and height of the cuboid.",
            (author, params) ->
                    author.getEight().getVolumeOfCuboid((Double) params.get(0), (Double) params.get(1), (Double) params.get(2)),
            new String[]{"Enter length(Ex: 2)", "Enter width(Ex.: 4.1)", "Enter width(Ex.: 3.9)"}),
    TASK3("Miles per gallon to kilometers per liter",
            "Sometimes, I want to quickly be able to convert miles per imperial gallon (mpg) into kilometers per liter (kpl).",
            (author, params) ->
                    String.valueOf(author.getEight().mpgToKPM((Float) params.get(0))),
            new String[]{"Enter mpg(Ex: 2.2)"});

    private final String title;
    private final String description;
    private final BiFunction<Author, List<Object>, ?> supplier;
    private final String[] requiredParams;

    Task(String title, String description, BiFunction<Author, List<Object>, ?> supplier, String[] requiredParams) {
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

    public String[] getRequiredParams() {
        return requiredParams;
    }
}
