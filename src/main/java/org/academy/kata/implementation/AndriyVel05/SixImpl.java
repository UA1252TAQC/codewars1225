package org.academy.kata.implementation.AndriyVel05;
import org.academy.kata.Base;
import org.academy.kata.Six;
import java.util.HashMap;
import java.util.Map;

public class SixImpl extends Base implements Six {
    @Override
    public long findNb(long m) {
        long n = 0, totalVolume = 0;

        while (totalVolume < m) {
            n++;
            totalVolume += n * n * n;
        }

        return totalVolume == m ? n : -1;
    }

    @Override
    public String balance(String book) {
        String[] lines = book.split("\n");
        double originBalance = Double.parseDouble(lines[0]);
        double balance = originBalance;
        double totalExpense = 0.0;
        StringBuilder report = new StringBuilder();

        report.append(String.format("Original Balance: %.2f\n", originBalance));

        for (int i = 1; i < lines.length; i++) {
            if (lines[i].trim().isEmpty()) continue;

            String cleanLine = lines[i].replaceAll("[^a-zA-Z0-9. ]", "");
            String[] parts = cleanLine.split(" ");
            double expense = Double.parseDouble(parts[parts.length - 1]);
            balance -= expense;
            totalExpense += expense;

            report.append(String.format("%s %s %.2f Balance %.2f\n",
                    parts[0], parts[1], expense, balance));
        }

        report.append(String.format("Total expense  %.2f\n", totalExpense));
        report.append(String.format("Average expense  %.2f", totalExpense / (lines.length - 1)));

        return report.toString();

    }

    @Override
    public double f(double x) {
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
        if (toFind.isEmpty()) return "";

        String[] games = resultSheet.split(",");
        int wins = 0, draws = 0, losses = 0, scored = 0, conceded = 0;

        for (String game : games) {
            if (game.contains(toFind)) {
                String[] parts = game.split(" ");
                int team1ScoreIndex = parts.length - 2;
                int team2ScoreIndex = parts.length - 1;

                try {
                    int team1Score = Integer.parseInt(parts[team1ScoreIndex]);
                    int team2Score = Integer.parseInt(parts[team2ScoreIndex]);

                    int team1NameEndIndex = game.indexOf(String.valueOf(team1Score));
                    int team2NameStartIndex = game.lastIndexOf(" ", game.lastIndexOf(String.valueOf(team2Score)) - 1) + 1;

                    String team1 = game.substring(0, team1NameEndIndex).trim();
                    String team2 = game.substring(team2NameStartIndex).trim();

                    if (toFind.equals(team1)) {
                        scored += team1Score;
                        conceded += team2Score;
                        if (team1Score > team2Score) {
                            wins++;
                        } else if (team1Score < team2Score) {
                            losses++;
                        } else {
                            draws++;
                        }
                    } else if (toFind.equals(team2)) {
                        scored += team2Score;
                        conceded += team1Score;
                        if (team2Score > team1Score) {
                            wins++;
                        } else if (team2Score < team1Score) {
                            losses++;
                        } else {
                            draws++;
                        }
                    }
                } catch (NumberFormatException e) {
                    return "Error(float number):" + game;
                }
            }
        }

        if (scored == 0 && conceded == 0) {
            return toFind + ":This team didn't play!";
        }

        int points = 3 * wins + draws;
        return String.format("%s:W=%d;D=%d;L=%d;Scored=%d;Conceded=%d;Points=%d", toFind, wins, draws, losses, scored, conceded, points);
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0) {
            return "";
        }

        Map<String, Integer> categoryMap = new HashMap<>();
        for (String category : lstOf1stLetter) {
            categoryMap.put(category, 0);
        }

        for (String art : lstOfArt) {
            String category = art.substring(0, 1);
            if (categoryMap.containsKey(category)) {
                int quantity = Integer.parseInt(art.split(" ")[1]);
                categoryMap.put(category, categoryMap.get(category) + quantity);
            }
        }

        StringBuilder result = new StringBuilder();
        for (String category : lstOf1stLetter) {
            if (result.length() > 0) {
                result.append(" - ");
            }
            result.append("(").append(category).append(" : ").append(categoryMap.get(category)).append(")");
        }

        return result.toString();
    }

}

