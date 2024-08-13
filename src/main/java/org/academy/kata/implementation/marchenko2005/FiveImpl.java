package org.academy.kata.implementation.marchenko2005;

import org.academy.kata.Five;

import java.math.BigInteger;
import java.util.ArrayList;

public class FiveImpl implements Five {
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
        for(long i = m; i<=n; i++){
            if(isPrime(i)){
                primes.add(i);
            }
        }
        for (int i = 1; i < primes.size(); i++) {
            if(primes.get(i) - primes.get(i - 1) == g){
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
