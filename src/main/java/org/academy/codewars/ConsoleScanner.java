package org.academy.codewars;

import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleScanner {
    private final Scanner scanner;

    public ConsoleScanner(Scanner scanner) {
        this.scanner = scanner;
    }

    public int readInt() {
        while (true) {
            try {
                System.out.print("Enter an int number: ");
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid data format. An integer is expected.");
                scanner.next();
            }
        }
    }

    public int readInt(String param) {
        while (true) {
            try {
                System.out.print("Enter a " + param + " (int): ");
                return scanner.nextInt();
            } catch (InputMismatchException e) {
                System.out.println("Invalid data format. An integer is expected.");
                scanner.next();
            }
        }
    }

    public float readFloat() {
        while (true) {
            try {
                System.out.print("Enter a float number: ");
                return scanner.nextFloat();
            } catch (InputMismatchException e) {
                System.out.println("Invalid data format. A floating point number is expected.");
                scanner.next();
            }
        }
    }

    public long readLong() {
        while (true) {
            try {
                System.out.print("Enter a long number: ");
                return scanner.nextLong();
            } catch (InputMismatchException e) {
                System.out.println("Invalid data format. An integer (long) is expected.");
                scanner.next();
            }
        }
    }

    public double readDouble() {
        while (true) {
            try {
                System.out.print("Enter a double number: ");
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid data format. A floating point number is expected.");
                scanner.next();
            }
        }
    }

    public double readDouble(String param) {
        while (true) {
            try {
                System.out.print("Enter a " + param + " (double): ");
                return scanner.nextDouble();
            } catch (InputMismatchException e) {
                System.out.println("Invalid data format. A floating point number is expected.");
                scanner.next();
            }
        }
    }

    public BigInteger readBigInteger() {
        while (true) {
            try {
                System.out.print("Enter a BigInteger number: ");
                return scanner.nextBigInteger();
            } catch (InputMismatchException e) {
                System.out.println("Invalid data format. An integer (BigInteger) is expected.");
                scanner.next();
            }
        }
    }

    public int[] readIntArray() {
        System.out.print("Enter the number of elements int[] => ");
        int size = readInt();
        int[] array = new int[size];
        System.out.println("Enter elements int[]:");
        for (int i = 0; i < size; i++) {
            System.out.print("Element_" + (i + 1) + " => ");
            array[i] = readInt();
        }
        return array;
    }

    public double[] readDoubleArray() {
        System.out.print("Enter the number of elements double[] => ");
        int size = readInt();
        double[] array = new double[size];
        System.out.println("Enter elements double[]:");
        for (int i = 0; i < size; i++) {
            System.out.print("Element_" + (i + 1) + " => ");
            array[i] = readDouble();
        }
        return array;
    }

    public String readString() {
        System.out.print("Enter a String: ");
        return scanner.nextLine();
    }

    public String[] readStringArray() {
        System.out.print("Enter the number of elements String[] => ");
        int size = readInt();
        String[] array = new String[size];
        scanner.nextLine();
        System.out.println("Enter elements String[]:");
        for (int i = 0; i < size; i++) {
            System.out.print("Element_" + (i + 1) + " => ");
            array[i] = readString();
        }
        return array;
    }

    public void close() {
        scanner.close();
    }
}
