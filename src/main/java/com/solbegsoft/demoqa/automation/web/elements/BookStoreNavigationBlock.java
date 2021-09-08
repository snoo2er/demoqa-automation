package com.solbegsoft.demoqa.automation.web.elements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;

@FindBy(xpath = "//div[@class='element-group'][.//div[text()='Book Store Application']]")
public class BookStoreNavigationBlock extends DemoQaBlock {

    @FindBy(xpath = "//li[.//span[@class='text'][text()='Login']]")
    private Button login;

    @FindBy(xpath = "//li[.//span[@class='text'][text()='Book Store']]")
    private Button bookStore;

    @FindBy(xpath = "//li[.//span[@class='text'][text()='Profile']]")
    private Button profile;

    public void clickLogin() {
        clickElement(login);
    }

    public void clickBookStore() {
        clickElement(bookStore);
    }

    public void clickProfile() {
        clickElement(profile);
    }

}
