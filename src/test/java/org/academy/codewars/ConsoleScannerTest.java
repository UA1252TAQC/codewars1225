package org.academy.codewars;

import static org.testng.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import org.testng.annotations.Test;

public class ConsoleScannerTest {

    @Test
    public void testReadIntValidData() {
        String testData = "25\n";
        int expected = 25;
        System.setIn(new ByteArrayInputStream(testData.getBytes()));
        InputStream inputStream = System.in;
        ConsoleScanner consoleScanner = new ConsoleScanner(new Scanner(inputStream));
        int actual = consoleScanner.readInt("test int");
        assertEquals(actual, expected);
    }

    @Test
    public void testReadIntInvalidData() {
        String testData = "invalid\n25\n";
        int expected = 25;
        System.setIn(new ByteArrayInputStream(testData.getBytes()));
        InputStream inputStream = System.in;
        ConsoleScanner consoleScanner = new ConsoleScanner(new Scanner(inputStream));
        int actual = consoleScanner.readInt("test int");
        assertEquals(actual, expected);
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
    public void testReadDoubleArrayValidData() {
        String testData = "3\n1.1\n2.2\n3.3\n";
        double[] expected = new double[]{1.1, 2.2, 3.3};
        System.setIn(new ByteArrayInputStream(testData.getBytes()));
        InputStream inputStream = System.in;
        ConsoleScanner consoleScanner = new ConsoleScanner(new Scanner(inputStream));
        double[] actual = consoleScanner.readDoubleArray("test array");
        assertEquals(actual, expected);
    }

    @Test
    public void testReadDoubleArrayInvalidData() {
        String testData = "invalid\n-3\n3\n1.1\n2.2\n3.3\n";
        double[] expected = new double[]{1.1, 2.2, 3.3};
        System.setIn(new ByteArrayInputStream(testData.getBytes()));
        InputStream inputStream = System.in;
        ConsoleScanner consoleScanner = new ConsoleScanner(new Scanner(inputStream));
        double[] actual = consoleScanner.readDoubleArray("test array");
        assertEquals(actual, expected);
    }

    @Test
    public void testReadString() {
    }

    @Test
    public void testReadStringArrayValidData() {
        String testData =
                """
                        t
                        -3
                        3
                        First arg
                        Second arg
                        Third arg
                        """;
        String[] expected = new String[]{"First arg", "Second arg", "Third arg"};
        System.setIn(new ByteArrayInputStream(testData.getBytes()));
        InputStream inputStream = System.in;
        ConsoleScanner consoleScanner = new ConsoleScanner(new Scanner(inputStream));
        String[] actual = consoleScanner.readStringArray("test");
        assertEquals(actual, expected);
    }

    @Test
    public void testReadStringArrayInvalidData() {
        String testData =
                """
                         test
                         -3
                         3
                         First arg\s
                         Second arg
                         Third arg
                        \s""";
        String[] expected = new String[]{"First arg", "Second arg", "Third arg"};
        System.setIn(new ByteArrayInputStream(testData.getBytes()));
        InputStream inputStream = System.in;
        ConsoleScanner consoleScanner = new ConsoleScanner(new Scanner(inputStream));
        String[] actual = consoleScanner.readStringArray("test");
        assertEquals(actual, expected);
    }
}