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

    @Test
    public void testReadFloat() {
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

    @Test(dataProvider = "dp-testReadDoubleValidData")
    public void testReadDouble(String param, String input, double expectedValue, String expectedOutput) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        InputStream inputStream = System.in;
        ConsoleScanner consoleScanner = new ConsoleScanner(new Scanner(inputStream));

        ByteArrayOutputStream actualOutputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(actualOutputStream));

        double actualValue = consoleScanner.readDouble(param);

        System.setOut(originalOut);

        assertEquals(actualOutputStream.toString(), expectedOutput);
        assertEquals(actualValue, expectedValue);
    }

    @Test(dataProvider = "dp-testReadDoubleInvalidData")
    public void testReadDoubleInvalidData(String param, String input, double expectedValue, String expectedOutput) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        InputStream inputStream = System.in;
        ConsoleScanner consoleScanner = new ConsoleScanner(new Scanner(inputStream));

        ByteArrayOutputStream actualOutputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(actualOutputStream));

        double actualValue = consoleScanner.readDouble(param);

        System.setOut(originalOut);

        assertEquals(actualOutputStream.toString(), expectedOutput);
        assertEquals(actualValue, expectedValue);
    }




    @Test
    public void testReadBigInteger() {
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

    @Test
    public void testReadDoubleArray() {
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
