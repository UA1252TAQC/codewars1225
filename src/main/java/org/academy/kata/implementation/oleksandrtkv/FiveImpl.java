package org.academy.kata.implementation.oleksandrtkv;

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
        if (n.compareTo(BigInteger.ZERO) < 0) {
            return BigInteger.ZERO;
        }
        int count = n.intValue() + 1;
        BigInteger[] fib = new BigInteger[count];

        if (count > 0) fib[0] = BigInteger.ONE;
        if (count > 1) fib[1] = BigInteger.ONE;

        for (int i = 2; i < count; i++) {
            fib[i] = fib[i - 1].add(fib[i - 2]);
        }

        BigInteger sum = BigInteger.ZERO;
        for (BigInteger f : fib) {
            sum = sum.add(f);
        }
        return sum.multiply(BigInteger.valueOf(4));
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
