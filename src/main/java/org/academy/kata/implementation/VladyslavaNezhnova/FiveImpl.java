package org.academy.kata.implementation.VladyslavaNezhnova;

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

        while (right - left > epsilon) {
            double mid = (left + right) / 2;
            double sum = 0;
            double term = mid;
            double n = 1;

            while (term > 1e-15) {
                sum += n * term;
                n++;
                term *= mid;
            }
            if (sum < m) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return (left + right) / 2;
    }


    @Override
    public long[] smallest(long n) {
        return new long[0];
    }
}
