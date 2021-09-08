package com.solbegsoft.demoqa.automation.utilities.injector;

import com.google.inject.Guice;
import com.google.inject.Injector;

public class GuiceInjector {
    private static Injector instance;

    public static Injector getInstance() {
        if (instance == null) {
            synchronized (GuiceInjector.class) {
                if(instance == null) {
                    instance = Guice.createInjector(new StepModules());
                }
            }
        }
        return instance;
    }
}
