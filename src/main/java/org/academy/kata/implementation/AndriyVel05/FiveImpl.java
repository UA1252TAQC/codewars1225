package org.academy.kata.implementation.AndriyVel05;
import org.academy.kata.Base;
import org.academy.kata.Five;
import java.math.BigInteger;

public class FiveImpl extends Base implements Five {
    @Override
    public long[] gap(int g, long m, long n) {
        long prevPrime = 0;

        for (long i = m; i <= n; i++) {
            if (isPrime(i)) {
                if (prevPrime != 0 && i - prevPrime == g) {
                    return new long[] {prevPrime, i};
                }
                prevPrime = i;
            }
        }
        return new long[0];
    }

    private boolean isPrime(long num) {
        if (num <= 1) return false;
        if (num == 2 || num == 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (long i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }

    @Override
    public int zeros(int n) {
        int count = 0;
        while (n > 0) {
            n /= 5;
            count += n;
        }
        return count;
    }

    @Override
    public BigInteger perimeter(BigInteger n) {
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;
        BigInteger sum = BigInteger.valueOf(2);

        for (BigInteger i = BigInteger.valueOf(2); i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
            BigInteger next = a.add(b);
            sum = sum.add(next);
            a = b;
            b = next;
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

