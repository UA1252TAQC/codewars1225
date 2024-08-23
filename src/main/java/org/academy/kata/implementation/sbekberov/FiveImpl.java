package org.academy.kata.implementation.sbekberov;

import org.academy.kata.Base;
import org.academy.kata.Five;

import java.math.BigInteger;

public class FiveImpl extends Base implements Five {
    @Override
    public long[] gap(int g, long m, long n) {
        long previousPrime = -1;

        for (long i = m; i <= n; i++) {
            if (isPrime(i)) {
                if (previousPrime != -1 && i - previousPrime == g) {
                    return new long[]{previousPrime, i};
                }
                previousPrime = i;
            }
        }
        return null;
    }

    private static boolean isPrime(long num) {
        if (num < 2) return false;
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
        int num = n.intValue();

        if (num < 0) return BigInteger.ZERO;

        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        BigInteger sum = BigInteger.ZERO;

        for (int i = 0; i <= num; i++) {
            sum = sum.add(b);
            BigInteger next = a.add(b);
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
        double mid = 0;

        while (right - left > epsilon) {
            mid = (left + right) / 2;
            double value = mid / Math.pow(1 - mid, 2);

            if (value > m) {
                right = mid;
            } else {
                left = mid;
            }
        }
        return (left + right) / 2;
    }

    @Override
    public long[] smallest(long n) {
        String numStr = Long.toString(n);
        long minNumber = n;
        int fromIndex = -1;
        int toIndex = -1;

        for (int i = 0; i < numStr.length(); i++) {
            char digit = numStr.charAt(i);
            StringBuilder sb = new StringBuilder(numStr);
            sb.deleteCharAt(i);

            for (int j = 0; j <= sb.length(); j++) {
                StringBuilder temp = new StringBuilder(sb);
                temp.insert(j, digit);
                long candidate = Long.parseLong(temp.toString());

                if (candidate < minNumber) {
                    minNumber = candidate;
                    fromIndex = i;
                    toIndex = j;
                }
            }
        }

        return new long[]{minNumber, fromIndex, toIndex};
    }
}
