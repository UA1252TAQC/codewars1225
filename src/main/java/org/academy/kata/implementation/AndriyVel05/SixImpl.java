package org.academy.kata.implementation.AndriyVel05;

import org.academy.kata.Six;
import java.util.HashMap;
import java.util.Map;

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
    public static String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        if (lstOfArt.length == 0 || lstOfArt.length == 0) return "";

        Map<Strimg, Integer> categoryMap = new HashMap<>();
        for (String letter : lstOf1stLetter) {
            categoryMap.put(letter, 0);
        }

        for (String art : lstOfArt) {
            String category = art.substring(0,1);
            int quantity = Integer.parseInt(art.split("")[1]);
            if (categoryMap.containsKey(category)) {
                categoryMap.put(category, categoryMap.get(category) + quantity);
            }
        }

        StringBuilder result = new StringBuilder();
        for (String letter : lstOf1stLetter) {
            result.append("(").append(letter).append(" : ").append(categoryMap.get(letter)).append(") - ");
        }
        return result.substring(0, result.length() - 3);
    }
}
