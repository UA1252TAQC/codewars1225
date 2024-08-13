package org.academy.kata.implementation.ol271176;

import org.academy.kata.Five;

import java.math.BigInteger;

public class FiveImpl implements Five {
    @Override
    public long[] gap(int g, long m, long n) {
        return new long[0];
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
