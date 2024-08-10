package org.academy.kata.implementation.YanOleks;

import org.academy.kata.Six;

import java.util.ArrayList;

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

    private static String[] getResults(String team, String sheet){
        String[] data = sheet.split(",");
        ArrayList<String> matches = new ArrayList<>();
        for (String match: data){
            if (match.contains(team)) matches.add(match.trim());
        }
        return matches.toArray(new String[0]);
    }
    private static Integer tryParse(String text) {
        try {
            return Integer.parseInt(text);
        } catch (NumberFormatException e) {
            return -1;
        }
    }
    @Override
    public String nbaCup(String resultSheet, String toFind) {
        if (toFind.isEmpty()) return "";
        String[] result = getResults(toFind + " ", resultSheet);
        if (result.length == 0) return String.format("%s:This team didn't play!", toFind);
        int[] teamScores = new int[result.length];
        int[] oppositeScores = new int[result.length];
        int numberOfWins = 0;
        int numberOfLoses = 0;
        int numberOfDraws = 0;
        int scored = 0;
        int conceded = 0;
        for (int i = 0; i < result.length; i++){
            int indexOfTeam = result[i].indexOf(toFind);
            int lastSpace = result[i].lastIndexOf(' ');
            if (indexOfTeam == 0){
                int toFindSize = toFind.length();
                teamScores[i] = tryParse(result[i].substring(toFindSize + 1, result[i].indexOf(' ', toFindSize + 1)));
                oppositeScores[i] = tryParse(result[i].substring(lastSpace + 1));
            } else {
                teamScores[i] = tryParse(result[i].substring(lastSpace + 1));
                oppositeScores[i] = tryParse(result[i].substring(result[i].lastIndexOf(' ', indexOfTeam - 2) + 1, indexOfTeam - 1));
            }
            if (teamScores[i] == -1 || oppositeScores[i] == -1) return String.format("Error(float number):%s", result[i]);
            if (teamScores[i] > oppositeScores[i]) numberOfWins++;
            else if ( teamScores[i] == oppositeScores[i]) numberOfDraws++;
            else numberOfLoses++;
            scored += teamScores[i];
            conceded += oppositeScores[i];
        }
        int points = numberOfDraws + numberOfWins * 3;
        return String.format("%s:W=%d;D=%d;L=%d;Scored=%d;Conceded=%d;Points=%d", toFind, numberOfWins, numberOfDraws, numberOfLoses, scored, conceded, points);
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        return "";
    }
}
