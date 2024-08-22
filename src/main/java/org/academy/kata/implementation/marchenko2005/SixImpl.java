package org.academy.kata.implementation.marchenko2005;

import org.academy.kata.Base;
import org.academy.kata.Six;

import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SixImpl extends Base implements Six {
    @Override
    public long findNb(long m) {
        long n = 0;
        long totalVolume = 0;

        while (totalVolume < m) {
            n++;
            totalVolume += n * n * n;
        }

        return totalVolume == m ? n : -1;
    }

    @Override
    public String balance(String book) {
        var text = book.replaceAll("[^\\w\n. ]", "").split("\n");
        var result = new StringBuilder("Original Balance: " + text[0] + (book = "\\r\\n"));
        double balance = Double.parseDouble(text[0]), sum = 0;
        for (int i = 1; i < text.length; i++) {
            sum += Double.parseDouble(text[i].split("\\s+")[2]);
            result.append(text[i].trim().replaceAll("\\s+", " ")).append(String.format(" Balance %.2f", balance - sum)).append(book);
        }
        return result + String.format("Total expense  %.2f%sAverage expense  %.2f", sum, book, sum / (text.length - 1));
    }

    @Override
    public double f(double x) {
        return x / (Math.sqrt(1 + x) + 1);
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
        if (toFind.isEmpty()) return "";

        String[] matches = resultSheet.split(",");
        int wins = 0, draws = 0, losses = 0, scored = 0, conceded = 0;
        boolean teamFound = false;

        for (String match : matches) {
            if (containsFloat(match)) {
                return "Error(float number):" + match.trim();
            }

            String[] result = parseMatch(match);
            if (result != null) {
                String team1 = result[0];
                int score1 = Integer.parseInt(result[1]);
                String team2 = result[2];
                int score2 = Integer.parseInt(result[3]);

                if (team1.equals(toFind) || team2.equals(toFind)) {
                    teamFound = true;
                    if (team1.equals(toFind)) {
                        int[] stats = updateTeamStats(score1, score2);
                        wins += stats[0];
                        draws += stats[1];
                        losses += stats[2];
                        scored += score1;
                        conceded += score2;
                    } else {
                        int[] stats = updateTeamStats(score2, score1);
                        wins += stats[0];
                        draws += stats[1];
                        losses += stats[2];
                        scored += score2;
                        conceded += score1;
                    }
                }
            }
        }

        if (!teamFound) {
            return toFind + ":This team didn't play!";
        }

        int points = wins * 3 + draws;
        return String.format("%s:W=%d;D=%d;L=%d;Scored=%d;Conceded=%d;Points=%d",
                toFind, wins, draws, losses, scored, conceded, points);
    }

    private static boolean containsFloat(String match) {
        return match.matches(".*\\d+\\.\\d+.*");
    }

    private static String[] parseMatch(String match) {
        Pattern pattern = Pattern.compile("([A-Za-z0-9 ]+) (\\d+) ([A-Za-z0-9 ]+) (\\d+)");
        Matcher matcher = pattern.matcher(match.trim());

        if (matcher.find()) {
            return new String[]{
                    matcher.group(1).trim(),
                    matcher.group(2),
                    matcher.group(3).trim(),
                    matcher.group(4)
            };
        }
        return null;
    }

    private static int[] updateTeamStats(int scored, int conceded) {
        int[] stats = new int[3]; // {wins, draws, losses}

        if (scored > conceded) {
            stats[0] = 1;
        } else if (scored == conceded) {
            stats[1] = 1;
        } else {
            stats[2] = 1;
        }

        return stats;
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        if (lstOfArt == null || lstOfArt.length == 0 || lstOf1stLetter == null || lstOf1stLetter.length == 0) {
            return "";
        }

        Map<String, Integer> categorySums = new HashMap<>();

        for (String category : lstOf1stLetter) {
            categorySums.put(category, 0);
        }

        for (String item : lstOfArt) {
            String[] parts = item.split(" ");
            String category = parts[0].substring(0, 1);
            int quantity = Integer.parseInt(parts[1]);

            if (categorySums.containsKey(category)) {
                categorySums.put(category, categorySums.get(category) + quantity);
            }
        }

        StringBuilder result = new StringBuilder();
        for (String category : lstOf1stLetter) {
            if (result.length() > 0) {
                result.append(" - ");
            }
            result.append("(").append(category).append(" : ").append(categorySums.get(category)).append(")");
        }

        return result.toString();
    }
}
