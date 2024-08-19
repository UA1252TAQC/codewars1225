package org.academy.codewars;

import static org.testng.Assert.assertEquals;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.math.BigInteger;
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
    public void testReadFloatValidData() {
        String testData = "23.4\n";
        float expected = 23.4f;
        System.setIn(new ByteArrayInputStream(testData.getBytes()));
        InputStream inputStream = System.in;
        ConsoleScanner consoleScanner = new ConsoleScanner(new Scanner(inputStream));
        float actual = consoleScanner.readFloat("test float");
        assertEquals(actual, expected);
    }

    @Test
    public void testReadFloatInvalidData() {
        String testData = "invalid 1.4\n";
        float expected = 1.4f;
        System.setIn(new ByteArrayInputStream(testData.getBytes()));
        InputStream inputStream = System.in;
        ConsoleScanner consoleScanner = new ConsoleScanner(new Scanner(inputStream));
        float actual = consoleScanner.readFloat("test float");
        assertEquals(actual, expected);
    }

    @Test
    public void testReadLongInvalidData() {
        String testData = "invalid\n987654321\n";
        long expected = 987654321L;
        System.setIn(new ByteArrayInputStream(testData.getBytes()));
        InputStream inputStream = System.in;
        ConsoleScanner consoleScanner = new ConsoleScanner(new Scanner(inputStream));
        long actual = consoleScanner.readLong("test long");
        assertEquals(expected, actual);
    }

    @Test
    public void testReadLongValidData() {
        String testData = "123456789\n";
        long expected = 123456789L;
        System.setIn(new ByteArrayInputStream(testData.getBytes()));
        InputStream inputStream = System.in;
        ConsoleScanner consoleScanner = new ConsoleScanner(new Scanner(inputStream));
        long actual = consoleScanner.readLong("test long");
        assertEquals(expected, actual);
    }

    @Test
    public void testReadDoubleValidData() {
        String testData = "7.5\n";
        double expected = 7.5;
        System.setIn(new ByteArrayInputStream(testData.getBytes()));
        InputStream inputStream = System.in;
        ConsoleScanner consoleScanner = new ConsoleScanner(new Scanner(inputStream));
        double actual = consoleScanner.readDouble("test double");
        assertEquals(actual, expected);
    }

    @Test
    public void testReadDoubleInvalidData() {
        String testData = "invalid\n2.718\n";
        double expected = 2.718;
        System.setIn(new ByteArrayInputStream(testData.getBytes()));
        InputStream inputStream = System.in;
        ConsoleScanner consoleScanner = new ConsoleScanner(new Scanner(inputStream));
        double actual = consoleScanner.readDouble("test double");
        assertEquals(actual, expected);
    }

    @Test
    public void testReadBigIntegerValidData() {
        String testData = "12345678901234567890\n";
        BigInteger expected = new BigInteger("12345678901234567890");
        System.setIn(new ByteArrayInputStream(testData.getBytes()));
        InputStream inputStream = System.in;
        ConsoleScanner consoleScanner = new ConsoleScanner(new Scanner(inputStream));
        BigInteger actual = consoleScanner.readBigInteger("test BigInteger");
        assertEquals(actual, expected);
    }

    @Test
    public void testReadBigIntegerInvalidData() {
        String testData = "invalid\nsecondInvalid\n12345678901234567890\n";
        BigInteger expected = new BigInteger("12345678901234567890");
        System.setIn(new ByteArrayInputStream(testData.getBytes()));
        InputStream inputStream = System.in;
        ConsoleScanner consoleScanner = new ConsoleScanner(new Scanner(inputStream));
        BigInteger actual = consoleScanner.readBigInteger("test BigInteger");
        assertEquals(actual, expected);
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
        String testData = "test 123123#readString\n";
        System.setIn(new ByteArrayInputStream(testData.getBytes()));
        InputStream inputStream = System.in;
        ConsoleScanner consoleScanner = new ConsoleScanner(new Scanner(inputStream));
        String actual = consoleScanner.readString("test");
        String expected = "test 123123#readString";
        assertEquals(actual, expected);
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
