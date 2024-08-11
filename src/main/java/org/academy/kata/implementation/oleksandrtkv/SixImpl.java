package org.academy.kata.implementation.oleksandrtkv;

import org.academy.kata.Six;

public class SixImpl implements Six {
    @Override
    public long findNb(long m) {
        long n = 1;
        long sum = 0;
        while (sum < m){
            sum += (long) Math.pow(n, 3);
            if (sum == m){
                break;
            }
            n++;
        }
        if(sum != m){
            n = -1;
        }
        return n;
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
