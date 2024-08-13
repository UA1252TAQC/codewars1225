package org.academy.kata.implementation.Shr1mpa;

import org.academy.kata.Five;

import java.math.BigInteger;

public class FiveImpl implements Five {
    @Override
    public long[] gap(int g, long m, long n) {
        return new long[0];
    }

    @Override
    public int zeros(int n) {
        long kMax = (long) (Math.log(n) / Math.log(5));
        int count = 0;
        for (int i = 1; i <= kMax; i++) {
            count += (int) (n / Math.pow(5, i));
        }
        return count;
    }

    @Override
    public BigInteger perimeter(BigInteger n) {
        BigInteger sum = BigInteger.ZERO;
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;

        for (BigInteger i = BigInteger.ZERO; i.compareTo(n.add(BigInteger.valueOf(2))) < 0;
             i = i.add(BigInteger.ONE)) {
            sum = sum.add(a);
            BigInteger temp = a.add(b);
            a = b;
            b = temp;
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
