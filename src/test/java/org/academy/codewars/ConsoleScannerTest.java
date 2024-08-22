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

    @Test(dataProvider = "dp-TestReadInt")
    public void testReadInt(String param, String input, int expectedValue, String expectedOutput) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ConsoleScanner consoleScanner = new ConsoleScanner(new Scanner(System.in));
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(outputStream));
        int actualValue = consoleScanner.readInt(param);
        System.setOut(originalOut);
        assertEquals(actualValue, expectedValue);
        assertEquals(outputStream.toString(), expectedOutput);
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

    @Test(dataProvider = "dp-testReadLong")
    public void testReadLong(String input, String expectedOutput) {
        ByteArrayInputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);

        ByteArrayOutputStream out = new ByteArrayOutputStream();
        System.setOut(new PrintStream(out));

        ConsoleScanner scannerTest = new ConsoleScanner(new Scanner(System.in));
        scannerTest.readLong("test value");

        assertEquals(out.toString(), expectedOutput);

    }

    @Test(dataProvider = "dp-testReadDouble")
    public void testReadDouble(String param, String input, double expectedValue, String expectedOutput) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        InputStream inputStream = System.in;
        ConsoleScanner consoleScanner = new ConsoleScanner(new java.util.Scanner(inputStream));

        ByteArrayOutputStream actualOutputStream = new ByteArrayOutputStream();
        PrintStream originalOut = System.out;
        System.setOut(new PrintStream(actualOutputStream));

        double actualValue = consoleScanner.readDouble(param);

        System.setOut(originalOut);

        assertEquals(actualOutputStream.toString(), expectedOutput);
        assertEquals(actualValue, expectedValue);
    }

    @Test(dataProvider = "dp-testReadIntArray")
    public void testReadIntArray(String param, String input, int[] expectedValue, String expectedOutput) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ConsoleScanner consoleScanner = new ConsoleScanner(new Scanner(System.in));

        var actualOutputStream = new ByteArrayOutputStream();
        var originalOut = System.out;
        System.setOut(new PrintStream(actualOutputStream));

        int[] actualValue = consoleScanner.readIntArray(param);

        System.setOut(originalOut);
        assertEquals(actualValue, expectedValue);
        assertEquals(actualOutputStream.toString(), expectedOutput);
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

    @Test(dataProvider = "dp-testReadBigInteger")
    public void testReadBigInteger(String param, String input, BigInteger expectedValue, String expectedOutput) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        ConsoleScanner consoleScanner = new ConsoleScanner(new Scanner(System.in));

        var actualOutputStream = new ByteArrayOutputStream();
        var originalOut = System.out;
        System.setOut(new PrintStream(actualOutputStream));

        BigInteger actualValue = consoleScanner.readBigInteger(param);

        System.setOut(originalOut);
        String actualOutput = actualOutputStream.toString();

        assertEquals(actualValue, expectedValue);
        assertEquals(actualOutput, expectedOutput);
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
