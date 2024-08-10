package org.academy.kata.implementation.VladyslavaNezhnova;

import org.academy.kata.Six;

import java.util.Arrays;


public class SixImpl implements Six {
    @Override
    public long findNb(long m) {
        return 0;
    }

    @Override
    public String balance(String book) {
        return "";
    }

    @Override
    public double f(double x) {
        return 0;
    }

    @Override
    public double mean(String town, String strng) {
        return Arrays.stream(strng.split("\n"))
                .filter(line -> line.startsWith(town + ":"))
                .flatMapToDouble(line -> Arrays.stream(line.split(":")[1].split(","))
                        .mapToDouble(entry -> Double.parseDouble(entry.trim().split(" ")[1])))
                .average()
                .orElse(-1);
    }
    @Override
    public double variance(String town, String strng) {
        double mean = mean(town, strng);
        if (mean == -1) return -1;

        return Arrays.stream(strng.split("\n"))
                .filter(line -> line.startsWith(town + ":"))
                .flatMapToDouble(line -> Arrays.stream(line.split(":")[1].split(","))
                        .mapToDouble(entry -> {
                            double value = Double.parseDouble(entry.trim().split(" ")[1]);
                            return Math.pow(value - mean, 2);
                        }))
                .average()
                .orElse(-1);
    }

    @Override
    public String nbaCup(String resultSheet, String toFind) {
        return "";
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        return "";
    }
}
