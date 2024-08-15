package org.academy.codewars;

import java.math.BigInteger;
import java.util.InputMismatchException;
import java.util.Scanner;

public class ConsoleScanner {
    private final Scanner scanner;

    public ConsoleScanner(Scanner scanner) {
        this.scanner = scanner;
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

    public float readFloat(String param) {
        while (true) {
            try {
                System.out.print("Enter a " + param + " (float): ");
                return scanner.nextFloat();
            } catch (InputMismatchException e) {
                System.out.println("Invalid data format. A floating point number is expected.");
                scanner.next();
            }
        }
    }

    public long readLong(String param) {
        while (true) {
            try {
                System.out.print("Enter a " + param + " (long): ");
                return scanner.nextLong();
            } catch (InputMismatchException e) {
                System.out.println("Invalid data format. An integer (long) is expected.");
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

    public BigInteger readBigInteger(String param) {
        while (true) {
            try {
                System.out.print("Enter a " + param + " number: ");
                return scanner.nextBigInteger();
            } catch (InputMismatchException | NumberFormatException e) {
                System.out.println("Invalid data format. An integer (BigInteger) is expected.");
                scanner.next();
            }
        }
    }

    public int[] readIntArray(String param) {
        System.out.print("Enter the " + param + " (int array): ) ");
        int size = readInt("size for array");
        int[] array = new int[size];
        System.out.println("Enter elements int[]:");
        for (int i = 0; i < size; i++) {
            System.out.print("Element_" + (i + 1) + " => ");
            array[i] = readInt("new int");
        }
        return array;
    }

    public double[] readDoubleArray(String param) {
        System.out.print("Enter the " + param + " (int array): ) ");
        int size = readInt("size for array");
        double[] array = new double[size];
        System.out.println("Enter elements double[]:");
        for (int i = 0; i < size; i++) {
            System.out.print("Element_" + (i + 1) + " => ");
            array[i] = readDouble("new double");
        }
        return array;
    }

    public String readString(String param) {
        System.out.print("Enter a " + param + " : ");
        return scanner.nextLine();
    }

    public String[] readStringArray(String param) {
        System.out.print("Enter the " + param + " (int array): ) ");
        int size = readInt("size for array");
        String[] array = new String[size];
        scanner.nextLine();
        System.out.println("Enter elements String[]:");
        for (int i = 0; i < size; i++) {
            System.out.print("Element_" + (i + 1) + " => ");
            array[i] = readString("new string");
        }
        return array;
    }
}
