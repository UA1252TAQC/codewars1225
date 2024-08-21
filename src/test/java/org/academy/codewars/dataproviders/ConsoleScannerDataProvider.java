package org.academy.codewars.dataproviders;

import java.math.BigInteger;
import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConsoleScannerDataProvider {

    @DataProvider(name = "dp-testReadStringArray")
    public Iterator<Object[]> testReadStringArray() {
        List<Object[]> inputs = new ArrayList<>();
        String param = "param";
        String expectedOutput1 = "Enter a size for array > 0 " + param +  " (int): Enter elements String[]:" + System.lineSeparator() +
                "Element_1 => Enter a new string: Element_2 => Enter a new string: Element_3 => Enter a new string: ";
        String expectedOutput2 =
                "Enter a size for array > 0 " + param +  " (int): Invalid data format. An integer is expected." + System.lineSeparator() +
                "Enter a size for array > 0 " + param + " (int): Enter a size for array > 0 " + param + " (int): Enter elements String[]:" + System.lineSeparator() +
                "Element_1 => Enter a new string: Element_2 => Enter a new string: Element_3 => Enter a new string: ";

        inputs.add(new Object[]{param, "3\nFirst arg \nSecond arg\nThird arg\n ", new String[]{"First arg", "Second arg", "Third arg"}, expectedOutput1});
        inputs.add(new Object[]{param, "test\n-3\n3\nFirst arg \nSecond arg\nThird arg\n ", new String[]{"First arg", "Second arg", "Third arg"}, expectedOutput2});

        return inputs.iterator();
    }
    @DataProvider(name = "dp-testReadBigInteger")
    public Iterator<Object[]> dpTestReadBigInteger() {
        List<Object[]> inputs = new ArrayList<>();
        String param = "readBigIntegerParam";

        String expectedOutput1 = "Enter a " + param + " number: ";
        String expectedOutput2 = "Enter a " + param + " number: Invalid data format. An integer (BigInteger) is expected." + System.lineSeparator()
            + "Enter a " + param + " number: ";

        inputs.add(new Object[]{param, "12345\n", new BigInteger("12345"), expectedOutput1});
        inputs.add(new Object[]{param, "abc\n67890\n", new BigInteger("67890"), expectedOutput2});

        return inputs.iterator();
    }

    @DataProvider(name = "dp-testReadDoubleArray")
    public Iterator<Object[]> dpTestReadDoubleArray() {
        List<Object[]> inputs = new ArrayList<>();
        String param = "readDoubleArrayParam";
        String expectedOutput1 = "Enter a size for array > 0 " + param + " (int): Enter elements double[]:" + System.lineSeparator() +
            "Element_1 => Enter a new double (double): Element_2 => Enter a new double (double): Element_3 => Enter a new double (double): ";
        String expectedOutput2 = "Enter a size for array > 0 " + param + " (int): Invalid data format. An integer is expected." + System.lineSeparator() +
            "Enter a size for array > 0 " + param + " (int): Enter a size for array > 0 " + param + " (int): Enter elements double[]:" + System.lineSeparator() +
            "Element_1 => Enter a new double (double): Element_2 => Enter a new double (double): Element_3 => Enter a new double (double): ";

        inputs.add(new Object[]{param, "3\n1.1\n2.2\n3.3\n", new double[]{1.1, 2.2, 3.3}, expectedOutput1});
        inputs.add(new Object[]{param, "test\n-3\n3\n1.1\n2.2\n3.3\n", new double[]{1.1, 2.2, 3.3}, expectedOutput2});

        return inputs.iterator();
    }

    @DataProvider(name = "dp-testReadDouble")
    public Iterator<Object[]> testReadDouble() {
        List<Object[]> inputs = new ArrayList<>();
        String param = "double param";

        String expectedOutput1 = "Enter a " + param + " (double): ";
        String expectedOutput2 = "Enter a " + param + " (double): Invalid data format. A floating point number is expected." + System.lineSeparator() +
                "Enter a " + param + " (double): ";

        inputs.add(new Object[]{param, "7.5\n", 7.5, expectedOutput1});
        inputs.add(new Object[]{param, "invalid\n2.718\n", 2.718, expectedOutput2});
  
        return inputs.iterator();
    }

    @DataProvider(name = "dp-testReadString")
    public Iterator<Object[]> dpTestReadString() {
        List<Object[]> inputs = new ArrayList<>();
        String param = "test";
        String expectedOutput = "Enter a " + param + ": ";

        inputs.add(new Object[]{param, "string", "string", expectedOutput});

        return inputs.iterator();
    }


    @DataProvider(name = "dp-testReadFloat")
    public Iterator<Object[]> dpTestReadFloat() {
        List<Object[]> inputs = new ArrayList<>();
        String param = "test param";
        String expectedOutput1 = "Enter a " + param + " (float): ";
        String expectedOutput2 = "Enter a " + param + " (float): " +
                "Invalid data format. A floating point number is expected." + System.lineSeparator() +
                "Enter a " + param + " (float): ";

        inputs.add(new Object[]{param, "3.5\n", 3.5F, expectedOutput1});
        inputs.add(new Object[]{param, "; 3.5\n", 3.5F, expectedOutput2});

        return inputs.iterator();
    }

    @DataProvider(name = "dp-testReadIntArray")
    public Iterator<Object[]> testReadIntArray() {
        List<Object[]> inputs = new ArrayList<>();
        String param = "param";

        String expectedOutput1 = "Enter a size for array " + param + " (int): Enter elements int[]:" + System.lineSeparator() +
                "Element_1 => Enter a new int (int): Element_2 => Enter a new int (int): Element_3 => Enter a new int (int): ";

        String expectedOutput2 =
                "Enter a size for array param (int): Invalid data format. An integer is expected." + System.lineSeparator() +
                        "Enter a size for array param (int): Enter a size for array > 0 " + param + " (int): Enter elements int[]:" + System.lineSeparator() +
                        "Element_1 => Enter a new int (int): Element_2 => Enter a new int (int): Element_3 => Enter a new int (int): ";

        inputs.add(new Object[]{param, "3\n1\n2\n3\n", new int[]{1, 2, 3}, expectedOutput1});
        inputs.add(new Object[]{param, "test\n-3\n3\n1\n2\n3\n", new int[]{1, 2, 3}, expectedOutput2});

        return inputs.iterator();
    }

}
