package org.academy.kata.implementation.smelovd;

import org.academy.kata.Six;

import java.math.BigInteger;

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
