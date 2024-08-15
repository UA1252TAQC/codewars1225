package org.academy.kata.implementation.oleksandrtkv;

import org.academy.kata.Five;

import java.math.BigInteger;

public class FiveImpl implements Five {
    @Override
    public long[] gap(int g, long m, long n) {
        long start = 0;
        long end = 0;

        for (long i = m; i <= n; i++) {
            if (isPrime(i)) {
                if (start == 0) {
                    start = i;
                } else if (end == 0) {
                    end = i;
                } else {
                    start = end;
                    end = i;
                }

                if (end - start == g) {
                    return new long[] { start, end };
                }
            }
        }
        return null;
    }

    private boolean isPrime(long n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (long i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
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
        return 0;
    }

    @Override
    public long[] smallest(long n) {
        return new long[0];
    }
}
