package org.academy.codewars;

import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleScanner {
    private final Scanner scanner;

    public ConsoleScanner() {
        scanner = new Scanner(System.in);
    }

    public int readInt() {
        while (true) {
            try {
                System.out.print("Ввести int: ");
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Невірний формат даних. Очікується ціле число.");
                scanner.next();
            }
        }
    }

    public float readFloat() {
        while (true) {
            try {
                System.out.print("Ввести float: ");
                return scanner.nextFloat();
            } catch (InputMismatchException e) {
                System.out.println("Невірний формат даних. Очікується число з плаваючою комою (float).");
                scanner.next();
            }
        }
    }

    public long readLong() {
        while (true) {
            try {
                System.out.print("Ввести long: ");
                return scanner.nextLong();
            } catch (InputMismatchException e) {
                System.out.println("Невірний формат даних. Очікується ціле число (long).");
                scanner.next();
            }
        }
    }

    public double readDouble() {
        while (true) {
            try {
                System.out.print("Ввести double: ");
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Невірний формат даних. Очікується число з плаваючою комою.");
                scanner.next();
            }
        }
    }

    public BigInteger readBigInteger() {
        while (true) {
            try {
                System.out.print("Ввести BigInteger: ");
                return scanner.nextBigInteger();
            } catch (InputMismatchException e) {
                System.out.println("Невірний формат даних. Очікується ціле число (BigInteger).");
                scanner.next();
            }
        }
    }

    public int[] readIntArray() {
        System.out.print("Ввести кількість елементів int[] => ");
        int size = readInt();
        int[] array = new int[size];
        System.out.println("Ввести елементи int[]:");
        for (int i = 0; i < size; i++) {
            System.out.print("Елемент_" + (i + 1) + " => ");
            array[i] = readInt();
        }
        return array;
    }

    public double[] readDoubleArray() {
        System.out.print("Ввести кількість елементів double[] => ");
        int size = readInt();
        double[] array = new double[size];
        System.out.println("Ввести елементи double[]:");
        for (int i = 0; i < size; i++) {
            System.out.print("Елемент_" + (i + 1) + " => ");
            array[i] = readDouble();
        }
        return array;
    }

    public String readString() {
        System.out.print("Ввести рядок: ");
        return scanner.nextLine();
    }

    public String[] readStringArray() {
        System.out.print("Ввести кількість елементів String[] => ");
        int size = readInt();
        String[] array = new String[size];
        scanner.nextLine();
        System.out.println("Ввести елементи String[]:");
        for (int i = 0; i < size; i++) {
            System.out.print("Елемент_" + (i + 1) + " => ");
            array[i] = readString();
        }
        return array;
    }

    public void close() {
        scanner.close();
    }
}
