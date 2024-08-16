package org.academy.kata.implementation.oleksandrtkv;

import org.academy.kata.Six;

import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SixImpl implements Six {
    @Override
    public long findNb(long m) {
        long n = 1;
        long sum = 0;
        while (sum < m){
            sum += (long) Math.pow(n, 3);
            if (sum == m){
                break;
            }
            n++;
        }
        if(sum != m){
            n = -1;
        }
        return n;
    }

    @Override
    public String balance(String book) {
        DecimalFormat df = new DecimalFormat("0.00");
        StringBuilder builder = new StringBuilder();

        String replaced = book.replaceAll("[^a-zA-Z0-9. \n]", "");
        String[] split = replaced.split("\n");
        split = Arrays.stream(split).filter(line -> !line.trim().isEmpty()).toArray(String[]::new);
        for(int i = 0; i < split.length; i++){
            split[i] = split[i].replaceAll("\\s+", " ").trim();
        }

        builder.append("Original Balance: ").append(split[0]).append("\\r\\n");

        double originalBalance = Double.parseDouble(split[0]);
        for (int i = 1; i < split.length; i++) {
            builder.append(split[i]).append(" Balance ");
            String[] innerSplit = split[i].split(" ");
            originalBalance -= Double.parseDouble(innerSplit[2]);
            builder.append(df.format(Math.round(originalBalance * 100.0) / 100.0)).append("\\r\\n");
        }

        double totalExpense = 0;
        for (int i = 1; i < split.length; i++) {
            String[] innerSplit = split[i].split(" ");
            totalExpense += Double.parseDouble(innerSplit[2]);
        }
        builder.append("Total expense  ").append(df.format(Math.round(totalExpense * 100.0) / 100.0)).append("\\r\\n");

        double averageExpense = Math.round((totalExpense / (split.length - 1)) * 100.0) / 100.0;
        builder.append("Average expense  ").append(df.format(averageExpense));

        return builder.toString();
    }

    @Override
    public double f(double x) {
        return x / (Math.sqrt(1 + x) + 1);
    }

    @Override
    public double mean(String town, String strng) {
        double[] rainfallData = getRainfallData(town, strng);
        if (rainfallData == null) {
            return -1;
        }

        double sum = 0;
        for (double rainfall : rainfallData) {
            sum += rainfall;
        }

        return sum / rainfallData.length;
    }

    @Override
    public double variance(String town, String strng) {
        double[] rainfallData = getRainfallData(town, strng);
        if (rainfallData == null) {
            return -1;
        }

        double meanValue = mean(town, strng);

        double sum = 0;
        for (double rainfall : rainfallData) {
            sum += Math.pow(rainfall - meanValue, 2);
        }

        return sum / rainfallData.length;
    }

    private double[] getRainfallData(String town, String strng) {
        String[] townData = strng.split("\n");
        for (String data : townData) {
            if (data.startsWith(town + ":")) {
                String[] monthlyData = data.split(":")[1].split(",");
                double[] rainfall = new double[monthlyData.length];
                for (int i = 0; i < monthlyData.length; i++) {
                    rainfall[i] = Double.parseDouble(monthlyData[i].split(" ")[1]);
                }
                return rainfall;
            }
        }
        return null;
    }

    @Override
    public String nbaCup(String resultSheet, String toFind) {
        if (toFind == null || toFind.isEmpty()) {
            return "";
        }

        int wins = 0, draws = 0, losses = 0, scored = 0, conceded = 0, points = 0;

        String[] matches = resultSheet.split(",");
        Pattern pattern = Pattern.compile("(.+) (\\d+) (.+) (\\d+)");

        for (int i = 0; i < matches.length; i++) {
            String match = matches[i];
            if (!match.contains(toFind)) {
                continue;
            }
            Matcher matcher = pattern.matcher(match);
            if (matcher.matches()) {
                String team1 = matcher.group(1).trim();
                int score1 = Integer.parseInt(matcher.group(2));
                String team2 = matcher.group(3).trim();
                int score2 = Integer.parseInt(matcher.group(4));

                if (team1.equals(toFind)) {
                    scored += score1;
                    conceded += score2;

                    if (score1 > score2) {
                        wins = wins + 1;
                        points = points + 3;
                    } else if (score1 == score2) {
                        draws = draws + 1;
                        points = points + 1;
                    } else {
                        losses = losses + 1;
                    }
                } else if (team2.equals(toFind)) {
                    scored += score2;
                    conceded += score1;

                    if (score2 > score1) {
                        wins = wins + 1;
                        points = points + 3;
                    } else if (score2 == score1) {
                        draws = draws + 1;
                        points = points + 1;
                    } else {
                        losses = losses + 1;
                    }
                }
            } else {
                return "Error(float number):" + match;
            }
        }

        if (wins == 0 && draws == 0 && losses == 0) {
            return toFind + ":This team didn't play!";
        }

        return toFind + ":W=" + wins + ";D=" + draws + ";L=" + losses +
                ";Scored=" + scored + ";Conceded=" + conceded + ";Points=" + points;
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0) {
            return "";
        }

        Map<Character, Integer> categoryMap = new HashMap<>();

        for (String category : lstOf1stLetter) {
            categoryMap.put(category.charAt(0), 0);
        }

        for (String book : lstOfArt) {
            char category = book.charAt(0);
            int quantity = Integer.parseInt(book.split(" ")[1]);

            if (categoryMap.containsKey(category)) {
                categoryMap.put(category, categoryMap.get(category) + quantity);
            }
        }

        StringBuilder result = new StringBuilder();
        for (String category : lstOf1stLetter) {
            if (result.length() > 0) {
                result.append(" - ");
            }
            result.append("(")
                    .append(category)
                    .append(" : ")
                    .append(categoryMap.get(category.charAt(0)))
                    .append(")");
        }
        return result.toString();
    }
}
