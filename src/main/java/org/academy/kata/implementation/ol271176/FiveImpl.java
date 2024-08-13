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
        int cnt = 0;
        while(n >= 5){
            n /= 5;
            cnt += n;
        }
        return cnt;
    }

    @Override
    public BigInteger perimeter(BigInteger n) {
        BigInteger a = BigInteger.ZERO;
        BigInteger b = BigInteger.ONE;
        BigInteger sum = BigInteger.ONE;
        for(BigInteger i= BigInteger.valueOf(2); i.compareTo(n.add(BigInteger.ONE)) <=0;
            i = i.add(BigInteger.ONE)){
            BigInteger tmp = a.add(b);
            a = b;
            b = tmp;
            sum = sum.add(b);
        }
        return sum.multiply(BigInteger.valueOf(4));
    }

    @Override
    public double solve(double m) {
        // Перевiрка коректностi m
        if (m <= 0) {
            throw new IllegalArgumentException("m must be greater than 0");
        }

        // Iнтервал пошука
        double lower = 0.0;
        double upper = 1.0;
        double tolerance = 1e-12;
        double midpoint;

        while ((upper - lower) > tolerance) {
            midpoint = (lower + upper) / 2.0;

            // Значення функцii в среднiй точцi
            double fx = midpoint / Math.pow(1 - midpoint, 2) - m;

            if (fx > 0) {
                upper = midpoint; // Корень у нижнiй частинi iнтервала
            } else {
                lower = midpoint; // Корень у верхнiй частинi iнтервала
            }
        }

        // Повертаємо значення середини інтервалу як наближену до кореня
        return (lower + upper) / 2.0;
    }

    @Override
    public long[] smallest(long n) {
        return new long[0];
    }
}
