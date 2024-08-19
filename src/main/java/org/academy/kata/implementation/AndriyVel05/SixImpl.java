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
        return "";
    }
}
