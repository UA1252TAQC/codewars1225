package org.academy.kata.implementation.VladyslavaNezhnova;

import org.academy.kata.Six;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SixImpl implements Six {
    @Override
    public long findNb(long m) {
        long sum = 0;
        long n = 0;

        while (sum < m) {
            n++;
            sum += Math.pow(n, 3);
            if (sum == m) {
                return n;
            }
        }
        return -1;
    }

    @Override
    public String balance(String book) {
        book = book.replaceAll("[^a-zA-Z0-9.\\s]", "");

        String[] lines = book.split("\\n+");
        double originalBalance = Double.parseDouble(lines[0]);
        double currentBalance = originalBalance;
        double totalExpense = 0.0;

        StringBuilder report = new StringBuilder();
        report.append("Original Balance: ").append(String.format("%.2f", originalBalance)).append("\\r\\n");


        for (int i = 1; i < lines.length; i++) {
            String[] parts = lines[i].split("\\s+");
            double expense = Double.parseDouble(parts[2]);
            currentBalance -= expense;
            totalExpense += expense;

            report.append(parts[0]).append(" ").append(parts[1]).append(" ")
                    .append(String.format("%.2f", expense)).append(" Balance ")
                    .append(String.format("%.2f", currentBalance)).append("\\r\\n");
        }

        report.append("Total expense  ").append(String.format("%.2f", totalExpense)).append("\\r\\n");
        report.append("Average expense  ").append(String.format("%.2f", totalExpense / (lines.length - 1)));

        return report.toString();
    }

    @Override
    public double f(double x) {
        if (x == 0) {
            return 0;
        }
        return x / (Math.sqrt(1 + x) + 1);
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
        if (toFind.isEmpty()) {
            return "";
        }
        int wins = 0, draws = 0, losses = 0, scored = 0, conceded = 0, points = 0;
        String[] matches = resultSheet.split(",");

        for (String match : matches) {
            if (match.contains(toFind)) {
                String regex = "(.+) (\\d+) (.+) (\\d+)";
                Pattern pattern = Pattern.compile(regex);
                Matcher matcher = pattern.matcher(match);

                if (matcher.matches()) {
                    String team1 = matcher.group(1);
                    int score1 = Integer.parseInt(matcher.group(2));
                    String team2 = matcher.group(3);
                    int score2 = Integer.parseInt(matcher.group(4));

                    if (team1.equals(toFind)) {
                        scored += score1;
                        conceded += score2;
                        if (score1 > score2) {
                            wins++;
                            points += 3;
                        } else if (score1 == score2) {
                            draws++;
                            points += 1;
                        } else {
                            losses++;
                        }
                    } else if (team2.equals(toFind)) {
                        scored += score2;
                        conceded += score1;
                        if (score2 > score1) {
                            wins++;
                            points += 3;
                        } else if (score2 == score1) {
                            draws++;
                            points += 1;
                        } else {
                            losses++;
                        }
                    }
                } else {
                    return "Error(float number):" + match;
                }
            }
        }

        if (wins == 0 && draws == 0 && losses == 0) {
            return toFind + ":This team didn't play!";
        }
        return String.format("%s:W=%d;D=%d;L=%d;Scored=%d;Conceded=%d;Points=%d",
                toFind, wins, draws, losses, scored, conceded, points);
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        if (lstOfArt == null || lstOfArt.length == 0 || lstOf1stLetter == null || lstOf1stLetter.length == 0) {
            return "";
        }
        Map<String, Integer> categoryTotals = new HashMap<>();

        for (String book : lstOfArt) {
            String category = book.substring(0, 1);
            int count = Integer.parseInt(book.split(" ")[1]);
            categoryTotals.put(category, categoryTotals.getOrDefault(category, 0) + count);
        }
        StringBuilder res = new StringBuilder();
        for (String category : lstOf1stLetter) {
            int total = categoryTotals.getOrDefault(category, 0);
            if (res.length() > 0) {
                res.append(" - ");
            }
            res.append("(").append(category).append(" : ").append(total).append(")");
        }
        return res.toString();
    }
}
