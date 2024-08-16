package org.academy.kata.implementation.ol271176;

import org.academy.kata.Six;

import java.util.LinkedHashMap;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class SixImpl implements Six {
    @Override
    public long findNb(long m) {
        int n = 1;
        long totalVolume = 0;

        while (m > totalVolume) {
            totalVolume += Math.pow(n++, 3);
        }
        n--;

        return totalVolume == m ? n : -1;
    }

    @Override
    public String balance(String book) {
        // Delete empty lines
        String[] lines = book.split("\n");
        StringBuilder result = new StringBuilder();

        // Find balance
        double balance = Double.parseDouble(lines[0].replaceAll("[^0-9.]", ""));
        result.append(String.format("Original Balance: %.2f\\r\\n", balance));
        double totalExpense = 0, avgExpense = 0, count = 0;

        // Process each line
        for (int i = 1; i < lines.length; i++) {
            String proccessedLine = lines[i].replaceAll("[^a-zA-Z0-9. ]", "");

            if (proccessedLine.isEmpty()) continue;

            String[] info = proccessedLine.split(" ");
            int checkNumber = Integer.parseInt(info[0]);
            String category = info[1];
            double checkAmount = Double.parseDouble(info[2]);
            double totalAmount = balance - checkAmount;
            balance -= checkAmount;

            totalExpense += checkAmount;
            count++;

            result.append(String.format("%d %s %.2f Balance %.2f\\r\\n", checkNumber, category, checkAmount, balance));
        }
        result.append(String.format("Total expense  %.2f\\r\\n", totalExpense));
        result.append(String.format("Average expense  %.2f", totalExpense / count));

        return result.toString();
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

        if (townLine == null) return -1.0;

        String[] townRecordsLine = townLine.replaceAll("[^0-9. ]", "").trim().split(" ");
        double[] townRecords = new double[townRecordsLine.length];
        for (int i = 0; i < townRecordsLine.length; i++) {
            townRecords[i] = Double.parseDouble(townRecordsLine[i]);
        }

        double mean = mean(town, strng);
        double sumOfSquares = 0;
        for (double e : townRecords) {
            sumOfSquares += (e - mean) * (e - mean);
        }

        return sumOfSquares / townRecords.length;
    }

    @Override
    public String nbaCup(String resultSheet, String toFind) {
        if (toFind.isEmpty()) return "";

        String[] lines = resultSheet.split(",");

        int wins = 0, draws = 0, losses = 0, scored = 0, conceded = 0, points = 0;
        boolean teamFound = false;

        Pattern errorPattern = Pattern.compile("\\d+\\.\\d+");
        Pattern correctPattern = Pattern.compile("^([\\w\\s]+) (\\d+) ([\\w\\s]+) (\\d+)$");

        for (String line : lines) {
            Matcher errorMatcher = errorPattern.matcher(line);

            if (errorMatcher.find()) return "Error(float number):the concerned string";
            if (!line.contains(toFind)) continue;

            Matcher correctMatcher = correctPattern.matcher(line);
            if (correctMatcher.find()) {
                String team1 = correctMatcher.group(1).trim();
                String team2 = correctMatcher.group(3).trim();
                int score1 = Integer.parseInt(correctMatcher.group(2).trim());
                int score2 = Integer.parseInt(correctMatcher.group(4).trim());

                if (team1.equals(toFind)) {
                    teamFound = true;
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
                    teamFound = true;
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

            }
        }

        if (!teamFound) return toFind + ":This team didn't play!";
        return String.format("%s:W=%d;D=%d;L=%d;Scored=%d;Conceded=%d;Points=%d",
                toFind, wins, draws, losses, scored, conceded, points);
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        Map<Character, Integer> mapOfBooks = new LinkedHashMap<>();
        for (String letter : lstOf1stLetter) mapOfBooks.put(letter.charAt(0), 0);

        Pattern pattern = Pattern.compile("(\\D+)\\s(\\d+)");
        for (String bookInfo : lstOfArt) {
            Matcher matcher = pattern.matcher(bookInfo);
            if (matcher.find()) {
                char key = matcher.group(1).charAt(0);
                int value = Integer.parseInt(matcher.group(2));
                if (mapOfBooks.containsKey(key)) {
                    mapOfBooks.put(key, mapOfBooks.get(key) + value);
                } else {
                    continue;
                }
            }
        }
        StringBuffer sb = new StringBuffer();
        for (Map.Entry<Character, Integer> entry : mapOfBooks.entrySet()) {
            if (sb.length() > 0) sb.append(" - ");
            sb.append(String.format("(%c : %d)", entry.getKey(), entry.getValue()));

        }

        return sb.toString();
    }
}
