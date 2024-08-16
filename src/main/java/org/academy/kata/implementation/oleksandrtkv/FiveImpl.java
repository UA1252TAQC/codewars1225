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
        int res = 0;
        for (int i = 5; i <= n; i *= 5) {
            res += n / i;
        }
        return res;
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
        return (2 * m + 1 - Math.sqrt(4 * m + 1)) / (2 * m);
    }

    @Override
    public long[] smallest(long n) {
        return new long[0];
    }
}
