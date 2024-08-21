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

    @DataProvider(name = "dp-testReadString")
    public Iterator<Object[]> dpTestReadString() {
        List<Object[]> inputs = new ArrayList<>();
        String param = "test";
        String expectedOutput = "Enter a " + param + ": ";

        inputs.add(new Object[]{param, "string", "string", expectedOutput});

        return inputs.iterator();
    }
}
