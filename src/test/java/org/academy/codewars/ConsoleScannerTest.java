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
    public void testReadIntFail() {
        System.setIn(new ByteArrayInputStream("26".getBytes()));
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
    public void testReadDoubleArray() {
    }

    @Test
    public void testReadString() {
    }

    @Test
    public void testReadStringArray() {
    }
}