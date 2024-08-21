package org.academy.kata.implementation.Mihailll333;

import org.academy.kata.Base;
import org.academy.kata.Five;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;

public class FiveImpl extends Base implements Five {
    @Override
    public long[] gap(int g, long m, long n) {
        long prevPrime = 0;

        for (long i = m; i <= n; i++) {
            if (isPrime(i)) {
                if (prevPrime != 0 && i - prevPrime == g) {
                    return new long[]{prevPrime, i};
                }
                prevPrime = i;
            }
        }

        return null;
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
        while (n >= 5) {
            n /= 5;
            count += n;
        }
        return count;
    }

    @Override
    public BigInteger perimeter(BigInteger n) {
        BigInteger sum = BigInteger.ZERO;
        BigInteger a = BigInteger.ONE;
        BigInteger b = BigInteger.ONE;

        for (BigInteger i = BigInteger.ZERO; i.compareTo(n) <= 0; i = i.add(BigInteger.ONE)) {
            sum = sum.add(a);
            BigInteger next = a.add(b);
            a = b;
            b = next;
        }
        return sum.multiply(BigInteger.valueOf(4));
    }

    @Override
    public double solve(double m) {
        double numeratorPart1 = 2 * m + 1;
        double numeratorPart2 = Math.sqrt(4 * m + 1);
        double numerator = numeratorPart1 - numeratorPart2;
        double denominator = 2 * m;

        return numerator / denominator;
    }

    @Override
    public long[] smallest(long n) {
        String numStr = Long.toString(n);
        int len = numStr.length();

        String minNumber = numStr;
        int minI = -1, minJ = -1;

        for (int i = 0; i < len; i++) {
            char digit = numStr.charAt(i);

            for (int j = 0; j < len; j++) {
                if (i == j) continue;

                StringBuilder sb = new StringBuilder(numStr);
                sb.deleteCharAt(i);
                sb.insert(j, digit);

                String newNumber = sb.toString();

                if (newNumber.compareTo(minNumber) < 0) {
                    minNumber = newNumber;
                    minI = i;
                    minJ = j;
                }
            }
        }

        long smallestNumber = Long.parseLong(minNumber);
        return new long[]{smallestNumber, minI, minJ};
    }
}
