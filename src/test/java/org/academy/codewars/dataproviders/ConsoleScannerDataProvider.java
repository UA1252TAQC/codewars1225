package org.academy.codewars.dataproviders;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConsoleScannerDataProvider {

    @DataProvider(name = "dp-testReadStringArray")
    public Iterator<Object[]> testReadStringArray() {
        List<Object[]> inputs = new ArrayList<>();
        String param = "param";
        String expectedOutput1 = "Enter a size for array > 0 " + param + " (int): Enter elements String[]:\n" +
                "Element_1 => Enter a new string : Element_2 => Enter a new string : Element_3 => Enter a new string : ";
        String expectedOutput2 = "Enter a size for array > 0 " + param + " (int): Invalid data format. An integer is expected.\n" +
                "Enter a size for array > 0 " + param + " (int): Enter a size for array > 0 " + param + " (int): Enter elements String[]:\n" +
                "Element_1 => Enter a new string : Element_2 => Enter a new string : Element_3 => Enter a new string : ";

        inputs.add(new Object[]{param, "3\nFirst arg \nSecond arg\nThird arg\n ", new String[]{"First arg", "Second arg", "Third arg"}, expectedOutput1});
        inputs.add(new Object[]{param, "test\n-3\n3\nFirst arg \nSecond arg\nThird arg\n ", new String[]{"First arg", "Second arg", "Third arg"}, expectedOutput2});

        return inputs.iterator();
    }

    @DataProvider(name = "dp-testReadDoubleValidData")
    public Iterator<Object[]> testReadDoubleValidData() {
        List<Object[]> inputs = new ArrayList<>();
        String param = "double param";
        String testInput1 = "7.5\n";
        double expectedValue1 = 7.5;
        String expectedOutput1 = "Enter a " + param + " (double): ";
        String testInput2 = "123.456\n";
        double expectedValue2 = 123.456;
        String expectedOutput2 = "Enter a " + param + " (double): ";

        inputs.add(new Object[]{param, testInput1, expectedValue1, expectedOutput1});
        inputs.add(new Object[]{param, testInput2, expectedValue2, expectedOutput2});

        return inputs.iterator();
    }

    @DataProvider(name = "dp-testReadDouble")
    public Iterator<Object[]> testReadDouble() {
        List<Object[]> inputs = new ArrayList<>();
        String param = "double param";
        String expectedOutput = "Enter a " + param + " (double): ";

        inputs.add(new Object[]{param, "7.5" + System.lineSeparator(), 7.5, expectedOutput});
        inputs.add(new Object[]{param, "123.456" + System.lineSeparator(), 123.456, expectedOutput});
        inputs.add(new Object[]{param, "invalid" + System.lineSeparator() + "2.718" + System.lineSeparator(), 2.718,
                expectedOutput + "Invalid data format. A floating point number is expected." + System.lineSeparator() + expectedOutput});
        inputs.add(new Object[]{param, "wrong" + System.lineSeparator() + "3.14159" + System.lineSeparator(), 3.14159,
                expectedOutput + "Invalid data format. A floating point number is expected." + System.lineSeparator() + expectedOutput});

        return inputs.iterator();
    }

}
