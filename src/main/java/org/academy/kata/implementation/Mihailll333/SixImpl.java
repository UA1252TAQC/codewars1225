package org.academy.kata.implementation.Mihailll333;

import org.academy.kata.Base;
import org.academy.kata.Six;

import java.util.*;

public class SixImpl extends Base implements Six {
    @Override
    public long findNb(long m) {
        long n = 0;
        long sum = 0;

        while (sum < m) {
            n++;
            sum += n * n * n;
        }

        if (sum == m) {
            return n;
        } else {
            return -1;
        }
    }

    @Override
    public String balance(String book) {
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
        double[] rainfallValues = extractRainfallValues(town, strng);
        if (rainfallValues == null) {
            return -1.0;
        }
        double sum = 0;
        for (double value : rainfallValues) {
            sum += value;
        }
        return sum / rainfallValues.length;
    }

    private static double[] extractRainfallValues(String town, String strng) {
        int startIndex = strng.indexOf(town + ":");
        if (startIndex == -1) {
            return null;
        }

        startIndex += town.length() + 1;

        int endIndex = strng.indexOf('\n', startIndex);
        if (endIndex == -1) {
            endIndex = strng.length();
        }

        String data = strng.substring(startIndex, endIndex).trim();
        if (data.isEmpty()) {
            return null;
        }

        String[] values = data.split("\\s*,\\s*");
        double[] rainfallValues = new double[values.length];
        try {
            for (int i = 0; i < values.length; i++) {
                rainfallValues[i] = Double.parseDouble(values[i]);
            }
        } catch (NumberFormatException e) {
            return null;
        }

        return rainfallValues;
    }
    @Override
    public double variance(String town, String strng) {
        double[] rainfallValues = extractRainfallValues(town, strng);
        if (rainfallValues == null) {
            return -1.0;
        }
        double mean = mean(town, strng);
        double sumSquaredDiffs = 0;
        for (double value : rainfallValues) {
            double diff = value - mean;
            sumSquaredDiffs += diff * diff;
        }
        return sumSquaredDiffs / rainfallValues.length;
    }

    @Override
    public String nbaCup(String resultSheet, String toFind) {
        if (toFind.isEmpty()) {
            return "";
        }

        String[] matches = resultSheet.split(",");
        int wins = 0, draws = 0, losses = 0;
        int scored = 0, conceded = 0;
        boolean teamFound = false;

        for (String match : matches) {
            String[] parts = match.trim().split("\\s+");
            if (parts.length < 4) {
                continue;
            }

            int score1Index = parts.length - 2;
            int score2Index = parts.length - 1;

            try {
                int score1 = Integer.parseInt(parts[score1Index]);
                int score2 = Integer.parseInt(parts[score2Index]);

                String team1 = String.join(" ", Arrays.copyOfRange(parts, 0, score1Index));
                String team2 = String.join(" ", Arrays.copyOfRange(parts, score1Index + 1, score2Index));

                if (team1.equals(toFind) || team2.equals(toFind)) {
                    teamFound = true;

                    if (team1.equals(toFind)) {
                        scored += score1;
                        conceded += score2;
                        if (score1 > score2) wins++;
                        else if (score1 == score2) draws++;
                        else losses++;
                    } else if (team2.equals(toFind)) {
                        scored += score2;
                        conceded += score1;
                        if (score2 > score1) wins++;
                        else if (score2 == score1) draws++;
                        else losses++;
                    }
                }

            } catch (NumberFormatException e) {
                return "Error(float number):" + match.trim();
            }
        }

        if (!teamFound) {
            return toFind + ":This team didn't play!";
        }

        int points = wins * 3 + draws;

        return String.format("%s:W=%d;D=%d;L=%d;Scored=%d;Conceded=%d;Points=%d",
                toFind, wins, draws, losses, scored, conceded, points);
    }


    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        if (lstOfArt == null || lstOfArt.length == 0 || lstOf1stLetter == null || lstOf1stLetter.length == 0) {
            return "";
        }

        Map<Character, Integer> categorySums = new HashMap<>();
        for (String category : lstOf1stLetter) {
            categorySums.put(category.charAt(0), 0);
        }

        for (String art : lstOfArt) {
            String[] parts = art.split(" ");
            if (parts.length != 2) continue;

            String code = parts[0];
            int quantity = Integer.parseInt(parts[1]);

            if (code.length() > 0) {
                char category = code.charAt(0);
                if (categorySums.containsKey(category)) {
                    categorySums.put(category, categorySums.get(category) + quantity);
                }
            }
        }

        StringBuilder result = new StringBuilder();
        for (String category : lstOf1stLetter) {
            char cat = category.charAt(0);
            int sum = categorySums.getOrDefault(cat, 0);
            result.append("(").append(cat).append(" : ").append(sum).append(") - ");
        }

        if (result.length() > 0) {
            result.setLength(result.length() - 3);
        }

        return result.toString();
    }
}
