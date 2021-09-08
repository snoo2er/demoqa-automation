package com.solbegsoft.demoqa.automation.web.elements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.TextInput;

@FindBy(id = "userForm")
public class UserForm extends DemoQaBlock {

    @FindBy(id = "login")
    private Button loginButton;

    @FindBy(id = "userName")
    private TextInput loginField;

    @FindBy(id = "password")
    private TextInput passwordField;

    public void typeLogin(String login) {
        typeIntoField(loginField, login);
    }

    public void typePassword(String password) {
        typeIntoField(passwordField, password);
    }

    public void clickLoginButton() {
        clickElement(loginButton);
    }

    public void scrollAndClickLoginButton() {
        scrollAndClickElement(loginButton);
    }
}
