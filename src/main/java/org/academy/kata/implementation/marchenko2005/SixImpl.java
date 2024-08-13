package org.academy.kata.implementation.marchenko2005;

import org.academy.kata.Six;

public class SixImpl implements Six {
    @Override
    public long findNb(long m) {
        return 0;
    }

    @Override
    public String balance(String book) {
        book = book.replaceAll("[^a-zA-Z0-9.\\s]", "");
        String[] arr = book.split("\n");
        double balance = Double.parseDouble(arr[0]);
        String result = "Original Balance: " + String.format("%.2f", balance) + "\\r\\n";
        double n = 0, total = 0;
        for (int i = 1; i < arr.length; i++) {
            if (arr[i].trim().isEmpty()) continue;

            String[] line = arr[i].split(" ");
            if (line.length < 3) continue;

            double price = Double.parseDouble(line[2]);
            total += price;
            balance -= price;
            result += arr[i] + " Balance " + String.format("%.2f", balance) + "\\r\\n";
            n++;
        }
        result += "Total expense  " + String.format("%.2f", total) + "\\r\\n"
                + "Average expense  " + String.format("%.2f", total / n);
        return result;
    }

    @Override
    public double f(double x) {
        return 0;
    }

    private static double[] extractRainfallValues(String town, String strng) {
        String[] records = strng.split("\n");

        for (String record : records) {
            if (record.startsWith(town + ":")) {
                String[] monthlyData = record.substring(record.indexOf(":") + 1).split(",");
                double[] values = new double[monthlyData.length];

                for (int i = 0; i < monthlyData.length; i++) {
                    String[] parts = monthlyData[i].trim().split(" ");
                    values[i] = Double.parseDouble(parts[1]);
                }

                return values;
            }
        }

        return null;
    }

    @Override
    public double mean(String town, String strng) {
        double[] rainfallValues = extractRainfallValues(town, strng);
        if (rainfallValues == null) {
            return -1.0;
        }

        double sum = 0.0;
        for (double value : rainfallValues) {
            sum += value;
        }

        return sum / rainfallValues.length;
    }

    @Override
    public double variance(String town, String strng) {
        double[] rainfallValues = extractRainfallValues(town, strng);
        if (rainfallValues == null) {
            return -1.0;
        }

        double mean = mean(town, strng);
        double sumOfSquares = 0.0;

        for (double value : rainfallValues) {
            sumOfSquares += Math.pow(value - mean, 2);
        }

        return sumOfSquares / rainfallValues.length;
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
