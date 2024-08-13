package org.academy.kata.implementation.VladyslavaNezhnova;

import org.academy.kata.Six;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
        return "";
    }
}
