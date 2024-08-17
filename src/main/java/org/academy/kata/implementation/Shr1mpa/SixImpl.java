package org.academy.kata.implementation.Shr1mpa;

import org.academy.kata.Base;
import org.academy.kata.Six;

import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class SixImpl extends Base implements Six {
    @Override
    public long findNb(long m) {
        long sum = 0;
        int n = 0;

        while (sum < m) {
            n++;
            sum += (long) Math.pow(n, 3);
        }

        return (sum == m) ? n : -1;
    }

    @Override
    public String balance(String book) {
        String regex = "[^a-zA-Z0-9 \\n\\r.]";
        String withoutSpecialChars = book.replaceAll(regex, "");
        String[] lines = withoutSpecialChars.split("\\r?\\n");
        StringBuilder sb = new StringBuilder();

        double balance = Double.parseDouble(lines[0].trim());
        sb.append(String.format("Original Balance: %.2f\\r\\n", balance));

        double totalExpense = 0.0;
        int transactionCount = 0;

        for (int i = 1; i < lines.length; i++) {
            String line = lines[i].trim();
            String[] parts = line.split("\\s+");

            String checkNumber = parts[0];
            String category = parts[1];
            double expense = Double.parseDouble(parts[2]);

            balance -= expense;
            totalExpense += expense;
            transactionCount++;

            sb.append(String.format("%s %s %.2f Balance %.2f\\r\\n", checkNumber, category, expense, balance));
        }

        sb.append(String.format("Total expense  %.2f\\r\\n", totalExpense));
        sb.append(String.format("Average expense  %.2f", totalExpense / transactionCount));
        return sb.toString();
    }

    @Override
    public double f(double x) {
        return x / (Math.sqrt(1 + x) + 1);
    }

    @Override
    public double mean(String town, String strng) {
        String line = findLine(town, strng);
        if (line.isEmpty()) {
            return -1;
        }
        List<Double> numbers = findDegrees(line);
        double sum = numbers.stream()
                .mapToDouble(Double::doubleValue)
                .sum();
        return sum / numbers.size();
    }

    @Override
    public double variance(String town, String strng) {
        String line = findLine(town, strng);
        if (line.isEmpty()) {
            return -1;
        }
        List<Double> numbers = findDegrees(line);
        double mean = mean(town, strng);

        double sumOfSquares = 0;
        for (Double number : numbers) {
            sumOfSquares += Math.pow(number - mean, 2);
        }

        return sumOfSquares / numbers.size();
    }

    @Override
    public String nbaCup(String resultSheet, String toFind) {
        if (toFind.isEmpty()) {
            return "";
        }

        List<String[]> matches = new ArrayList<>();
        try {
            matches = Arrays.stream(resultSheet.split(","))
                    .map(line -> processMatchLine(line, toFind))
                    .filter(Objects::nonNull)
                    .collect(Collectors.toList());
        } catch (IllegalArgumentException e) {
            return "Error(float number):" + e.getMessage();
        }

        if (matches.isEmpty()) {
            return String.format("%s:This team didn't play!", toFind);
        }

        long wins = matches.stream()
                .filter(match -> Integer.parseInt(match[2]) > Integer.parseInt(match[3]))
                .count();

        long draws = matches.stream()
                .filter(match -> Integer.parseInt(match[2]) == Integer.parseInt(match[3]))
                .count();

        long losses = matches.stream()
                .filter(match -> Integer.parseInt(match[2]) < Integer.parseInt(match[3])
                ).count();

        long totalPoints = matches.stream()
                .mapToInt(match -> Integer.parseInt(match[2]))
                .sum();

        long concededPoints = matches.stream()
                .mapToInt(match -> Integer.parseInt(match[3]))
                .sum();

        int points = (int) ((wins * 3) + draws);

        return String.format("%s:W=%d;D=%d;L=%d;Scored=%d;Conceded=%d;Points=%d",
                toFind, wins, draws, losses, totalPoints, concededPoints, points);
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0) {
            return "";
        }
        Map<Character, Integer> map = Arrays.stream(lstOf1stLetter)
                .map(letter -> letter.charAt(0))
                .collect(Collectors.toMap(letter -> letter, letter -> 0));
        for (String s : lstOfArt) {
            String[] parts = s.split(" ");
            char key = parts[0].charAt(0);
            int valueToAdd = Integer.parseInt(parts[1]);

            if (map.containsKey(key)) {
                map.put(key, map.get(key) + valueToAdd);
            }
        }

        return map.entrySet().stream()
                .map(entry -> String.format("(%c : %d)", entry.getKey(), entry.getValue()))
                .collect(Collectors.joining(" - "));
    }

    private List<Integer> findNumberIndices(String[] parts) {
        List<Integer> numberIndices = new ArrayList<>();
        for (int i = 0; i < parts.length; i++) {
            if (parts[i].matches("\\d+")) {
                numberIndices.add(i);
            }
        }
        return numberIndices;
    }

    private String[] processMatchLine(String line, String toFind) {
        if (line.contains(".")) {
            throw new IllegalArgumentException(line);
        }

        String[] parts = line.trim().split("\\s+");
        List<Integer> numberIndices = findNumberIndices(parts);

        if (numberIndices.size() < 2) {
            return null;
        }

        int score1Index = numberIndices.get(0);
        int score2Index = numberIndices.get(1);

        String firstTeam = String.join(" ", Arrays.copyOfRange(parts, 0, score1Index)).trim();
        String secondTeam = String.join(" ", Arrays.copyOfRange(parts, score1Index + 1, score2Index)).trim();

        int score1 = Integer.parseInt(parts[score1Index]);
        int score2 = Integer.parseInt(parts[score2Index]);

        if (firstTeam.equals(toFind)) {
            return new String[]{firstTeam, secondTeam, String.valueOf(score1), String.valueOf(score2)};
        } else if (secondTeam.equals(toFind)) {
            return new String[]{secondTeam, firstTeam, String.valueOf(score2), String.valueOf(score1)};
        }
        return null;
    }

    private String findLine(String town, String strng) {
        String[] lines = strng.split("\\n");
        for (String line : lines) {
            if (line.startsWith(town + ":")) {
                return line.substring(town.length() + 1);
            }
        }
        return "";
    }

    private List<Double> findDegrees(String strng) {
        String regex = "\\d+\\.\\d+";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(strng);

        List<Double> numbers = new ArrayList<>();

        while (matcher.find()) {
            String numberStr = matcher.group();
            double number = Double.parseDouble(numberStr);
            numbers.add(number);
        }
        return numbers;
    }
}
