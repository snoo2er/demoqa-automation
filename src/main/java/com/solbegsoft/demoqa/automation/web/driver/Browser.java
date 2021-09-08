package com.solbegsoft.demoqa.automation.web.driver;

import org.openqa.selenium.Capabilities;
import org.openqa.selenium.remote.DesiredCapabilities;

import java.util.Arrays;

public enum Browser {
    CHROME("chrome", DesiredCapabilities.chrome()),
    FIREFOX("firefox", DesiredCapabilities.firefox());

    private String name;
    private Capabilities capabilities;

    Browser(String name, Capabilities capabilities) {
        this.name = name;
        this.capabilities = capabilities;
    }

    public static Browser byValue(String value) {
        return Arrays.stream(Browser.values())
                .filter(browser -> browser.getName().equalsIgnoreCase(value)).findFirst()
                .orElseThrow(() -> new IllegalStateException(String.format("Unsupported browser %s", value)));
    }

    public String getName() {
        return name;
    }

    public Capabilities getCapabilities() {
        return capabilities;
    }
}

