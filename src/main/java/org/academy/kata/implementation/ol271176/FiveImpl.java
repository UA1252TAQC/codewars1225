package org.academy.kata.implementation.ol271176;

import org.academy.kata.Five;
import java.util.*;
import java.math.BigInteger;

public class FiveImpl implements Five {
    @Override
    public long[] gap(int g, long m, long n) {
        boolean[] isPrime = new boolean[(int)n + 1];
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }

        //search prime numbers in current range
        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
        }

        List<Integer> primes = new ArrayList<>();
        for (int p = 2; p <= n; p++) {
            if (isPrime[p]) {
                primes.add(p);
            }
        }

        List<Integer> filteredPrimes = new ArrayList<>();
        for (int prime : primes) {
            if (prime >= m) {
                filteredPrimes.add(prime);
            }
        }

        // Search prime numbers with g gap
        for (int i = 0; i < filteredPrimes.size() - 1; i++) {
            int prime1 = filteredPrimes.get(i);
            int prime2 = filteredPrimes.get(i + 1);
            if (prime2 - prime1 == g) {
                return new long[] { prime1, prime2 };
            }
        }

        return null; // pair not found
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
