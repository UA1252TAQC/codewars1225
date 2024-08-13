package org.academy.kata.implementation.smelovd;

import org.academy.kata.Seven;

import java.util.Arrays;

public class SevenImpl implements Seven {
    @Override
    public long newAvg(double[] arr, double navg) {
        final long requiredValue = (long) Math.ceil(((navg * (arr.length + 1)) - Arrays.stream(arr).sum()));
        if (requiredValue <= 0) {
            throw new IllegalArgumentException(requiredValue + " <= 0");
        }

        return requiredValue;
    }

    @Override
    public String seriesSum(int n) {
        return "";
    }
}
