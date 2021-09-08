package com.solbegsoft.demoqa.automation.web.pages;

import com.solbegsoft.demoqa.automation.web.driver.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementDecorator;
import ru.yandex.qatools.htmlelements.loader.decorator.HtmlElementLocatorFactory;

@Slf4j
public class BasePage extends AbstractPage {

    public BasePage() {
        PageFactory.initElements(
                new HtmlElementDecorator(new HtmlElementLocatorFactory(WebDriverManager.getDriver())), this);
    }

    public boolean isElementVisible(TypifiedElement element) {
        boolean isElementVisible = element.exists();
        logElementVisibility(element.getName(), isElementVisible);
        return isElementVisible;
    }

    private void logElementVisibility(String name, boolean isVisible) {
        if (isVisible) {
            log.info("'{}' is visible", name);
        } else {
            log.info("'{}' is not visible", name);
        }
    }

    public void clickElement(TypifiedElement element) {
        element.click();
        log.info("Click on '{}'", element.getName());
    }

    public WebElement waitForElementVisible(WebElement element) {
        WebDriverWait wait = new WebDriverWait(driver, 15, 1000);
        wait.until(ExpectedConditions.not(ExpectedConditions.stalenessOf(element)));
        return wait.until(ExpectedConditions.visibilityOf(element));
    }

    public String getElementText(TypifiedElement element) {
        String elementText = element.getText();
        log.info("'{}' text is '{}'", element.getName(), elementText);
        return elementText;
    }

    public void scrollIntoViewJs(HtmlElement element) {
        ((JavascriptExecutor) driver).executeScript("arguments[0].scrollIntoView(true);", element);
        log.info("Scrolling to'{}'", element.getName());
    }

    public void typeIntoField(TypifiedElement element, String text) {
        element.sendKeys(text);
        log.info("Type '{}' into '{}'", text, element.getName());
    }

}

