package com.solbegsoft.demoqa.automation.web.elements;

import com.solbegsoft.demoqa.automation.web.driver.WebDriverManager;
import lombok.extern.slf4j.Slf4j;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebElement;
import ru.yandex.qatools.htmlelements.element.HtmlElement;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Slf4j
public class DemoQaBlock extends HtmlElement {

    public void clickElement(TypifiedElement element) {
        element.click();
        log.info("Click on '{}'", element.getName());
    }

    public void scrollIntoViewJs(TypifiedElement element) {
        ((JavascriptExecutor) WebDriverManager.getDriver())
                .executeScript("arguments[0].scrollIntoView(true);", element);
        log.info("Scrolling to'{}'", element.getName());
    }

    public void scrollAndClickElement(TypifiedElement element) {
        scrollIntoViewJs(element);
        element.click();
        log.info("Click on '{}'", element.getName());
    }

    public void typeIntoField(TypifiedElement element, String text) {
        element.sendKeys(text);
        log.info("Type '{}' into '{}'", text, element.getName());
    }

    public boolean isElementPresentInCollection(String elementText, Collection<WebElement> elements) {
        boolean isElementPresentInCollection = elements.stream()
                .anyMatch(element -> element.getText().equals(elementText));
        log.info("Is element '{}' present? '{}'", elementText, isElementPresentInCollection);
        return isElementPresentInCollection;
    }

    public String getElementText(TypifiedElement element) {
        String elementText = element.getText();
        log.info("'{}' text is '{}'", element.getName(), elementText);
        return elementText;
    }

}
