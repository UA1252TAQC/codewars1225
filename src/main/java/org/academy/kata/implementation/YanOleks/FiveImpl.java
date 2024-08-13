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
        int zeros = 0;
        int dividend = 5;
        double quotient = n * 1. / dividend;
        while (quotient >= 1) {
            zeros += (int)quotient;
            dividend *= 5;
            quotient = n * 1. / dividend;
        }
        return zeros;
    }

    @Override
    public BigInteger perimeter(BigInteger n) {
        BigInteger sum = BigInteger.valueOf(2);
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;

        for (BigInteger i = BigInteger.ONE; i.compareTo(n) < 0; i = i.add(BigInteger.ONE)) {
            BigInteger next = a.add(b);
            sum = sum.add(next);
            a = b;
            b = next;
        }

        return sum.multiply(BigInteger.valueOf(4));
    }

    @Override
    public double solve(double m) {
        return (2 * m - Math.sqrt(4 * m + 1) + 1) / (2 * m);
    }

    @Override
    public long[] smallest(long n) {
        String numStr = Long.toString(n);
        int len = numStr.length();
        int iMin = 0, jMin = 0;
        String smallest = numStr;
        for (int i = 0; i < len; i++) {
            char currentChar = numStr.charAt(i);
            StringBuilder sb = new StringBuilder(numStr);
            sb.deleteCharAt(i);

            for (int j = 0; j <= len - 1; j++) {
                StringBuilder newSb = new StringBuilder(sb);
                newSb.insert(j, currentChar);

                String newValStr = newSb.toString();

                if (newValStr.compareTo(smallest) < 0 ||
                        (newValStr.equals(smallest) && i < iMin)) {
                    smallest = newValStr;
                    iMin = i;
                    jMin = j;
                }
            }
        }

        long minVal = Long.parseLong(smallest);
        return new long[] { minVal, iMin, jMin };
    }
}
