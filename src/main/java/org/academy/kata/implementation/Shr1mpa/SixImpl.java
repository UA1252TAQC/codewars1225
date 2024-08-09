package org.academy.kata.implementation.Shr1mpa;

import org.academy.kata.Six;

public class SixImpl implements Six {
    @Override
    public long findNb(long m) {
        return 0;
    }

    @Override
    public String balance(String book) {
        String regex = "[^a-zA-Z0-9 \\n\\r.]";
        String withoutSpecialChars = book.replaceAll(regex, "");
        String[] lines = withoutSpecialChars.split("\\r?\\n");
        StringBuilder sb = new StringBuilder();

        double balance = Double.parseDouble(lines[0].trim());
        sb.append(String.format("Original Balance: %.2f\\r\\n", balance));

        double totalExpense = 0.0;
        int transactionCount = 0;

        for (int i = 1; i < lines.length; i++) {
            String line = lines[i].trim();
            String[] parts = line.split("\\s+");

            String checkNumber = parts[0];
            String category = parts[1];
            double expense = Double.parseDouble(parts[2]);

            balance -= expense;
            totalExpense += expense;
            transactionCount++;

            sb.append(String.format("%s %s %.2f Balance %.2f\\r\\n", checkNumber, category, expense, balance));
        }

        sb.append(String.format("Total expense  %.2f\\r\\n", totalExpense));
        sb.append(String.format("Average expense  %.2f", totalExpense / transactionCount));
        return sb.toString();
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
