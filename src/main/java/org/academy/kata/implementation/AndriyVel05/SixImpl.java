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
    public String stockSummary(String[] lstOfArt, String[] lstOf1stLetter) {
        if (lstOfArt.length == 0 || lstOf1stLetter.length == 0) {
            return "";
        }

        Map<String, Integer> categoryMap = new HashMap<>();


        for (String category : lstOf1stLetter) {
            categoryMap.put(category, 0);
        }


        for (String art : lstOfArt) {
            String category = art.substring(0, 1);
            if (categoryMap.containsKey(category)) {
                int quantity = Integer.parseInt(art.split(" ")[1]);
                categoryMap.put(category, categoryMap.get(category) + quantity);
            }
        }


        StringBuilder result = new StringBuilder();
        for (String category : lstOf1stLetter) {
            if (result.length() > 0) {
                result.append(" - ");
            }
            result.append("(").append(category).append(" : ").append(categoryMap.get(category)).append(")");
        }

        return result.toString();
    }
}

