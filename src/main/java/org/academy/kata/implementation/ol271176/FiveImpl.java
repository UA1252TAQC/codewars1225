package org.academy.kata.implementation.ol271176;

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
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        BigInteger sum = BigInteger.ONE;
        for(BigInteger i= BigInteger.valueOf(2); i.compareTo(n.add(BigInteger.ONE)) <=0;
            i = i.add(BigInteger.ONE)){
            BigInteger tmp = a.add(b);
            a = b;
            b = tmp;
            sum = sum.add(b);
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
