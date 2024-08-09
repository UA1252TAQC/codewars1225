package org.academy.kata.implementation.smelovd;

import org.academy.kata.Five;

import java.math.BigInteger;
import java.util.stream.LongStream;

public class FiveImpl implements Five {
    @Override
    public long[] gap(int g, long m, long n) {
        final long[] primeNumbers = LongStream.rangeClosed(m, n)
                .filter(FiveImpl::isPrimeNumber).toArray();
        for (int i = 0; i + 1 < primeNumbers.length; i++) {
            if (primeNumbers[i + 1] - primeNumbers[i] == g) {
                return new long[] {primeNumbers[i], primeNumbers[i + 1]};
            }
        }
        return null;
    }

    private static boolean isPrimeNumber(long num) {
        if (num <= 1) return false;
        if (num == 2) return true;
        if (num % 2 == 0) return false;

        for (long i = 3; i * i <= num; i += 2) {
            if (num % i == 0) return false;
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
