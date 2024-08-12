package org.academy.kata.implementation.smelovd;

import org.academy.kata.Six;

public class SixImpl implements Six {
    @Override
    public long findNb(long m) {
        return 0;
    }

    @Override
    public String balance(String book) {
        if (book == null || book.isEmpty()) throw new IllegalArgumentException();
        final String[] clearLines = book.replaceAll("([^\\n. \\da-zA-Z])", "").split("\n");
        final double startBalance = Double.parseDouble(clearLines[0]);
        double currentBalance = startBalance;
        int count = 0;
        StringBuilder result = new StringBuilder().append("Original Balance: ").append(clearLines[0]);
        for (int i = 1; i < clearLines.length; i++, count++) {
            String[] lineVariables = clearLines[i].split("[ ]+");
            currentBalance -= Double.parseDouble(lineVariables[2]);
            result.append(String.format("\\r\\n%s %s %s Balance %.2f", lineVariables[0], lineVariables[1], lineVariables[2], currentBalance));
        }
        result.append(String.format("\\r\\nTotal expense  %.2f\\r\\nAverage expense  %.2f", startBalance - currentBalance, (startBalance - currentBalance) / count));
        return result.toString();
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
