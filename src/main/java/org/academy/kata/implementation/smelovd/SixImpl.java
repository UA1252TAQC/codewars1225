package org.academy.kata.implementation.smelovd;

import org.academy.kata.Six;

import java.math.BigInteger;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class SixImpl implements Six {
    @Override
    public long findNb(long m) {
        final BigInteger expectedVolume = BigInteger.valueOf(m);
        BigInteger volume = BigInteger.ZERO;
        long cubesCount = 0;
        for (; volume.compareTo(expectedVolume) < 0; cubesCount++) {
            volume = volume.add(BigInteger.valueOf(cubesCount + 1).pow(3));
        }

        if (volume.compareTo(expectedVolume) != 0) {
            return -1;
        }

        return cubesCount;
    }

    @Override
    public String balance(String book) {
        if (book == null || book.isEmpty()) throw new IllegalArgumentException();
        final String[] clearLines = book.replaceAll("([^\\n. \\da-zA-Z])", "").split("\n");
        final double startBalance = Double.parseDouble(clearLines[0]);
        double currentBalance = startBalance;
        int count = 0;
        StringBuilder result = new StringBuilder().append("Original Balance: ").append(clearLines[0]);
        for (int i = 1; i < clearLines.length; i++, count++) {
            String[] lineVariables = clearLines[i].split("[ ]+");
            currentBalance -= Double.parseDouble(lineVariables[2]);
            result.append(String.format("\\r\\n%s %s %s Balance %.2f", lineVariables[0], lineVariables[1], lineVariables[2], currentBalance));
        }
        result.append(String.format("\\r\\nTotal expense  %.2f\\r\\nAverage expense  %.2f", startBalance - currentBalance, (startBalance - currentBalance) / count));
        return result.toString();
    }

    @Override
    public double f(double x) {
        return x / (1 + Math.sqrt(1 + x));
    }

    @Override
    public double mean(String town, String strng) {
        return getStream(town, strng).average().orElse(-1);
    }

    @Override
    public double variance(String town, String strng) {
        final double avg = mean(town, strng);
        return getStream(town, strng).map(i -> Math.pow(avg - i, 2)).average().orElse(-1);
    }

    private static DoubleStream getStream(String town, String strng) {
        return Arrays.stream(strng.split("\n"))
                .filter(townData -> townData.startsWith(town + ":"))
                .map(townData -> townData.substring(town.length() + 1))
                .flatMapToDouble(townData -> Arrays.stream(townData.split(","))
                        .map(monthData -> monthData.split(" ")[1])
                        .mapToDouble(Double::parseDouble));
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

    private static boolean isMatchMember(String[] teams, String team) {
        return teams[0].substring(0, teams[0].trim().lastIndexOf(" ")).trim().equals(team) ||
                teams[1].substring(0, teams[1].trim().lastIndexOf(" ")).trim().equals(team);
    }

    private static int[] extractScores(String[] teams, String team) {
        final String team1 = teams[0].trim();
        final String team2 = teams[1].trim();

        if (isRequiredTeam(team, team1)) return new int[]{extractScore(team1), extractScore(team2)};
        return new int[]{extractScore(team2), extractScore(team1)};
    }

    private static boolean isRequiredTeam(String team, String team1) {
        return team1.substring(0, team1.lastIndexOf(" ")).equals(team);
    }

    private static int extractScore(String team) {
        return Integer.parseInt(team.substring(team.lastIndexOf(" ")).trim());
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        final Map<Character, Integer> categoryCounts = Arrays.stream(lstOfArt)
                .collect(Collectors.groupingBy(s -> s.charAt(0), Collectors.summingInt(s -> Integer.parseInt(s.split(" ")[1]))));
        if (isAllZeros(lstOf1stLetter, categoryCounts)) return "";
        return Arrays.stream(lstOf1stLetter).map(letters -> String.format("(%s : %d)", letters, categoryCounts.getOrDefault(letters.charAt(0), 0)))
                .collect(Collectors.joining(" - "));
    }

    private static boolean isAllZeros(String[] lstOf1stLetter, Map<Character, Integer> categoryCounts) {
        return Arrays.stream(lstOf1stLetter).allMatch(letters -> categoryCounts.getOrDefault(letters.charAt(0), 0) == 0);
    }
}
