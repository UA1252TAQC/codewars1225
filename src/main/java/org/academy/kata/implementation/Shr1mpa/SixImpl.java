package org.academy.kata.implementation.Shr1mpa;

import org.academy.kata.Six;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class SixImpl implements Six {
    @Override
    public long findNb(long m) {
        return 0;
    }

    @Override
    public String balance(String book) {
        return "";
    }

    @Override
    public double f(double x) {
        return 0;
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
        return "";
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
}
