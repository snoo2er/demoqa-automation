package com.solbegsoft.demoqa.automation.web.pages;

import com.google.common.base.Function;
import com.solbegsoft.demoqa.automation.web.driver.WebDriverManager;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.FluentWait;

import java.time.Duration;

public class AbstractPage {

    private static final int DEFAULT_TIMEOUT = 50;

    WebDriver driver = WebDriverManager.getDriver();

    public void waitForPageLoaded() {
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(DEFAULT_TIMEOUT))
                .pollingEvery(Duration.ofSeconds(1))
                .until((Function<WebDriver, Boolean>) input -> ((JavascriptExecutor) driver)
                        .executeScript("return document.readyState").equals("complete"));
    }

    public String waitForUrlChanged(String url) {
        new FluentWait<>(driver)
                .withTimeout(Duration.ofSeconds(DEFAULT_TIMEOUT))
                .pollingEvery(Duration.ofSeconds(1))
                .until((Function<WebDriver, Boolean>) input -> !driver.getCurrentUrl().equals(url));
        return driver.getCurrentUrl();
    }

}
