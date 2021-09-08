package com.solbegsoft.demoqa.automation.web.driver;

import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebDriverException;

@Slf4j
public class WebDriverManager {
    private static ThreadLocal<AbstractWebDriver> driverThreadLocal = new ThreadLocal<>();

    public static AbstractWebDriver get() {
        if (driverThreadLocal.get() == null) {
            driverThreadLocal.set(new LocalWebDriver());
            driverThreadLocal.get().getDriver();
        }
        return driverThreadLocal.get();
    }

    public static WebDriver getDriver() {
        return get().getDriver();
    }

    public static void destroyDriver() {
        AbstractWebDriver abstractDriver = driverThreadLocal.get();
        if (abstractDriver == null) {
            log.debug("AbstractWebDriver instance is null");
            return;
        }
        WebDriver driver = abstractDriver.getDriver();
        try {
            if (driver != null) {
                driver.manage().deleteAllCookies();
                driver.quit();
            }
        } catch (WebDriverException e) {
            log.error("WebDriver can not be closed", e);
        } finally {
            abstractDriver.destroyDriver();
            driverThreadLocal.remove();
            log.info("WebDriver is closed");
        }
    }
}

