package org.academy.kata.implementation.ol271176;

import org.academy.kata.Six;

public class SixImpl implements Six {
    @Override
    public long findNb(long m) {
        int n = 1;
        long totalVolume = 0;

        while(m > totalVolume){
            totalVolume += Math.pow(n++, 3);
        }
        n--;

        return totalVolume == m ? n : -1;
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
