package org.academy.codewars.entities;

import java.math.BigInteger;
import java.util.List;
import java.util.function.BiFunction;

public enum Task {
    TASK1("Keep Hydrated!",
            "You get given the time in hours and you need to return the number of litres Nathan will drink, rounded to the smallest value.",
            (author, params) -> author.getEight().liters((double) params.get(0)),
            new String[]{"double"}),
    TASK2("Volume of a Cuboid",
            "Bob needs a fast way to calculate the volume of a cuboid with three values: the length, width and height of the cuboid.",
            (author, params) ->
                    author.getEight().getVolumeOfCuboid((double) params.get(0), (double) params.get(1), (double) params.get(2)),
            new String[]{"double", "double", "double"}),
    TASK3("Miles per gallon to kilometers per liter",
            "Sometimes, I want to quickly be able to convert miles per imperial gallon (mpg) into kilometers per liter (kpl).",
            (author, params) ->
                    author.getEight().mpgToKPM((float) params.get(0)),
            new String[]{"float"}),
    TASK4("To square(root) or not to square(root)",
            "If the number has an integer square root, take this, otherwise square the number.",
            (author, params) ->
                    author.getEight().squareOrSquareRoot((int[]) params.get(0)),
            new String[]{"int[]"}),
    TASK5("Count of positives / sum of negatives",
            "Return an array, where the first element is the count of positives numbers and the second element is sum of negative numbers. 0 is neither positive nor negative.",
            (author, params) ->
                    author.getEight().countPositivesSumNegatives((int[]) params.get(0)),
            new String[]{"int[]"}),
    TASK6("Convert a String to a Number!",
            "We need a function that can transform a string into a number. What ways of achieving this do you know?",
            (author, params) ->
                    author.getEight().stringToNumber((String) params.get(0)),
            new String[]{"String"}),
    TASK7("Wilson primes",
            "Wilson primes satisfy the following condition. Let P represent a prime number. ((P-1)! + 1) / (P * P)",
            (author, params) ->
                    author.getEight().am_i_wilson((double) params.get(0)),
            new String[]{"double"}),
    TASK8("Formatting decimal places #0",
            "Each number should be formatted that it is rounded to two decimal places",
            (author, params) ->
                    author.getEight().TwoDecimalPlaces((double) params.get(0)),
            new String[]{"double"}),
    TASK9("Find numbers which are divisible by given number",
            "Complete the function which takes two arguments and returns all numbers which are divisible by the given divisor. First argument is an array of numbers and the second is the divisor.",
            (author, params) ->
                    author.getEight().divisibleBy((int[]) params.get(0), (int) params.get(1)),
            new String[]{"int[]", "int"}),
    TASK10("Looking for a benefactor",
            "The function should return the expected donation (rounded up to the next integer) that will permit to reach the average.",
            (author, params) ->
                    author.getSeven().newAvg((double[]) params.get(0), (double) params.get(1)),
            new String[]{"double[]", "double"}),
    TASK11("Sum of the first nth term of Series",
            "Returns the n-th term of the following series, which is the sum of the first n terms of the sequence (n is the input parameter).",
            (author, params) ->
                    author.getSeven().seriesSum((int) params.get(0)),
            new String[]{"int"}),
    TASK12("Build a pile of Cubes",
            "You are given the total volume m of the building. Being given m can you find the number n of cubes you will have to build?",
            (author, params) ->
                    author.getSix().findNb((long) params.get(0)),
            new String[]{"long"}),
    TASK13("Easy Balance Checking",
            "You are given a (small) check book as a - sometimes - cluttered",
            (author, params) ->
                    author.getSix().balance((String) params.get(0)),
            new String[]{"String"}),
    TASK14("Floating-point Approximation (I)",
            "Consider the function f: x -> sqrt(1 + x) - 1 at x = 1e-15.",
            (author, params) ->
                    author.getSix().f((double) params.get(0)),
            new String[]{"double"}),
    TASK15("Rainfall - mean",
            "function: mean(town, strng) should return the average of rainfall for the city town and the strng data or data1 (In R and Julia this function is called avg).",
            (author, params) ->
                    author.getSix().mean((String) params.get(0), (String) params.get(1)),
            new String[]{"String", "String"}),
    TASK16("Rainfall - variance",
            "function: variance(town, strng) should return the variance of rainfall for the city town and the strng data or data1.",
            (author, params) ->
                    author.getSix().mean((String) params.get(0), (String) params.get(1)),
            new String[]{"String", "String"}),
    TASK17("Ranking NBA teams",
            "You are given a string with results of NBA teams separated by commas",
            (author, params) ->
                    author.getSix().nbaCup((String) params.get(0), (String) params.get(1)),
            new String[]{"String", "String"}),
    TASK18("Help the bookseller !",
            "A bookseller has lots of books classified in 26 categories labeled A, B, ... Z. Each book has a code c of 3, 4, 5 or more characters. The 1st character of a code is a capital letter which defines the book category.",
            (author, params) ->
                    author.getSix().stockSummary((String[]) params.get(0), (String[]) params.get(1)),
            new String[]{"String[]", "String[]"}),
    TASK19("Gap in Primes",
            "A prime gap of length n is a run of n-1 consecutive composite numbers between two successive primes",
            (author, params) ->
                    author.getFive().gap((int) params.get(0), (long) params.get(1), (long) params.get(2)),
            new String[]{"int", "long", "long"}),
    TASK20("Number of trailing zeros of N!",
            "Program will calculate the number of trailing zeros in a factorial of a given number",
            (author, params) ->
                    author.getFive().zeros((int) params.get(0)),
            new String[]{"int"}),
    TASK21("Perimeter of squares in a rectangle",
            "The drawing shows 6 squares the sides of which have a length of 1, 1, 2, 3, 5, 8.",
            (author, params) ->
                    author.getFive().perimeter((BigInteger) params.get(0)),
            new String[]{"BigInteger"}),
    TASK22("Which x for that sum?",
            "Consider the sequence U(n, x) = x + 2x**2 + 3x**3 + .. + nx**n where x is a real number and n a positive integer.",
            (author, params) ->
                    author.getFive().solve((double) params.get(0)),
            new String[]{"double"}),
    TASK23("Find the smallest",
            "You have a positive number n consisting of digits.",
            (author, params) ->
                    author.getFive().smallest((long) params.get(0)),
            new String[]{"long"});

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
