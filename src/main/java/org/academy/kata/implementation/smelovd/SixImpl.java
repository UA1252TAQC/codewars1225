package org.academy.kata.implementation.smelovd;

import org.academy.kata.Six;

import java.util.Arrays;
import java.util.stream.DoubleStream;

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
        return getStream(town, strng).average().orElse(-1);
    }

    @Override
    public double variance(String town, String strng) {
        final double avg = mean(town, strng);
        return getStream(town, strng).map(i -> Math.pow(avg - i, 2)).average().orElse(-1);
    }

    private static DoubleStream getStream(String town, String strng) {
        return Arrays.stream(strng.split("\n"))
                .filter(townData -> townData.startsWith(town + ":"))
                .map(townData -> townData.substring(town.length() + 1))
                .flatMapToDouble(townData -> Arrays.stream(townData.split(","))
                        .map(monthData -> monthData.split(" ")[1])
                        .mapToDouble(Double::parseDouble));
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
