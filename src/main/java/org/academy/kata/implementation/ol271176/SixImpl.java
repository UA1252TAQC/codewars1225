package org.academy.kata.implementation.ol271176;

import java.util.regex.Matcher;
import java.util.regex.Pattern;
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

        String[] lines = resultSheet.split(",");

        int wins=0, draws=0, losses=0, scored=0, conceded=0, points=0;
        boolean teamFound = false;

        Pattern errorPattern = Pattern.compile("\\d+\\.\\d+");
        Pattern correctPattern = Pattern.compile("^([\\w\\s]+) (\\d+) ([\\w\\s]+) (\\d+)$");

        for(String line : lines){
            Matcher errorMatcher = errorPattern.matcher(line);

            if(errorMatcher.find()) return "Error(float number):the concerned string";
            if(!line.contains(toFind)) continue;

            Matcher correctMatcher = correctPattern.matcher(line);
            if(correctMatcher.find()){
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

        if(!teamFound) return toFind +":This team didn't play!";
        return String.format("%s:W=%d;D=%d;L=%d;Scored=%d;Conceded=%d;Points=%d",
                toFind, wins, draws, losses, scored, conceded, points);
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        return "";
    }
}
