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

}
