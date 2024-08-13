package org.academy.kata.implementation.Shr1mpa;

import org.academy.kata.Six;

import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class SixImpl implements Six {
    @Override
    public long findNb(long m) {
        long sum = 0;
        int n = 0;

        while (sum < m) {
            n++;
            sum += (long) Math.pow(n, 3);
        }

        return (sum == m) ? n : -1;
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
        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0) {
            return "";
        }
        Map<Character, Integer> map = Arrays.stream(lstOf1stLetter)
                .map(letter -> letter.charAt(0))
                .collect(Collectors.toMap(letter -> letter, letter -> 0));
        for (String s : lstOfArt) {
            String[] parts = s.split(" ");
            char key = parts[0].charAt(0);
            int valueToAdd = Integer.parseInt(parts[1]);

            if (map.containsKey(key)) {
                map.put(key, map.get(key) + valueToAdd);
            }
        }

        return map.entrySet().stream()
                .map(entry -> String.format("(%c : %d)", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(" - "));
    }
}
