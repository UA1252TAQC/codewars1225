package org.academy.kata.implementation.YanOleks;

import org.academy.kata.Five;

import java.math.BigInteger;

public class FiveImpl implements Five {
    @Override
    public long[] gap(int g, long m, long n) {
        long firstPrime;
        long secondPrime = 0;
        boolean first = true;
        for (long i = m; i <= n; i++){
            if(isPrime(i)) {
                firstPrime = secondPrime;
                secondPrime = i;
                if(!first) if (secondPrime - firstPrime == g) return new long[]{firstPrime, secondPrime};
                first = false;
            }
        }
        return null;
    }
    private static boolean isPrime(long n){
        if (n <= 1) return false;
        if (n == 2 || n == 3) return true;
        if (n % 2 == 0) return false;
        for (long i = 3; i <= Math.sqrt(n); i += 2) {
            if (n % i == 0) return false;
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
