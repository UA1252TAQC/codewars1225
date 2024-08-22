package org.academy.kata.implementation.Shr1mpa;

import org.academy.kata.Base;
import org.academy.kata.Five;

import java.math.BigInteger;

public class FiveImpl extends Base implements Five {
    @Override
    public long[] gap(int g, long m, long n) {
        long prevPrime = -1;
        for (long i = m; i <= n; i++) {
            if (isPrime(i)) {
                if (prevPrime != -1 && (i - prevPrime) == g) {
                    return new long[]{prevPrime, i};
                }
                prevPrime = i;
            }
        }
        return null;
    }

    @Override
    public int zeros(int n) {
        long kMax = (long) (Math.log(n) / Math.log(5));
        int count = 0;
        for (int i = 1; i <= kMax; i++) {
            count += (int) (n / Math.pow(5, i));
        }
        return count;
    }

    @Override
    public BigInteger perimeter(BigInteger n) {
        BigInteger sum = BigInteger.ZERO;
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;

        for (BigInteger i = BigInteger.ZERO; i.compareTo(n.add(BigInteger.valueOf(2))) < 0;
             i = i.add(BigInteger.ONE)) {
            sum = sum.add(a);
            BigInteger temp = a.add(b);
            a = b;
            b = temp;
        }

        return sum.multiply(BigInteger.valueOf(4));
    }

    @Override
    public double solve(double m) {
        double epsilon = 1e-15;
        double low = 0.0;
        double high = 1.0;
        double mid = 0.0;

        while (high - low > epsilon) {
            mid = (low + high) / 2.0;
            double mid_f = mid / Math.pow((1 - mid), 2);

            if (Math.abs(mid_f - m) <= epsilon) {
                return mid;
            } else if (mid_f > m) {
                high = mid;
            } else {
                low = mid;
            }
        }

        return mid;
    }

    @Override
    public long[] smallest(long n) {
        String numStr = Long.toString(n);
        long[] result = new long[]{n, -1, -1};
        long minNum = n;

        for (int i = 0; i < numStr.length(); i++) {
            for (int j = 0; j < numStr.length(); j++) {
                if (i == j) continue;

                StringBuilder sb = new StringBuilder(numStr);
                char c = sb.charAt(i);
                sb.deleteCharAt(i);
                sb.insert(j, c);
                long newNum = Long.parseLong(sb.toString());

                if (newNum < minNum) {
                    minNum = newNum;
                    result[0] = minNum;
                    result[1] = i;
                    result[2] = j;
                }
            }
        }

        return result;
    }

    private static boolean isPrime(long n) {
        if (n <= 1) {
            return false;
        }
        for (int i = 2; (long) i * i <= n; i++) {
            if (n % i == 0) {
                return false;
            }
        }
        return true;
    }
}
