package org.academy.kata.implementation.marchenko2005;

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
        double low = 0.0;
        double high = 1.0;
        double mid = 0.5;
        double tolerance = 1e-12;

        while (high - low > tolerance) {
            mid = (low + high) / 2.0;
            double fMid = mid / Math.pow(1 - mid, 2);

            if (fMid < m) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return mid;
    }

    @Override
    public long[] smallest(long n) {
        return new long[0];
    }
}
