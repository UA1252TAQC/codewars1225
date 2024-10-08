package org.academy.kata.implementation.VladyslavaNezhnova;

import org.academy.kata.Base;
import org.academy.kata.Five;

import java.math.BigInteger;

public class FiveImpl extends Base implements Five {

    private static boolean isPrime(long num) {
        if (num <= 1) return false;
        if (num == 2 || num == 3) return true;
        if (num % 2 == 0 || num % 3 == 0) return false;
        for (long i = 5; i * i <= num; i += 6) {
            if (num % i == 0 || num % (i + 2) == 0) return false;
        }
        return true;
    }

    @Override
    public long[] gap(int g, long m, long n) {
        long previousPrime = -1;

        for (long i = m; i <= n; i++) {
            if (isPrime(i)) {
                if (previousPrime != -1 && (i - previousPrime) == g) {
                    return new long[]{previousPrime, i};
                }
                previousPrime = i;
            }
        }
        return null;
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

    @Override
    public double solve(double m) {
        double left = 0;
        double right = 1;
        double epsilon = 1e-12;

        while (right - left > epsilon) {
            double mid = (left + right) / 2;
            double sum = 0;
            double term = mid;
            double n = 1;

            while (term > 1e-15) {
                sum += n * term;
                n++;
                term *= mid;
            }
            if (sum < m) {
                left = mid;
            } else {
                right = mid;
            }
        }
        return (left + right) / 2;
    }


    @Override
    public long[] smallest(long n) {
        String str = Long.toString(n);
        int len = str.length();
        long minNumber = n;
        int fromIndex = -1, toIndex = -1;

        for (int i = 0; i < len; i++) {
            for (int j = 0; j < len; j++) {
                if (i != j) {
                    StringBuilder sb = new StringBuilder(str);
                    char digitToMove = sb.charAt(i);
                    sb.deleteCharAt(i);
                    sb.insert(j, digitToMove);
                    long newNumber = Long.parseLong(sb.toString());

                    if (newNumber < minNumber || (newNumber == minNumber && (i < fromIndex || (i == fromIndex && j < toIndex)))) {
                        minNumber = newNumber;
                        fromIndex = i;
                        toIndex = j;
                    }
                }
            }
        }
        return new long[]{minNumber, fromIndex, toIndex};
    }
}
