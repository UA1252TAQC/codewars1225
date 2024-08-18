package org.academy.codewars;

import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.testng.Assert.*;

public class ConsoleScannerTest {

    @Test
    public void testReadInt() {
        System.setIn(new ByteArrayInputStream("25".getBytes()));
        InputStream inputStream = System.in;
        ConsoleScanner consoleScanner = new ConsoleScanner(new Scanner(inputStream));
        int actual = consoleScanner.readInt("test");
        assertEquals(actual, 25);

    }

    @Test
    public void testReadFloat() {
    }

    @Test
    public void testReadLong() {
    }

    @Test
    public void testReadDouble() {
    }

    @Test
    public void testReadBigInteger() {
    }

    @Test
    public void testReadIntArray() {
    }

    @Test
    public void testReadDoubleArrayCorrectData() {
        String testData = "3\n1.1\n2.2\n3.3\n";
        double [] expected = new double[] {1.1, 2.2, 3.3};
        System.setIn(new ByteArrayInputStream(testData.getBytes()));
        InputStream inputStream = System.in;
        ConsoleScanner consoleScanner = new ConsoleScanner(new Scanner(inputStream));
        double [] actual = consoleScanner.readDoubleArray("test array");
        assertEquals(actual, expected);
    }
    @Test
    public void testReadDoubleArrayIncorrectData() {
        String testData = "3\n1.1\n2.2\n3.3\n";
        double [] expected = new double[] {1.5, 2.2, 3.3};
        System.setIn(new ByteArrayInputStream(testData.getBytes()));
        InputStream inputStream = System.in;
        ConsoleScanner consoleScanner = new ConsoleScanner(new Scanner(inputStream));
        double [] actual = consoleScanner.readDoubleArray("test array");
        assertEquals(actual, expected);
    }

    @Test
    public void testReadString() {
    }

    @Test
    public void testReadStringArray() {
    }
}