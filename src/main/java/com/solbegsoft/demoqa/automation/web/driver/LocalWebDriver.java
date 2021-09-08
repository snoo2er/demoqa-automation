package com.solbegsoft.demoqa.automation.web.driver;

import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;

public class LocalWebDriver extends AbstractWebDriver {

    @Override
    public WebDriver getDriver() {
        if (driver == null) {
            Browser browser = getBrowser();
            if (browser.equals(Browser.CHROME)) {
                driver = new ChromeDriver(new ChromeOptions());
            } else if (browser.equals(Browser.FIREFOX)) {
                driver = new FirefoxDriver(new FirefoxOptions());
            } else {
                throw new IllegalArgumentException("Browser is not supported " + browser);
            }
            setTimeouts(driver);
            driver.manage().window().setSize(new Dimension(1600, 900));
        }
        return driver;
    }

}
