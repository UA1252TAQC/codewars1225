package org.academy.kata.implementation.YanOleks;

import org.academy.kata.Six;

public class SixImpl implements Six {
    @Override
    public long findNb(long m) {
        long numberOfCubes = 0;
        long volume = 0;
        while (volume < m){
            numberOfCubes++;
            volume += numberOfCubes * numberOfCubes * numberOfCubes;
        }
        if (volume == m) return numberOfCubes;
        else return -1L;
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
