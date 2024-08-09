package org.academy.kata.implementation.smelovd;

import org.academy.kata.Six;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

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
        return 0;
    }

    @Override
    public double variance(String town, String strng) {
        return 0;
    }

    @Override
    public String nbaCup(String resultSheet, String toFind) {
        return "";
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        final Map<Character, Integer> categoryCounts = Arrays.stream(lstOfArt)
                .collect(Collectors.groupingBy(s -> s.charAt(0), Collectors.summingInt(s -> Integer.parseInt(s.split(" ")[1]))));
        if (isAllZeros(lstOf1stLetter, categoryCounts)) {
            return "";
        }
        return Arrays.stream(lstOf1stLetter)
                .map(letter -> {
                    int count = categoryCounts.getOrDefault(letter.charAt(0), 0);
                    return "(" + letter + " : " + count + ")";
                }).collect(Collectors.joining(" - "));
    }

    private boolean isAllZeros(String[] lstOf1stLetter, Map<Character, Integer> categoryCounts) {
        return Arrays.stream(lstOf1stLetter).allMatch(letter -> categoryCounts.getOrDefault(letter.charAt(0), 0) == 0);
    }
}
