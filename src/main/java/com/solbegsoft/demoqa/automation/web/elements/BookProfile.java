package com.solbegsoft.demoqa.automation.web.elements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextBlock;

@FindBy(xpath = "//div[@class='profile-wrapper']")
public class BookProfile extends DemoQaBlock {

    @FindBy(xpath = "//div[@id='title-wrapper']//label[not(@id='title-label')]")
    private TextBlock title;

    @FindBy(xpath = "//button[text()='Add To Your Collection']")
    private Button addToYourCollectionButton;

    @FindBy(xpath = "//button[text()='Back To Book Store']")
    private Button backToBookStoreButton;

    public String getBookTitle() {
        return title.getText();
    }

    public void scrollAndClickAddToYourCollectionButton() {
        scrollAndClickElement(addToYourCollectionButton);
    }

    public void clickBackToBookStoreButton() {
        clickElement(backToBookStoreButton);
    }

}
