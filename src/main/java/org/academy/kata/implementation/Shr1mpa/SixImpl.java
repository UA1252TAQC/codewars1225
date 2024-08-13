package org.academy.kata.implementation.Shr1mpa;

import org.academy.kata.Six;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class SixImpl implements Six {
    @Override
    public long findNb(long m) {
        long sum = 0;
        int n = 0;

        while (sum < m) {
            n++;
            sum += (long) Math.pow(n, 3);
        }

        return (sum == m) ? n : -1;
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
        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0) {
            return "";
        }
        Map<Character, Integer> map = Arrays.stream(lstOf1stLetter)
                .map(letter -> letter.charAt(0))
                .collect(Collectors.toMap(letter -> letter, letter -> 0));
        for (String s : lstOfArt) {
            String[] parts = s.split(" ");
            char key = parts[0].charAt(0);
            int valueToAdd = Integer.parseInt(parts[1]);

            if (map.containsKey(key)) {
                map.put(key, map.get(key) + valueToAdd);
            }
        }

        return map.entrySet().stream()
                .map(entry -> String.format("(%c : %d)", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(" - "));
    }
}
