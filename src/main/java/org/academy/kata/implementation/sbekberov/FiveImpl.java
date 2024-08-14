package org.academy.kata.implementation.sbekberov;

import org.academy.kata.Five;

import java.math.BigInteger;

public class FiveImpl implements Five {
    @Override
    public long[] gap(int g, long m, long n) {
        return new long[0];
    }

    @Override
    public int zeros(int n) {
        return 0;
    }

    @Override
    public BigInteger perimeter(BigInteger n) {
        return null;
    }

    @Override
    public double solve(double m) {
        double left = 0;
        double right = 1;
        double epsilon = 1e-12;
        double mid = 0;

        while (right - left > epsilon) {
            mid = (left + right) / 2;
            double value = mid / Math.pow(1 - mid, 2);

            if (value > m) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return (left + right) / 2;
    }

    @Override
    public long[] smallest(long n) {
        return new long[0];
    }
}
