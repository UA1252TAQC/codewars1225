package org.academy.codewars.entities;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Supplier;

public enum Task {
    TASK1("Keep Hydrated!",
            "You get given the time in hours and you need to return the number of litres Nathan will drink, rounded to the smallest value.",
            (author, params) -> String.valueOf(author.getEight().liters(Double.parseDouble(Arrays.toString(params)))),
            new ArrayList<>(Collections.singletonList("Enter time(Ex: 7.32)"))),
    TASK2("Volume of a Cuboid",
            "Bob needs a fast way to calculate the volume of a cuboid with three values: the length, width and height of the cuboid.",
            (author, params) ->
                    String.valueOf(author.getEight().getVolumeOfCuboid(
                            Double.parseDouble(params[0].toString()),
                            Double.parseDouble(params[1].toString()),
                            Double.parseDouble(params[2].toString()))),
            new ArrayList<>(Arrays.asList("Enter length(Ex: 2)", "Enter width(Ex.: 4.1)", "Enter width(Ex.: 3.9)"))),
    TASK3("Miles per gallon to kilometers per liter",
            "Sometimes, I want to quickly be able to convert miles per imperial gallon (mpg) into kilometers per liter (kpl).",
            (author, params) ->
                    String.valueOf(author.getEight().mpgToKPM(
                            Float.parseFloat(Arrays.toString(params)))),
            new ArrayList<>(Collections.singletonList("Enter mpg(Ex: 2.2)")));
    private final String title;
    private final String description;
    private final BiFunction<Author, Object[], String> supplier;
    private final List<String> requiredParams;

    Task(String title, String description, BiFunction<Author, Object[], String> supplier, List<String> requiredParams) {
        this.title = title;
        this.description = description;
        this.supplier = supplier;
        this.requiredParams = requiredParams;
    }

    public String getTitle() {
        return title;
    }

    public String getDescription() {
        return description;
    }

    public BiFunction<Author, Object[], String> getSupplier() {
        return supplier;
    }

    public List<String> getRequiredParams() {
        return requiredParams;
    }
}
