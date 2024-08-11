package org.academy.kata.implementation.oleksandrtkv;

import org.academy.kata.Six;

import java.text.DecimalFormat;
import java.util.Arrays;

public class SixImpl implements Six {
    @Override
    public long findNb(long m) {
        return 0;
    }

    @Override
    public String balance(String book) {
        DecimalFormat df = new DecimalFormat("0.00");
        StringBuilder builder = new StringBuilder();

        String replaced = book.replaceAll("[^a-zA-Z0-9. \n]", "");
        String[] split = replaced.split("\n");
        split = Arrays.stream(split).filter(line -> !line.trim().isEmpty()).toArray(String[]::new);
        for(int i = 0; i < split.length; i++){
            split[i] = split[i].replaceAll("\\s+", " ").trim();
        }

        builder.append("Original Balance: ").append(split[0]).append("\\r\\n");

        double originalBalance = Double.parseDouble(split[0]);
        for (int i = 1; i < split.length; i++) {
            builder.append(split[i]).append(" Balance ");
            String[] innerSplit = split[i].split(" ");
            originalBalance -= Double.parseDouble(innerSplit[2]);
            builder.append(df.format(Math.round(originalBalance * 100.0) / 100.0)).append("\\r\\n");
        }

        double totalExpense = 0;
        for (int i = 1; i < split.length; i++) {
            String[] innerSplit = split[i].split(" ");
            totalExpense += Double.parseDouble(innerSplit[2]);
        }
        builder.append("Total expense  ").append(df.format(Math.round(totalExpense * 100.0) / 100.0)).append("\\r\\n");

        double averageExpense = Math.round((totalExpense / (split.length - 1)) * 100.0) / 100.0;
        builder.append("Average expense  ").append(df.format(averageExpense));

        return builder.toString();
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
        return "";
    }
}
