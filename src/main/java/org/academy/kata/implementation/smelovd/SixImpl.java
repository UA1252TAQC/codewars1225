package org.academy.kata.implementation.smelovd;

import org.academy.kata.Six;

public class SixImpl implements Six {
    @Override
    public long findNb(long m) {
        return 0;
    }

    @Override
    public String balance(String book) {
        if (book == null || book.trim().isEmpty()) {
            throw new IllegalArgumentException();
        }

        final StringBuilder builder = new StringBuilder();
        final String[] clearLines = book.replaceAll("[^\r\n a-zA-Z0-9.]", "").trim().split("\n");

        final double finalOriginalBalance = Double.parseDouble(clearLines[0]);
        double originalBalance = finalOriginalBalance;
        builder.append("Original Balance: ").append(clearLines[0]);
        for (int i = 1; i < clearLines.length; i++) {
            while (clearLines[i].contains("  ")) {
                clearLines[i] = clearLines[i].replaceAll("  ", " ");
            }
            String[] lineVariables = clearLines[i].split(" ");
            builder.append("\\r\\n").append(clearLines[i].trim());

            originalBalance = Math.round((originalBalance - Double.parseDouble(lineVariables[2])) * 100.0) / 100.0;
            builder.append(" Balance ").append(String.format("%.2f", originalBalance));
        }

        this.setExpenses(builder, finalOriginalBalance, originalBalance, clearLines.length - 1);
        return builder.toString();
    }

    private void setExpenses(StringBuilder builder, double finalOriginalBalance, double originalBalance, int count) {
        double totalExpense = Math.round((finalOriginalBalance - originalBalance) * 100.0) / 100.0;
        builder.append("\\r\\nTotal expense  ").append(String.format("%.2f", totalExpense));

        double averageExpense = Math.round(totalExpense / count * 100.0) / 100.0;
        builder.append("\\r\\nAverage expense  ").append(String.format("%.2f", averageExpense));
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
