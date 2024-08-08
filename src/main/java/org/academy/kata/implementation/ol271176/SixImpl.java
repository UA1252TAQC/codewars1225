package org.academy.kata.implementation.ol271176;

import org.academy.kata.Six;

public class SixImpl implements Six {
    @Override
    public long findNb(long m) {
        return 0;
    }

    @Override
    public String balance(String book) {
        // delete empty lines
        String[] lines = book.split("\n");
        StringBuilder result = new StringBuilder();

        //find balance
        double balance = Double.parseDouble(lines[0].replaceAll("[^0-9.]", ""));
        result.append(String.format("Original_Balance: %.2f%s", balance, System.lineSeparator()));
        double totalExpense = 0, avgExpense = 0, count = 0;

        //process each line
        for(int i=1; i<lines.length; i++){
            String proccessedLine = lines[i].replaceAll("[^a-zA-Z0-9. ]", "");

            if(proccessedLine.isEmpty()) continue;

            String[] info = proccessedLine.split(" ");
            int checkNumber = Integer.parseInt(info[0]);
            String category = info[1];
            double checkAmount = Double.parseDouble(info[2]);
            double totalAmount = balance - checkAmount;
            balance -= checkAmount;

            totalExpense += checkAmount;
            count++;

            result.append(String.format("%d %s %.2f Balance %.2f%s", checkNumber, category, checkAmount, balance, System.lineSeparator()));
        }
        result.append(String.format("Total expense  %.2f%s", totalExpense, System.lineSeparator()));
        result.append(String.format("Average expense  %.2f", totalExpense/count));

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
