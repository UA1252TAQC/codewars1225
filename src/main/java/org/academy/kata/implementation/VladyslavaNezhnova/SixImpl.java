package org.academy.kata.implementation.VladyslavaNezhnova;

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
        if (lstOfArt == null || lstOfArt.length == 0 || lstOf1stLetter == null || lstOf1stLetter.length == 0) {
            return "";
        }
        Map<String, Integer> categoryTotals = new HashMap<>();

        for (String book : lstOfArt) {
            String category = book.substring(0, 1);
            int count = Integer.parseInt(book.split(" ")[1]);
            categoryTotals.put(category, categoryTotals.getOrDefault(category, 0) + count);
        }
        StringBuilder res = new StringBuilder();
        for (String category : lstOf1stLetter) {
            int total = categoryTotals.getOrDefault(category, 0);
            if (res.length() > 0) {
                res.append(" - ");
            }
            res.append("(").append(category).append(" : ").append(total).append(")");
        }
        return res.toString();
    }
}
