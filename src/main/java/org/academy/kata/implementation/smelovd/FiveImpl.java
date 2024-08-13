package org.academy.kata.implementation.smelovd;

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
        return sumFibonacci(n.longValueExact()).multiply(BigInteger.valueOf(4L));
    }

    private static BigInteger sumFibonacci(long n) {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        BigInteger sum = a.add(b);

        for (int i = 2; i <= n + 1; i++) {
            BigInteger next = a.add(b);
            sum = sum.add(next);
            a = b;
            b = next;
        }

        return sum;
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
