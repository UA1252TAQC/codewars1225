package org.academy.codewars.dataproviders;

import org.testng.annotations.DataProvider;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConsoleScannerDataProvider {

    @DataProvider(name = "dp-testReadStringArray")
    public Iterator<Object[]> testReadStringArray() {
        final List<Object[]> inputs = new ArrayList<>();
        final String param = "param";

        final String expectedOutput1 = "Enter a size for array > 0 " + param + " (int): Enter elements String[]:" + System.lineSeparator() +
                "Element_1 => Enter a new string: Element_2 => Enter a new string: Element_3 => Enter a new string: ";
        final String expectedOutput2 = "Enter a size for array > 0 " + param + " (int): Invalid data format. An integer is expected." + System.lineSeparator() +
                "Enter a size for array > 0 " + param + " (int): Enter a size for array > 0 " + param + " (int): Enter elements String[]:" + System.lineSeparator() +
                "Element_1 => Enter a new string: Element_2 => Enter a new string: Element_3 => Enter a new string: ";

        inputs.add(new Object[]{param, "3\nFirst arg \nSecond arg\nThird arg\n ", new String[]{"First arg", "Second arg", "Third arg"}, expectedOutput1});
        inputs.add(new Object[]{param, "test\n-3\n3\nFirst arg \nSecond arg\nThird arg\n ", new String[]{"First arg", "Second arg", "Third arg"}, expectedOutput2});

        return inputs.iterator();
    }
  
    @DataProvider(name = "dp-testReadBigInteger")
    public Iterator<Object[]> dpTestReadBigInteger() {
        final List<Object[]> inputs = new ArrayList<>();
        final String param = "readBigIntegerParam";

        final String expectedOutput1 = "Enter a " + param + " number: ";
        final String expectedOutput2 = "Enter a " + param + " number: Invalid data format. An integer (BigInteger) is expected." + System.lineSeparator()
            + "Enter a " + param + " number: ";

        inputs.add(new Object[]{param, "12345\n", new BigInteger("12345"), expectedOutput1});
        inputs.add(new Object[]{param, "abc\n67890\n", new BigInteger("67890"), expectedOutput2});

        return inputs.iterator();
    }

    @DataProvider(name = "dp-testReadDoubleArray")
    public Iterator<Object[]> dpTestReadDoubleArray() {
        final List<Object[]> inputs = new ArrayList<>();
        final String param = "readDoubleArrayParam";

        final String expectedOutput1 = "Enter a size for array > 0 " + param + " (int): Enter elements double[]:" + System.lineSeparator() +
            "Element_1 => Enter a new double (double): Element_2 => Enter a new double (double): Element_3 => Enter a new double (double): ";
        final String expectedOutput2 = "Enter a size for array > 0 " + param + " (int): Invalid data format. An integer is expected." + System.lineSeparator() +
            "Enter a size for array > 0 " + param + " (int): Enter a size for array > 0 " + param + " (int): Enter elements double[]:" + System.lineSeparator() +
            "Element_1 => Enter a new double (double): Element_2 => Enter a new double (double): Element_3 => Enter a new double (double): ";

        inputs.add(new Object[]{param, "3\n1.1\n2.2\n3.3\n", new double[]{1.1, 2.2, 3.3}, expectedOutput1});
        inputs.add(new Object[]{param, "test\n-3\n3\n1.1\n2.2\n3.3\n", new double[]{1.1, 2.2, 3.3}, expectedOutput2});

        return inputs.iterator();
    }

    @DataProvider(name = "dp-testReadDouble")
    public Iterator<Object[]> testReadDouble() {
        final List<Object[]> inputs = new ArrayList<>();
        final String param = "double param";

        final String expectedOutput1 = "Enter a " + param + " (double): ";
        final String expectedOutput2 = "Enter a " + param + " (double): Invalid data format. A floating point number is expected." + System.lineSeparator() +
                "Enter a " + param + " (double): ";

        inputs.add(new Object[]{param, "7.5\n", 7.5, expectedOutput1});
        inputs.add(new Object[]{param, "invalid\n2.718\n", 2.718, expectedOutput2});

        return inputs.iterator();
    }

    @DataProvider(name = "dp-testReadString")
    public Iterator<Object[]> dpTestReadString() {
        final List<Object[]> inputs = new ArrayList<>();
        final String param = "test";

        final String expectedOutput = "Enter a " + param + ": ";

        inputs.add(new Object[]{param, "string", "string", expectedOutput});

        return inputs.iterator();
    }


    @DataProvider(name = "dp-testReadFloat")
    public Iterator<Object[]> dpTestReadFloat() {
        final List<Object[]> inputs = new ArrayList<>();
        final String param = "test param";

        final String expectedOutput1 = "Enter a " + param + " (float): ";
        final String expectedOutput2 = "Enter a " + param + " (float): " +
                "Invalid data format. A floating point number is expected." + System.lineSeparator() +
                "Enter a " + param + " (float): ";

        inputs.add(new Object[]{param, "3.5\n", 3.5F, expectedOutput1});
        inputs.add(new Object[]{param, "; 3.5\n", 3.5F, expectedOutput2});

        return inputs.iterator();
    }

    @DataProvider(name = "dp-testReadIntArray")
    public Iterator<Object[]> testReadIntArray() {
        final List<Object[]> inputs = new ArrayList<>();
        final String param = "param";

        final String expectedOutput1 = "Enter a size for array " + param + " (int): Enter elements int[]:" + System.lineSeparator() +
                "Element_1 => Enter a new int (int): Element_2 => Enter a new int (int): Element_3 => Enter a new int (int): ";
        final String expectedOutput2 = "Enter a size for array param (int): Invalid data format. An integer is expected." + System.lineSeparator() +
                        "Enter a size for array param (int): Enter a size for array > 0 " + param + " (int): Enter elements int[]:" + System.lineSeparator() +
                        "Element_1 => Enter a new int (int): Element_2 => Enter a new int (int): Element_3 => Enter a new int (int): ";

        inputs.add(new Object[]{param, "3\n1\n2\n3\n", new int[]{1, 2, 3}, expectedOutput1});
        inputs.add(new Object[]{param, "test\n-3\n3\n1\n2\n3\n", new int[]{1, 2, 3}, expectedOutput2});

        return inputs.iterator();
    }


    @DataProvider(name = "dp-testReadLong")
    public Iterator<Object[]> dpTestReadLong() {
        final List<Object[]> inputs = new ArrayList<>();
        String param = "param";

        final String expectedOutput1 = "Enter a " + param + " (long): ";
        final String expectedOutput2 = "Enter a " + param + " (long): Invalid data format. An integer (long) is expected." + System.lineSeparator() +
                "Enter a " + param + " (long): ";

        inputs.add(new Object[]{param, "1234567890123456789\n", 1234567890123456789L, expectedOutput1});
        inputs.add(new Object[]{param, "notANumber\n1234567890123456789\n", 1234567890123456789L, expectedOutput2});
  
        return inputs.iterator();
    }

    @DataProvider(name = "dp-TestReadInt")
    public Iterator<Object[]> dpTestReadInt1() {
        final List<Object[]> inputs = new ArrayList<>();
        final String param = "test int";

        final String expectedOutput1 = "Enter a " + param + " (int): ";
        final String expectedOutput2 = "Enter a " + param + " (int): Invalid data format. An integer is expected."
                + System.lineSeparator() + "Enter a " + param + " (int): " ;

        inputs.add(new Object[]{param, "25\n", 25, expectedOutput1});
        inputs.add(new Object[]{param, "invalid\n25\n", 25, expectedOutput2});

        return inputs.iterator();
    }
}
