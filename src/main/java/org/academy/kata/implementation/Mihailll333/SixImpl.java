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
        if (toFind.isEmpty()) return "";
        int wins = 0, draws = 0, losses = 0, totalScored = 0, totalConceded = 0;

        for (String match : resultSheet.split(",")) {
            String[] teams = match.split("(?<=\\d)\\s+");
            if (!isMatchMember(teams, toFind)) continue;

            try {
                int[] scores = extractScores(teams, toFind);
                int scored = scores[0], conceded = scores[1];

                if (scored > conceded) wins++;
                else if (scored == conceded) draws++;
                else losses++;

                totalScored += scored;
                totalConceded += conceded;
            } catch (Exception e) {
                return "Error(float number):" + match;
            }
        }

        if (wins + draws + losses == 0) return String.format("%s:This team didn't play!", toFind);
        return String.format("%s:W=%d;D=%d;L=%d;Scored=%d;Conceded=%d;Points=%d",
                toFind, wins, draws, losses, totalScored, totalConceded, (wins * 3) + draws);
    }

    private static boolean isMatchMember(String[] teams, String team) {
        return teams[0].substring(0, teams[0].trim().lastIndexOf(" ")).trim().equals(team) ||
                teams[1].substring(0, teams[1].trim().lastIndexOf(" ")).trim().equals(team);
    }

    private static int[] extractScores(String[] teams, String team) {
        final String team1 = teams[0].trim();
        final String team2 = teams[1].trim();

        if (isRequiredTeam(team, team1)) return new int[]{extractScore(team1), extractScore(team2)};
        return new int[]{extractScore(team2), extractScore(team1)};
    }

    private static boolean isRequiredTeam(String team, String team1) {
        return team1.substring(0, team1.lastIndexOf(" ")).equals(team);
    }

    private static int extractScore(String team) {
        return Integer.parseInt(team.substring(team.lastIndexOf(" ")).trim());
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
