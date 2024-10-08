package org.academy.kata.implementation.marchenko2005;

import org.academy.kata.Base;
import org.academy.kata.Five;

import java.math.BigInteger;
import java.util.ArrayList;

public class FiveImpl extends Base implements Five {
    public static boolean isPrime(double n) {
        if (n <= 1) return false;
        if (n <= 3) return true;
        if (n % 2 == 0 || n % 3 == 0) return false;
        for (int i = 5; i * i <= n; i += 6) {
            if (n % i == 0 || n % (i + 2) == 0) return false;
        }
        return true;
    }

    @Override
    public long[] gap(int g, long m, long n) {
        ArrayList<Long> primes = new ArrayList<>();
        for (long i = m; i <= n; i++) {
            if (isPrime(i)) {
                primes.add(i);
            }
        }
        for (int i = 1; i < primes.size(); i++) {
            if (primes.get(i) - primes.get(i - 1) == g) {
                return new long[]{primes.get(i - 1), primes.get(i)};
            }
        }
        return null;
    }

    @Override
    public int zeros(int n) {
        int count = 0;
        for (int i = 5; n / i >= 1; i *= 5) {
            count += n / i;
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
        double low = 0.0;
        double high = 1.0;
        double mid = 0.5;
        double tolerance = 1e-12;

        while (high - low > tolerance) {
            mid = (low + high) / 2.0;
            double fMid = mid / Math.pow(1 - mid, 2);

            if (fMid < m) {
                low = mid;
            } else {
                high = mid;
            }
        }

        return mid;
    }

    @Override
    public long[] smallest(long n) {
        String numStr = Long.toString(n);
        int length = numStr.length();
        long smallestNumber = n;
        int fromIndex = -1;
        int toIndex = -1;

        for (int i = 0; i < length; i++) {
            char digit = numStr.charAt(i);
            StringBuilder sb = new StringBuilder(numStr);
            sb.deleteCharAt(i);
            for (int j = 0; j <= sb.length(); j++) {
                sb.insert(j, digit);
                long newNumber = Long.parseLong(sb.toString());
                if (newNumber < smallestNumber) {
                    smallestNumber = newNumber;
                    fromIndex = i;
                    toIndex = j;
                }
                sb.deleteCharAt(j);
            }
        }
        return new long[]{smallestNumber, fromIndex, toIndex};
    }
}
