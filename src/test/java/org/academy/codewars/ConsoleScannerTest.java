package org.academy.codewars;

import org.academy.codewars.dataproviders.ConsoleScannerDataProvider;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
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
        final ConsoleScanner consoleScanner = new ConsoleScanner(new Scanner(System.in));

        final ByteArrayOutputStream actualOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutputStream));

        final int actualValue = consoleScanner.readInt(param);

        assertEquals(actualValue, expectedValue);
        assertEquals(actualOutputStream.toString(), expectedOutput);
    }

    @Test(dataProvider = "dp-testReadFloat")
    public void testReadFloat(String param, String input, Float expectedValue, String expectedOutput) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        final ConsoleScanner consoleScanner = new ConsoleScanner(new Scanner(System.in));

        final ByteArrayOutputStream actualOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutputStream));

        final float actualValue = consoleScanner.readFloat(param);

        assertEquals(actualValue, expectedValue);
        assertEquals(actualOutputStream.toString(), expectedOutput);
    }

    @Test(dataProvider = "dp-testReadLong")
    public void testReadLong(String param, String input, long expectedValue, String expectedOutput) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        final ConsoleScanner consoleScanner = new ConsoleScanner(new Scanner(System.in));

        final ByteArrayOutputStream actualOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutputStream));

        final long actualValue = consoleScanner.readLong(param);

        assertEquals(actualValue, expectedValue);
        assertEquals(actualOutputStream.toString(), expectedOutput);
    }

    @Test(dataProvider = "dp-testReadDouble")
    public void testReadDouble(String param, String input, double expectedValue, String expectedOutput) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        final ConsoleScanner consoleScanner = new ConsoleScanner(new Scanner(System.in));

        final ByteArrayOutputStream actualOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutputStream));

        final double actualValue = consoleScanner.readDouble(param);

        assertEquals(actualValue, expectedValue);
        assertEquals(actualOutputStream.toString(), expectedOutput);
    }

    @Test(dataProvider = "dp-testReadIntArray")
    public void testReadIntArray(String param, String input, int[] expectedValue, String expectedOutput) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        final ConsoleScanner consoleScanner = new ConsoleScanner(new Scanner(System.in));

        final ByteArrayOutputStream actualOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutputStream));

        final int[] actualValue = consoleScanner.readIntArray(param);

        assertEquals(actualValue, expectedValue);
        assertEquals(actualOutputStream.toString(), expectedOutput);
    }

    @Test(dataProvider = "dp-testReadString")
    public void testReadString(String param, String input, String expectedValue, String expectedOutput) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        final ConsoleScanner consoleScanner = new ConsoleScanner(new Scanner(System.in));

        final ByteArrayOutputStream actualOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutputStream));

        final String actualValue = consoleScanner.readString(param);

        assertEquals(actualValue, expectedValue);
        assertEquals(actualOutputStream.toString(), expectedOutput);
    }

    @Test(dataProvider = "dp-testReadBigInteger")
    public void testReadBigInteger(String param, String input, BigInteger expectedValue, String expectedOutput) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        final ConsoleScanner consoleScanner = new ConsoleScanner(new Scanner(System.in));

        final ByteArrayOutputStream actualOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutputStream));

        final BigInteger actualValue = consoleScanner.readBigInteger(param);

        assertEquals(actualValue, expectedValue);
        assertEquals(actualOutputStream.toString(), expectedOutput);
    }

    @Test(dataProvider = "dp-testReadDoubleArray")
    public void testReadDoubleArray(String param, String input, double[] expectedValue, String expectedOutput) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        final ConsoleScanner consoleScanner = new ConsoleScanner(new Scanner(System.in));

        final ByteArrayOutputStream actualOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutputStream));

        final double[] actualValue = consoleScanner.readDoubleArray(param);

        assertEquals(actualValue, expectedValue);
        assertEquals(actualOutputStream.toString(), expectedOutput);
    }

    @Test(dataProvider = "dp-testReadStringArray")
    public void testReadStringArray(String param, String input, String[] expectedValue, String expectedOutput) {
        System.setIn(new ByteArrayInputStream(input.getBytes()));
        final ConsoleScanner consoleScanner = new ConsoleScanner(new Scanner(System.in));

        final ByteArrayOutputStream actualOutputStream = new ByteArrayOutputStream();
        System.setOut(new PrintStream(actualOutputStream));

        final String[] actualValue = consoleScanner.readStringArray(param);

        assertEquals(actualValue, expectedValue);
        assertEquals(actualOutputStream.toString(), expectedOutput);
    }
}
