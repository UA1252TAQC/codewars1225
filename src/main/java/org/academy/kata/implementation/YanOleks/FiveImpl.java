package org.academy.kata.implementation.YanOleks;

import org.academy.kata.Five;

import java.math.BigInteger;

public class FiveImpl implements Five {
    @Override
    public long[] gap(int g, long m, long n) {
        return new long[0];
    }

    @Override
    public int zeros(int n) {
        int zeros = 0;
        int dividend = 5;
        double quotient = n * 1. / dividend;
        while (quotient >= 1) {
            zeros += (int)quotient;
            dividend *= 5;
            quotient = n * 1. / dividend;
        }
        return zeros;
    }

    @Override
    public BigInteger perimeter(BigInteger n) {
        return null;
    }

    @Override
    public double solve(double m) {
        return 0;
    }

    @Override
    public long[] smallest(long n) {
        return new long[0];
    }
}
