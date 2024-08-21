package org.academy.codewars.dataproviders;

import org.testng.annotations.DataProvider;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class ConsoleScannerDataProvider {

    @DataProvider(name = "dp-testReadStringArray")
    public Iterator<Object[]> dpTestReadInt() {
        List<Object[]> inputs = new ArrayList<>();
        String expectedOutput1 = "Enter a size for array > 0 test (int): Enter elements String[]:\n" +
                "Element_1 => Enter a new string : Element_2 => Enter a new string : Element_3 => Enter a new string : ";
        String expectedOutput2 = """
                Enter a size for array > 0 test (int): Invalid data format. An integer is expected.
                Enter a size for array > 0 test (int): Enter a size for array > 0 test (int): Enter elements String[]:
                Element_1 => Enter a new string : Element_2 => Enter a new string : Element_3 => Enter a new string :\s""";

        inputs.add(new Object[]{"3\nFirst arg \nSecond arg\nThird arg\n ", new String[]{"First arg", "Second arg", "Third arg"}, expectedOutput1});
        inputs.add(new Object[]{"test\n-3\n3\nFirst arg \nSecond arg\nThird arg\n ", new String[]{"First arg", "Second arg", "Third arg"}, expectedOutput2});

        return inputs.iterator();
    }

    @DataProvider(name = "dp-testReadFloat")
    public Iterator<Object[]> dpTestReadFloat() {
        List<Object[]> inputs = new ArrayList<>();
        String param = "test param";
        String expectedOutput1 = "Enter a " + param + " (float): ";
        String expectedOutput2 = "Enter a " + param + " (float): " +
                "Invalid data format. A floating point number is expected.\n" +
                "Enter a " + param + " (float): ";
        expectedOutput2 = expectedOutput2.replaceAll("\\n|\\r\\n", System.lineSeparator());

        inputs.add(new Object[]{param, "3.5\n", 3.5F, expectedOutput1});
        inputs.add(new Object[]{param, "; 3.5\n", 3.5F, expectedOutput2});

        return inputs.iterator();
    }
}
