package org.academy.kata.implementation.AndriyVel05;

import org.academy.kata.Six;

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
        if (toFind.isEmpty()) return "";
        String[] games = resultSheet.split(",");
        int wins = 0, draws = 0, losses = 0, scored = 0, conceded = 0;

        for (String game : games) {
            if (!game.contains(toFind)) continue;
            String[] parts = game.split("\\d+(?:\\.\\d+)?");
            if (parts.length != 2) return "Error(float number):" + game.trim();

            int[] scores = extractScores(game);
            if (scores == null) return "Error(float number):" + game.trim();

            boolean isFirstTeam = game.indexOf(toFind) < game.indexOf(scores[0] + "");
            int teamScore = isFirstTeam ? scores[0] : scores[1];
            int oppScore = isFirstTeam ? scores[1] : scores[0];

            scored += teamScore;
            conceded += oppScore;
            if (teamScore > oppScore) wins++;
            else if (teamScore < oppScore) losses++;
            else draws++;
        }

        if (wins == 0 && draws == 0 && losses == 0)
            return toFind + ":This team didn't play!";

        return String.format("%s:W=%d;D=%d;L=%d;Scored=%d;Conceded=%d;Points=%d",
                toFind, wins, draws, losses, scored, conceded, wins * 3 + draws);

    }

    private int[] extractScores(String game) {
        String[] parts = game.replaceAll("[^\\d ]", "").trim().split(" +");
        try {
            int score1 = Integer.parseInt(parts[0]);
            int score2 = Integer.parseInt(parts[1]);
            return new int[]{score1, score2};
        } catch (NumberFormatException e) {
            return null;

        }

            @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        return "";
    }
}
