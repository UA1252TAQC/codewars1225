package org.academy.kata.implementation.marchenko2005;

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
        return "";
    }
}
