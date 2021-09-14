package com.solbegsoft.demoqa.automation.web.driver;

import com.solbegsoft.demoqa.automation.utilities.PropertyReader;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.By;
import org.openqa.selenium.TimeoutException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
import java.util.StringJoiner;
import java.util.concurrent.TimeUnit;

@Slf4j
public abstract class AbstractWebDriver {
    private static final long DEFAULT_IMPLICITLY_WAIT_TIMEOUT = 5;
    private static final long DEFAULT_PAGE_LOAD_TIMEOUT = 60;
    private static final long DEFAULT_SET_SCRIPT_TIMEOUT = 10;

    protected WebDriver driver;
    protected Browser browser;

    public abstract WebDriver getDriver();

    public Browser getBrowser() {
        setDriverEnvVariables();
        
        if (browser == null) {
            String browserType = PropertyReader.getInstance().getProperty("browser");
            try {
                browser = Browser.byValue(browserType);
            } catch (IllegalStateException e) {
                StringJoiner joiner = new StringJoiner(", ");
                for (Browser browser : Browser.values()) {
                    joiner.add(browser.getName());
                }
                throw new IllegalStateException(String.format("BrowserType '%s' is incorrect. Available browsers are" +
                        ": '%s'", browserType, joiner.toString()));
            }
        }
        return browser;
    }

    public void openUrl(String url) {
        try {
            driver.get(url);
            log.info(url + " - is opened");
        } catch (TimeoutException e) {
            log.error(url + " - URL can not be opened", e);
        }
    }

    public WebElement getElementByXpath(String xpath) {
        return driver.findElement(By.xpath(xpath));
    }

    void setTimeouts(WebDriver driver) {
        driver.manage().timeouts()
                .implicitlyWait(DEFAULT_IMPLICITLY_WAIT_TIMEOUT, TimeUnit.SECONDS)
                .pageLoadTimeout(DEFAULT_PAGE_LOAD_TIMEOUT, TimeUnit.SECONDS)
                .setScriptTimeout(DEFAULT_SET_SCRIPT_TIMEOUT, TimeUnit.SECONDS);
    }
    
    private void setDriverEnvVariables(){
        String driversLocation = "src/test/resources/drivers/";
        System.setProperty("webdriver.gecko.driver", driversLocation+"geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", driversLocation+"chromedriver.exe");
    }

    void destroyDriver() {
        driver = null;
    }
}

