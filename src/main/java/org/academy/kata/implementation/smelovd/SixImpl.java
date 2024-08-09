package org.academy.kata.implementation.smelovd;

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
        int wins = 0, draws = 0, losses = 0, totalScored = 0, totalConceded = 0;

        for (String match : resultSheet.split(",")) {
            String[] teams = match.split("(?<=\\d)\\s+");
            if (!isMatchMember(teams, toFind)) continue;

            try {
                int[] scores = extractScores(teams, toFind);
                int scored = scores[0], conceded = scores[1];

                if (scored > conceded) wins++;
                else if (scored == conceded) draws++;
                else losses++;

                totalScored += scored;
                totalConceded += conceded;
            } catch (Exception e) {
                return "Error(float number):" + match;
            }
        }

        if (wins + draws + losses == 0) return String.format("%s:This team didn't play!", toFind);
        return String.format("%s:W=%d;D=%d;L=%d;Scored=%d;Conceded=%d;Points=%d",
                toFind, wins, draws, losses, totalScored, totalConceded, (wins * 3) + draws);
    }

    private boolean isMatchMember(String[] teams, String team) {
        return teams[0].substring(0, teams[0].trim().lastIndexOf(" ")).trim().equals(team) ||
                teams[1].substring(0, teams[1].trim().lastIndexOf(" ")).trim().equals(team);
    }

    private int[] extractScores(String[] teams, String team) {
        final String team1 = teams[0].trim();
        final String team2 = teams[1].trim();

        if (isRequiredTeam(team, team1)) return new int[] {extractScore(team1), extractScore(team2)};
        return new int[] {extractScore(team2), extractScore(team1)};
    }

    private boolean isRequiredTeam(String team, String team1) {
        return team1.substring(0, team1.lastIndexOf(" ")).equals(team);
    }

    private int extractScore(String team) {
        return Integer.parseInt(team.substring(team.lastIndexOf(" ")).trim());
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        return "";
    }
}
