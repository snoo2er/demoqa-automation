package com.solbegsoft.demoqa.automation.core.runner;

import org.testng.ITestNGListener;
import org.testng.TestNG;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TestRunner {
    private List<Class<? extends ITestNGListener>> listeners = new ArrayList<>();

    public TestRunner() {
    }

    public static void main(String[] args) {
        TestNG testNG = new TestNG();
        testNG.setUseDefaultListeners(true);
        testNG.setTestSuites(Collections.singletonList(args[0]));

        testNG.setSuiteThreadPoolSize(1);
        testNG.run();
        System.exit(0);
    }
}
