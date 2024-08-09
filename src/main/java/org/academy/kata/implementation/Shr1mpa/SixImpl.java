package org.academy.kata.implementation.Shr1mpa;

import org.academy.kata.Six;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        String line = findLine(town, strng);
        if (line.isEmpty()) {
            return -1;
        }
        List<Double> numbers = findDegrees(line);
        double sum = numbers.stream()
                .mapToDouble(Double::doubleValue)
                .sum();
        return sum / numbers.size();
    }

    @Override
    public double variance(String town, String strng) {
        String line = findLine(town, strng);
        if (line.isEmpty()) {
            return -1;
        }
        List<Double> numbers = findDegrees(line);
        double mean = mean(town, strng);

        double sumOfSquares = 0;
        for (Double number : numbers) {
            sumOfSquares += Math.pow(number - mean, 2);
        }

        return sumOfSquares / numbers.size();
    }

    @Override
    public String nbaCup(String resultSheet, String toFind) {
        return "";
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        return "";
    }

    private String findLine(String town, String strng) {
        String[] lines = strng.split("\\n");
        for (String line : lines) {
            if (line.startsWith(town + ":")) {
                return line.substring(town.length() + 1);
            }
        }
        return "";
    }

    private List<Double> findDegrees(String strng) {
        String regex = "\\d+\\.\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(strng);

        List<Double> numbers = new ArrayList<>();

        while (matcher.find()) {
            String numberStr = matcher.group();
            double number = Double.parseDouble(numberStr);
            numbers.add(number);
        }
        return numbers;
    }
}
