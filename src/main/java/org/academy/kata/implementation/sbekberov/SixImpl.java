package org.academy.kata.implementation.sbekberov;

import org.academy.kata.Six;

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
        String[] records = strng.split("\n");
        String townRecord = null;

        for (String record : records) {
            if (record.startsWith(town + ":")) {
                townRecord = record;
                break;
            }
        }

        if (townRecord == null) {
            return -1;
        }

        String[] monthlyData = townRecord.split(":")[1].split(",");
        double sum = 0;
        int count = 0;

        for (String data : monthlyData) {
            String[] parts = data.split(" ");
            double rainfall = Double.parseDouble(parts[1]);
            sum += rainfall;
            count++;
        }

        return sum / count;
    }

    @Override
    public double variance(String town, String strng) {
        double meanValue = mean(town, strng);
        if (meanValue == -1) {
            return -1;
        }

        String[] records = strng.split("\n");
        String townRecord = null;

        for (String record : records) {
            if (record.startsWith(town + ":")) {
                townRecord = record;
                break;
            }
        }

        String[] monthlyData = townRecord.split(":")[1].split(",");
        double sumOfSquares = 0;
        int count = 0;

        for (String data : monthlyData) {
            String[] parts = data.split(" ");
            double rainfall = Double.parseDouble(parts[1]);
            sumOfSquares += Math.pow(rainfall - meanValue, 2);
            count++;
        }

        return sumOfSquares / count;
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
