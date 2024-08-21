package org.academy.codewars;

import org.academy.codewars.dataproviders.ConsoleScannerDataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.math.BigInteger;
import java.util.Locale;
import java.util.Scanner;

import static org.testng.Assert.assertEquals;

public class ConsoleScannerTest extends ConsoleScannerDataProvider {
    @BeforeClass()
    public void beforeClass() {
        Locale.setDefault(Locale.US);
    }

    @Test
    public void testReadInt() {
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

    @Test(dataProvider = "dp-testReadFloat")
    public void testReadFloat(String param, String input, Float expectedValue, String expectedOutput) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ConsoleScanner consoleScanner = new ConsoleScanner(new Scanner(System.in));

        var actualOutputStream = new ByteArrayOutputStream();
        var originalOut = System.out;
        System.setOut(new PrintStream(actualOutputStream));

        Float actualValue = consoleScanner.readFloat(param);

        System.setOut(originalOut);
        assertEquals(actualValue, expectedValue);
        assertEquals(actualOutputStream.toString(), expectedOutput);
    }

    @Test
    public void testReadLong() {
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
    public void testReadDouble() {
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
    
    @Test(dataProvider = "dp-testReadBigInteger")
    public void testReadBigInteger(String param, String input, BigInteger expectedValue, String expectedOutput) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ConsoleScanner consoleScanner = new ConsoleScanner(new Scanner(System.in));

        var actualOutputStream = new ByteArrayOutputStream();
        var originalOut = System.out;
        System.setOut(new PrintStream(actualOutputStream));

        BigInteger actualValue = consoleScanner.readBigInteger(param);
        System.setOut(originalOut);

        String actualOutputNormalized = actualOutputStream.toString().trim().replaceAll("[\\s\\n]+", " ");
        String expectedOutputNormalized = expectedOutput.trim().replaceAll("[\\s\\n]+", " ");

        assertEquals(actualValue, expectedValue);
        assertEquals(actualOutputNormalized, expectedOutputNormalized);
    }

    @Test
    public void testReadIntArray() {
        String testData = "3\n1\n-2\n0\n";
        int[] expected = new int[]{1, -2, 0};
        System.setIn(new ByteArrayInputStream(testData.getBytes()));
        InputStream inputStream = System.in;
        ConsoleScanner consoleScanner = new ConsoleScanner(new Scanner(inputStream));
        int[] actual = consoleScanner.readIntArray("test array");
        assertEquals(actual, expected);
    }

    @Test
    public void testReadIntArrayInvalidData() {
        String testData = "-3\n3\ninvalid 1\n-2\n0\n";
        int[] expected = new int[]{1, -2, 0};
        System.setIn(new ByteArrayInputStream(testData.getBytes()));
        InputStream inputStream = System.in;
        ConsoleScanner consoleScanner = new ConsoleScanner(new Scanner(inputStream));
        int[] actual = consoleScanner.readIntArray("test array");
        assertEquals(actual, expected);
    }

    @Test(dataProvider = "dp-testReadDoubleArray")
    public void testReadDoubleArray(String param, String input, double[] expectedValue, String expectedOutput) {

        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ConsoleScanner consoleScanner = new ConsoleScanner(new Scanner(System.in));

        var actualOutputStream = new ByteArrayOutputStream();
        var originalOut = System.out;
        System.setOut(new PrintStream(actualOutputStream));

        double[] actualValue = consoleScanner.readDoubleArray(param);

        System.setOut(originalOut);
        String actualOutput = actualOutputStream.toString();

        assertEquals(actualValue, expectedValue);
        assertEquals(actualOutput, expectedOutput);
    }

    @Test(dataProvider = "dp-testReadString")
    public void testReadString(String param, String input, String expectedValue, String expectedOutput) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ConsoleScanner consoleScanner = new ConsoleScanner(new Scanner(System.in));

        var actualOutputStream = new ByteArrayOutputStream();
        var originalOut = System.out;
        System.setOut(new PrintStream(actualOutputStream));

        String actualValue = consoleScanner.readString(param);

        System.setOut(originalOut);
        assertEquals(actualValue, expectedValue);
        assertEquals(actualOutputStream.toString(), expectedOutput);
    }

    @Test(dataProvider = "dp-testReadStringArray")
    public void testReadStringArray(String param, String input, String[] expectedValue, String expectedOutput) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ConsoleScanner consoleScanner = new ConsoleScanner(new Scanner(System.in));

        var actualOutputStream = new ByteArrayOutputStream();
        var originalOut = System.out;
        System.setOut(new PrintStream(actualOutputStream));

        String[] actualValue = consoleScanner.readStringArray(param);

        System.setOut(originalOut);
        assertEquals(actualValue, expectedValue);
        assertEquals(actualOutputStream.toString(), expectedOutput);

    }

}
