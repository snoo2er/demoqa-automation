package com.solbegsoft.demoqa.automation.utilities;

import java.util.ResourceBundle;

public class PropertyReader {
    private static PropertyReader instance;
    private static ResourceBundle resourceBundle;
    private static ResourceBundle testResourceBundle;

    private PropertyReader() {
    }

    public static PropertyReader getInstance() {
        if (instance == null) {
            instance = new PropertyReader();
        }
        return instance;
    }

    public String getProperty(String key) {
        if (resourceBundle == null) {
            resourceBundle = ResourceBundle.getBundle("config");
        }
        return resourceBundle.getString(key);
    }

    public String getTestProperty(String key) {
        if (testResourceBundle == null) {
            testResourceBundle = ResourceBundle.getBundle("test");
        }
        return testResourceBundle.getString(key);
    }
}

