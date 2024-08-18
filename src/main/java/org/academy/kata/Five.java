package org.academy.kata;

import java.math.BigInteger;

public interface Five {
    long[] gap(int g, long m, long n);

    int zeros(int n);

    public BigInteger perimeter(BigInteger n) {
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        BigInteger sum = a.add(b);

        for (BigInteger i = BigInteger.valueOf(2); i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
            BigInteger next = a.add(b);
            sum = sum.add(next);
            a = b;
            b = next;
        }

        return sum.multiply(BigInteger.valueOf(4));

    }

    double solve(double m);

    long[] smallest(long n);

}
