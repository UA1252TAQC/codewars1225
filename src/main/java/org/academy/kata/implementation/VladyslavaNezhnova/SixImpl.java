package org.academy.kata.implementation.VladyslavaNezhnova;

import org.academy.kata.Six;

public class SixImpl implements Six {
    @Override
    public long findNb(long m) {
        return 0;
    }

    @Override
    public String balance(String book) {
        book = book.replaceAll("[^a-zA-Z0-9.\\s]", "");

        String[] lines = book.split("\\n+");
        double originalBalance = Double.parseDouble(lines[0]);
        double currentBalance = originalBalance;
        double totalExpense = 0.0;

        StringBuilder report = new StringBuilder();
        report.append("Original Balance: ").append(String.format("%.2f", originalBalance)).append("\\r\\n");


        for (int i = 1; i < lines.length; i++) {
            String[] parts = lines[i].split("\\s+");
            double expense = Double.parseDouble(parts[2]);
            currentBalance -= expense;
            totalExpense += expense;

            report.append(parts[0]).append(" ").append(parts[1]).append(" ")
                    .append(String.format("%.2f", expense)).append(" Balance ")
                    .append(String.format("%.2f", currentBalance)).append("\\r\\n");
        }

        report.append("Total expense  ").append(String.format("%.2f", totalExpense)).append("\\r\\n");
        report.append("Average expense  ").append(String.format("%.2f", totalExpense / (lines.length - 1)));

        return report.toString();
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
