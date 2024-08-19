package org.academy.kata.implementation.sbekberov;

import org.academy.kata.Base;
import org.academy.kata.Six;

import java.util.HashMap;
import java.util.Map;
import java.util.StringJoiner;

public class SixImpl extends Base implements Six {
    @Override
    public long findNb(long m) {
        long n = 0;
        long sum = 0;

        while (sum < m) {
            n++;
            sum += (n * n * n);
        }
        return (sum == m) ? n : -1;
    }

    @Override
    public  String balance(String book) {
        String cleanedBook = book.replaceAll("[^a-zA-Z0-9.\\s]", "");
        String[] lines = cleanedBook.split("\\n");
        double originalBalance = Double.parseDouble(lines[0].trim());
        double balance = originalBalance;

        StringBuilder report = new StringBuilder();
        report.append(String.format("Original Balance: %.2f\\r\\n", originalBalance));

        double totalExpense = 0;
        int count = 0;

        for (int i = 1; i < lines.length; i++) {
            String line = lines[i].trim();
            if (line.isEmpty()) continue;

            String[] parts = line.split("\\s+");
            double amount = Double.parseDouble(parts[2].trim());
            balance -= amount;
            report.append(String.format("%s %s %s Balance %.2f\\r\\n", parts[0], parts[1], parts[2], balance));

            totalExpense += amount;
            count++;
        }

        double averageExpense = totalExpense / count;
        report.append(String.format("Total expense  %.2f\\r\\n", totalExpense));
        report.append(String.format("Average expense  %.2f", averageExpense));

        return report.toString();
    }

    @Override
    public double f(double x) {
        return x / (Math.sqrt(1 + x) + 1);
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
        if (lstOfArt == null || lstOfArt.length == 0 || lstOf1stLetter == null || lstOf1stLetter.length == 0) {
            return "";
        }

        Map<Character, Integer> categorySums = new HashMap<>();

        for (String category : lstOf1stLetter) {
            if (!category.isEmpty()) {
                categorySums.put(category.charAt(0), 0);
            }
        }

        for (String art : lstOfArt) {
            if (art.isEmpty()) continue;

            String[] parts = art.split(" ");
            if (parts.length < 2) continue;

            String code = parts[0];
            int quantity;

            try {
                quantity = Integer.parseInt(parts[1]);
            } catch (NumberFormatException e) {
                continue;
            }

            if (code.isEmpty()) continue;

            char category = code.charAt(0);
            if (categorySums.containsKey(category)) {
                categorySums.put(category, categorySums.get(category) + quantity);
            }
        }

        StringJoiner sj = new StringJoiner(" - ");
        for (String category : lstOf1stLetter) {
            if (!category.isEmpty()) {
                char cat = category.charAt(0);
                int sum = categorySums.getOrDefault(cat, 0);
                sj.add("(" + cat + " : " + sum + ")");
            }
        }

        return sj.toString();
    }
}
