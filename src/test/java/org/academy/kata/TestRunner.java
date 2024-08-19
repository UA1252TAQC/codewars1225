package org.academy.kata;

import org.testng.annotations.BeforeClass;

import java.util.Locale;

public class TestRunner {
    @BeforeClass
    public void beforeClass() {
        Locale.setDefault(Locale.US);
    }
}
