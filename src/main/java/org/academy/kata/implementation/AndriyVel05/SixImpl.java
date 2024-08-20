package org.academy.kata.implementation.AndriyVel05;
import org.academy.kata.Base;
import org.academy.kata.Six;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        String normalizedBook = book.replace("\r\n", "\r").replace("\n", "\r");
        String[] lines = normalizedBook.split("\r");

        double originBalance = Double.parseDouble(lines[0]);
        double balance = originBalance;
        double totalExpense = 0.0;
        int expenseCount = 0;
        StringBuilder report = new StringBuilder();

        report.append(String.format("Original Balance: %.2f\\r\\n", originBalance));

        for (int i = 1; i < lines.length; i++) {
            if (lines[i].trim().isEmpty()) continue;

            String cleanLine = lines[i].replaceAll("[^a-zA-Z0-9. ]", "").trim();
            String[] parts = cleanLine.split("\\s+");
            double expense = Double.parseDouble(parts[parts.length - 1]);
            balance -= expense;
            totalExpense += expense;
            expenseCount++;

            report.append(String.format("%s %s %.2f Balance %.2f\\r\\n",
                    parts[0], parts[1], expense, balance));
        }

        report.append(String.format("Total expense  %.2f\\r\\n", totalExpense));
        report.append(String.format("Average expense  %.2f", totalExpense / expenseCount));

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
            String[] parts = record.split(":");
            if (parts[0].equals(town)) {

                String[] rainfallData = parts[1].split(",");
                double sum = 0;
                int count = 0;

                for (String data : rainfallData) {
                    String[] monthValue = data.split(" ");
                    double value = Double.parseDouble(monthValue[1]);
                    sum += value;
                    count++;
                }

                return sum / count;
            }
        }
        return -1.0;
    }

    @Override
    public double variance(String town, String strng) {
        double meanValue = mean(town, strng);
        if (meanValue == -1.0) {
            return -1.0;
        }

        String[] records = strng.split("\n");

        for (String record : records) {
            String[] parts = record.split(":");
            if (parts[0].equals(town)) {
                String[] rainfallData = parts[1].split(",");
                double sumSquaredDifferences = 0;
                int count = 0;

                for (String data : rainfallData) {
                    String[] monthValue = data.split(" ");
                    double value = Double.parseDouble(monthValue[1]);
                    sumSquaredDifferences += Math.pow(value - meanValue, 2);
                    count++;
                }

                return sumSquaredDifferences / count;
            }
        }

        return -1.0;
    }


    @Override
    public String nbaCup(String resultSheet, String toFind) {
        if (toFind.isEmpty()) return "";

        String[] games = resultSheet.split(",");
        int wins = 0, draws = 0, losses = 0, scored = 0, conceded = 0;

        for (String game : games) {
            if (game.contains(toFind)) {
                try {

                    String regex = "(.*)\\s(\\d+)\\s(.*)\\s(\\d+)";
                    Pattern pattern = Pattern.compile(regex);
                    Matcher matcher = pattern.matcher(game);

                    if (!matcher.matches()) {

                        if (game.matches(".*\\d+\\.\\d+.*")) {
                            return "Error(float number):" + game.trim();
                        }
                        return "Error in score format: " + game.trim();
                    }

                    String team1 = matcher.group(1).trim();
                    int team1Score = Integer.parseInt(matcher.group(2));
                    String team2 = matcher.group(3).trim();
                    int team2Score = Integer.parseInt(matcher.group(4));


                    System.out.println("Processing game: " + game);
                    System.out.println("Team 1: " + team1 + " Score: " + team1Score);
                    System.out.println("Team 2: " + team2 + " Score: " + team2Score);

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
                    return "Error in score format: " + game.trim();
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
            if (!result.isEmpty()) {
                result.append(" - ");
            }
            result.append("(").append(category).append(" : ").append(categoryMap.get(category)).append(")");
        }

        return result.toString();
    }

}

