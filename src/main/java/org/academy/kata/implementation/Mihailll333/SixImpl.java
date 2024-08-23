package org.academy.kata.implementation.Mihailll333;

import org.academy.kata.Base;
import org.academy.kata.Six;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        String[] cities = strng.split("\n");
        String townLine = null;
        for (String cityLine : cities) {
            String[] parts = cityLine.split(":");
            String city = parts[0];
            if (city.equals(town)) {
                townLine = parts[1];
                break;
            }
        }

        if (townLine == null) {
            return -1.0;
        }

        String[] townRecordsLine = townLine.replaceAll("[^0-9. ]", "").trim().split(" ");
        double[] townRecords = new double[townRecordsLine.length];
        for (int i = 0; i < townRecordsLine.length; i++) {
            townRecords[i] = Double.parseDouble(townRecordsLine[i]);
        }

        double sum = 0;
        for (double e : townRecords) {
            sum += e;
        }

        return sum / townRecords.length;
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
        if (toFind.isEmpty()) return "";

        int wins = 0, draws = 0, losses = 0, totalScored = 0, totalConceded = 0;
        String[] matches = resultSheet.split(",");
        for (String match : matches) {
            match = match.trim();
            if (match.isEmpty()) continue;

            Pattern pattern = Pattern.compile("(.+) (\\d+) (.+) (\\d+)");
            Matcher matcher = pattern.matcher(match);

            if (!matcher.matches()) {
                return "Error(float number):" + match;
            }

            String team1 = matcher.group(1).trim();
            int score1 = Integer.parseInt(matcher.group(2));
            String team2 = matcher.group(3).trim();
            int score2 = Integer.parseInt(matcher.group(4));

            if (team1.equals(toFind) || team2.equals(toFind)) {
                if (team1.equals(toFind)) {
                    totalScored += score1;
                    totalConceded += score2;
                    if (score1 > score2) {
                        wins++;
                    } else if (score1 == score2) {
                        draws++;
                    } else {
                        losses++;
                    }
                } else {
                    totalScored += score2;
                    totalConceded += score1;
                    if (score2 > score1) {
                        wins++;
                    } else if (score2 == score1) {
                        draws++;
                    } else {
                        losses++;
                    }
                }
            }
        }

        if (wins + draws + losses == 0) {
            return toFind + ":This team didn't play!";
        }

        int points = (wins * 3) + draws;
        return String.format("%s:W=%d;D=%d;L=%d;Scored=%d;Conceded=%d;Points=%d",
                toFind, wins, draws, losses, totalScored, totalConceded, points);
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
