package org.academy.kata.implementation.Shr1mpa;

import org.academy.kata.Six;

public class SixImpl implements Six {
    @Override
    public long findNb(long m) {
        long sum = 0;
        int n = 0;

        while (sum < m) {
            n++;
            sum += (long) Math.pow(n, 3);
        }

        return (sum == m) ? n : -1;
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
        return "";
    }
}
