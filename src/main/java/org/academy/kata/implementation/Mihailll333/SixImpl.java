package org.academy.kata.implementation.Mihailll333;

import org.academy.kata.Base;
import org.academy.kata.Six;

import java.util.HashMap;
import java.util.Map;

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
        String cleanedBook = book.replaceAll("[^a-zA-Z0-9.\\s]", "").trim();

        String[] lines = cleanedBook.split("\\n");

        double originalBalance = Double.parseDouble(lines[0]);
        double currentBalance = originalBalance;

        StringBuilder report = new StringBuilder();
        report.append(String.format("Original Balance: %.2f\n", originalBalance));

        double totalExpense = 0.0;
        int transactionCount = 0;

        // Step 4: Process each transaction
        for (int i = 1; i < lines.length; i++) {
            if (!lines[i].trim().isEmpty()) {
                String[] parts = lines[i].split("\\s+");
                int checkNumber = Integer.parseInt(parts[0]);
                String category = parts[1];
                double amount = Double.parseDouble(parts[2]);

                currentBalance -= amount;
                totalExpense += amount;
                transactionCount++;

                report.append(String.format("%d %s %.2f Balance %.2f\n", checkNumber, category, amount, currentBalance));
            }
        }
        double averageExpense = totalExpense / transactionCount;

        report.append(String.format("Total expense  %.2f\n", totalExpense));
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

        for (String record : records) {
            if (record.startsWith(town + ":")) {
                String data = record.split(":")[1];
                String[] monthlyRainfall = data.split(",");
                double sum = 0.0;

                for (String rainfall : monthlyRainfall) {
                    sum += Double.parseDouble(rainfall.split(" ")[1]);
                }
                return sum / 12.0;  // Return the mean
            }
        }
        return -1;
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
        if (toFind.isEmpty()) {
            return "";
        }

        String[] matches = resultSheet.split(",");
        int wins = 0, draws = 0, losses = 0, scored = 0, conceded = 0;

        boolean teamPlayed = false;

        for (String match : matches) {
            if (match.contains(toFind)) {
                teamPlayed = true;

                String[] parts = match.replaceAll("[0-9]+\\.[0-9]+", "Error(float number)").split(" ");

                if (parts.length < 2) {
                    return "Error(float number):" + match;
                }

                int team1Score = 0;
                int team2Score = 0;
                StringBuilder team1Name = new StringBuilder();
                StringBuilder team2Name = new StringBuilder();

                int i = 0;
                while (!Character.isDigit(parts[i].charAt(0))) {
                    team1Name.append(parts[i++]).append(" ");
                }
                team1Name = new StringBuilder(team1Name.toString().trim());
                team1Score = Integer.parseInt(parts[i++]);

                while (i < parts.length && !Character.isDigit(parts[i].charAt(0))) {
                    team2Name.append(parts[i++]).append(" ");
                }
                team2Name = new StringBuilder(team2Name.toString().trim());
                team2Score = Integer.parseInt(parts[i]);

                if (team1Name.toString().equals(toFind)) {
                    scored += team1Score;
                    conceded += team2Score;
                    if (team1Score > team2Score) wins++;
                    else if (team1Score == team2Score) draws++;
                    else losses++;
                } else if (team2Name.toString().equals(toFind)) {
                    scored += team2Score;
                    conceded += team1Score;
                    if (team2Score > team1Score) wins++;
                    else if (team2Score == team1Score) draws++;
                    else losses++;
                }
            }
        }

        if (!teamPlayed) {
            return toFind + ":This team didn't play!";
        }

        int points = wins * 3 + draws;
        return toFind + ":W=" + wins + ";D=" + draws + ";L=" + losses + ";Scored=" + scored +
                ";Conceded=" + conceded + ";Points=" + points;
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0) {
            return "";
        }

        Map<String, Integer> categoryQuantities = new HashMap<>();

        for (String category : lstOf1stLetter) {
            categoryQuantities.put(category, 0);
        }

        for (String entry : lstOfArt) {
            String[] parts = entry.split(" ");
            String code = parts[0];
            int quantity = Integer.parseInt(parts[1]);

            String category = code.substring(0, 1);

            if (categoryQuantities.containsKey(category)) {
                categoryQuantities.put(category, categoryQuantities.get(category) + quantity);
            }
        }

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < lstOf1stLetter.length; i++) {
            String category = lstOf1stLetter[i];
            int quantity = categoryQuantities.getOrDefault(category, 0);
            result.append("(").append(category).append(" : ").append(quantity).append(")");

            if (i < lstOf1stLetter.length - 1) {
                result.append(" - ");
            }
        }

        return result.toString();
    }
}
