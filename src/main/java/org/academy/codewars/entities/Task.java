package org.academy.codewars.entities;

import java.math.BigInteger;
import org.academy.codewars.ConsoleScanner;

import java.util.Arrays;
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
            getRequiredArgs((scanner) -> scanner.readDouble("length"), (scanner) -> scanner.readDouble("width"), (scanner) -> scanner.readDouble("heigth"))),
    TASK3("Miles per gallon to kilometers per liter",
            "Sometimes, I want to quickly be able to convert miles per imperial gallon (mpg) into kilometers per liter (kpl).",
            (author, params) -> author.getEight().mpgToKPM((float) params.get(0)),
            getRequiredArgs((scanner) -> scanner.readFloat("miles per imperial gallon (mpg)"))),
    TASK4("To square(root) or not to square(root)",
            "If the number has an integer square root, take this, otherwise square the number.",
            (author, params) -> author.getEight().squareOrSquareRoot((int[]) params.get(0)),
            getRequiredArgs((scanner) -> scanner.readIntArray("number > 0"))),
    TASK5("Count of positives / sum of negatives",
            "Return an array, where the first element is the count of positives numbers and the second element is sum of negative numbers. 0 is neither positive nor negative.",
            (author, params) -> author.getEight().countPositivesSumNegatives((int[]) params.get(0)),
            getRequiredArgs((scanner) -> scanner.readIntArray("random number"))),
    TASK6("Convert a String to a Number!",
            "We need a function that can transform a string into a number. What ways of achieving this do you know?",
            (author, params) -> author.getEight().stringToNumber((String) params.get(0)),
            getRequiredArgs((scanner) -> scanner.readString("any number"))),
    TASK7("Wilson primes",
            "Wilson primes satisfy the following condition. Let P represent a prime number. ((P-1)! + 1) / (P * P)",
            (author, params) -> author.getEight().am_i_wilson((double) params.get(0)),
            getRequiredArgs((scanner) -> scanner.readDouble("P"))),
    TASK8("Formatting decimal places #0",
            "Each number should be formatted that it is rounded to two decimal places",
            (author, params) -> author.getEight().TwoDecimalPlaces((double) params.get(0)),
            getRequiredArgs((scanner) -> scanner.readDouble("any number"))),
    TASK9("Find numbers which are divisible by given number",
            "Complete the function which takes two arguments and returns all numbers which are divisible by the given divisor. First argument is an array of numbers and the second is the divisor.",
            (author, params) -> author.getEight().divisibleBy((int[]) params.get(0), (int) params.get(1)),
            getRequiredArgs((scanner) -> scanner.readIntArray("any number"), (scanner) -> scanner.readInt("divisor"))),
    TASK10("Looking for a benefactor",
            "The function should return the expected donation (rounded up to the next integer) that will permit to reach the average.",
            (author, params) -> author.getSeven().newAvg((double[]) params.get(0), (double) params.get(1)),
            getRequiredArgs((scanner) -> scanner.readDoubleArray("any number"), (scanner) -> scanner.readDouble("average"))),
    TASK11("Sum of the first nth term of Series",
            "Returns the n-th term of the following series, which is the sum of the first n terms of the sequence (n is the input parameter).",
            (author, params) -> author.getSeven().seriesSum((int) params.get(0)),
            getRequiredArgs((scanner) -> scanner.readInt("n"))),
    TASK12("Build a pile of Cubes",
            "You are given the total volume m of the building. Being given m can you find the number n of cubes you will have to build?",
            (author, params) ->
                    author.getSix().findNb((long) params.get(0)),
            getRequiredArgs((scanner) -> scanner.readLong("m"))),
    TASK13("Easy Balance Checking",
            "You are given a (small) check book as a - sometimes - cluttered",
            (author, params) -> author.getSix().balance((String) params.get(0)),
            getRequiredArgs((scanner) -> scanner.readString("book"))),
    TASK14("Floating-point Approximation (I)",
            "Consider the function f: x -> sqrt(1 + x) - 1 at x = 1e-15.",
            (author, params) -> author.getSix().f((double) params.get(0)),
            getRequiredArgs((scanner) -> scanner.readDouble("x"))),
    TASK15_1("Rainfall - mean",
            "function: mean(town, strng) should return the average of rainfall for the city town and the strng data or data1 (In R and Julia this function is called avg).",
            (author, params) -> author.getSix().mean((String) params.get(0), (String) params.get(1)),
            getRequiredArgs((scanner) -> scanner.readString("town"), (scanner) -> scanner.readString("strng"))),
    TASK15_2("Rainfall - variance",
            "function: variance(town, strng) should return the variance of rainfall for the city town and the strng data or data1.",
            (author, params) -> author.getSix().mean((String) params.get(0), (String) params.get(1)),
            getRequiredArgs((scanner) -> scanner.readString("town"), (scanner) -> scanner.readString("strng"))),
    TASK16("Ranking NBA teams",
            "You are given a string with results of NBA teams separated by commas",
            (author, params) -> author.getSix().nbaCup((String) params.get(0), (String) params.get(1)),
            getRequiredArgs((scanner) -> scanner.readString("resultSheet"), (scanner) -> scanner.readString("toFind"))),
    TASK17("Help the bookseller !",
            "A bookseller has lots of books classified in 26 categories labeled A, B, ... Z. Each book has a code c of 3, 4, 5 or more characters. The 1st character of a code is a capital letter which defines the book category.",
            (author, params) -> author.getSix().stockSummary((String[]) params.get(0), (String[]) params.get(1)),
            getRequiredArgs((scanner) -> scanner.readStringArray("lstOfArt"), (scanner) -> scanner.readStringArray("lstOf1stLetter"))),
    TASK18("Gap in Primes",
            "A prime gap of length n is a run of n-1 consecutive composite numbers between two successive primes",
            (author, params) -> author.getFive().gap((int) params.get(0), (long) params.get(1), (long) params.get(2)),
            getRequiredArgs((scanner) -> scanner.readInt("g"), (scanner) -> scanner.readLong("m"), (scanner) -> scanner.readLong("n"))),
    TASK19("Number of trailing zeros of N!",
            "Program will calculate the number of trailing zeros in a factorial of a given number",
            (author, params) -> author.getFive().zeros((int) params.get(0)),
            getRequiredArgs((scanner) -> scanner.readInt("N"))),
    TASK20("Perimeter of squares in a rectangle",
            "The drawing shows 6 squares the sides of which have a length of 1, 1, 2, 3, 5, 8.",
            (author, params) -> author.getFive().perimeter((BigInteger) params.get(0)),
            getRequiredArgs((scanner) -> scanner.readBigInteger("n"))),
    TASK21("Which x for that sum?",
            "Consider the sequence U(n, x) = x + 2x**2 + 3x**3 + .. + nx**n where x is a real number and n a positive integer.",
            (author, params) -> author.getFive().solve((double) params.get(0)),
            getRequiredArgs((scanner) -> scanner.readDouble("m"))),
    TASK22("Find the smallest",
            "You have a positive number n consisting of digits.",
            (author, params) ->author.getFive().smallest((long) params.get(0)),
            getRequiredArgs((scanner) -> scanner.readLong("n")));

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

    public static Task findById(int id) {
        for (Task task: values()) {
            if(task.getId() == id) {
                return task;
            }
        }
        return null;
    }

    public static List<Task> findAll() {
        return Arrays.asList(values());
    }
}
