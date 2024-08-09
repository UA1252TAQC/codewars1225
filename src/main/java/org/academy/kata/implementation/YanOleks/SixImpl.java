package org.academy.kata.implementation.YanOleks;

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
        int precision = 10;
        int shift = 2;
        double result = x / 2;
        double powerOfX = x;
        double coeficient = 1;
        long divider = 2L;
        short sign = -1;
        for (int i = 0; i < precision - shift; i++){
            powerOfX *= x;
            divider *= (2 * (i + shift));
            result += sign * coeficient * powerOfX / divider;
            coeficient *= 3;
            sign *= -1;
        }
        return result;
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
