package org.academy.kata.implementation.YanOleks;

import org.academy.kata.Six;

public class SixImpl implements Six {
    @Override
    public long findNb(long m) {
        return 0;
    }

    @Override
    public String balance(String book) {
        String raw = book.replaceAll("[^\\w \\n\\r.]", "");
        String[] lines = raw.split("\\n");

        StringBuilder sb = new StringBuilder();
        double balance = Double.parseDouble(lines[0].trim());
        sb.append(String.format("Original Balance: %.2f\\r\\n", balance));

        double totalExpense = 0;
        int numberOfExpenses = 0;
        for (int i = 1; i < lines.length; i++){
            if (lines[i].isEmpty()) continue;
            String line = lines[i].replaceAll("(?<=\\s)\\s", "").trim();
            double expense = Double.parseDouble(line.substring(line.lastIndexOf(" ") + 1));
            balance -= expense;
            totalExpense += expense;
            sb.append(String.format("%s Balance %.2f\\r\\n", line.trim(), balance));
            numberOfExpenses++;
        }
        sb.append(String.format("Total expense  %.2f\\r\\n", totalExpense));
        sb.append(String.format("Average expense  %.2f", totalExpense / numberOfExpenses));
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
