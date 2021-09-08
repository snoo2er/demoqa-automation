package com.solbegsoft.demoqa.automation.web.pages;

import com.solbegsoft.demoqa.automation.web.driver.Sleeper;
import com.solbegsoft.demoqa.automation.web.elements.*;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.ui.ExpectedConditions;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextBlock;
import ru.yandex.qatools.htmlelements.element.TextInput;

import java.time.Duration;

public class MainPage extends BasePage {

    @FindBy(id = "userName-value")
    private TextBlock nameLabel;

    @FindBy(id = "gotoStore")
    private Button goToBookStoreButton;

    @FindBy(xpath = "//button[@id='submit'][text()='Log out']")
    private Button logoutButton;

    @FindBy(xpath = "//input[@id='searchBox']")
    private TextInput searchInput;

    private BookStoreNavigationBlock navigationBlock;
    private UserForm userForm;
    private BookTable bookTable;
    private BookProfile bookProfile;
    private UserBookTable userBookTable;
    private DeleteBookDialog deleteBookDialog;

    public BookStoreNavigationBlock getNavigationBlock() {
        return navigationBlock;
    }

    public UserForm getUserForm() {
        return userForm;
    }

    public BookTable getBookTable() {
        return bookTable;
    }

    public BookProfile getBookProfile() {
        return bookProfile;
    }

    public DeleteBookDialog getDeleteBookDialog() {
        return deleteBookDialog;
    }

    public void clickLogoutButton() {
        clickElement(logoutButton);
    }

    public UserBookTable getUserBookTable() {
        return userBookTable;
    }

    public boolean isNameLabelVisible() {
        return isElementVisible(nameLabel);
    }

    public String getUserName() {
        return getElementText(nameLabel);
    }

    public void scrollToBookStoreNavigationBlock() {
        scrollIntoViewJs(navigationBlock);
    }

    public void acceptAlert() {
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofMillis(100));
        if (ExpectedConditions.alertIsPresent().apply(driver) != null) {
            driver.switchTo().alert().accept();
        }
    }

    public void typeSearchRequest(String request) {
        typeIntoField(searchInput, request);
    }

}
