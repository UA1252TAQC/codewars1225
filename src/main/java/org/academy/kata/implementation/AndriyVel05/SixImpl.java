package org.academy.kata.implementation.AndriyVel05;

import org.academy.kata.Base;
import org.academy.kata.Six;

public class SixImpl extends Base implements Six {
    @Override
    public long findNb(long m) {
        return 0;
    }

    @Override
    public String balance(String book) {
        String[] lines = book.split("\n");
        double originBalance = Double.parseDouble(lines[0]);
        double balance = originBalance;
        double totalExpense = 0.0;
        StringBuilder report = new StringBuilder();

        report.append(String.format("Original Balance: %.2f\n", originBalance));

        for (int i = 1; i < lines.length; i++) {
            if (lines[i].trim().isEmpty()) continue;

            String cleanLine = lines[i].replaceAll("[^a-zA-Z0-9. ]", "");
            String[] parts = cleanLine.split(" ");
            double expense = Double.parseDouble(parts[parts.length - 1]);
            balance -= expense;
            totalExpense += expense;

            report.append(String.format("%s %s %.2f Balance %.2f\n",
                    parts[0], parts[1], expense, balance));
        }

        report.append(String.format("Total expense  %.2f\n", totalExpense));
        report.append(String.format("Average expense  %.2f", totalExpense / (lines.length - 1)));

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
