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
        return "";
    }

    @Override
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0) {
            return "";
        }

        StringBuilder result = new StringBuilder();
        for (String category : lstOf1stLetter) {
            int sum = 0;
            for (String art : lstOfArt) {
                if (art.startsWith(category)) {
                    sum += Integer.parseInt(art.split(" ")[1]);
                }
            }
            if (result.length() > 0) {
                result.append(" - ");
            }
            result.append("(").append(category).append(" : ").append(sum).append(")");
        }

        return result.toString();
    }

}
