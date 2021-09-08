package com.solbegsoft.demoqa.automation.web.steps;

import com.solbegsoft.demoqa.automation.model.User;
import com.solbegsoft.demoqa.automation.utilities.PropertyReader;
import com.solbegsoft.demoqa.automation.utilities.UserProvider;
import com.solbegsoft.demoqa.automation.web.driver.Sleeper;
import com.solbegsoft.demoqa.automation.web.driver.WebDriverManager;
import com.solbegsoft.demoqa.automation.web.elements.UserForm;
import com.solbegsoft.demoqa.automation.web.pages.MainPage;

import java.time.Duration;

public class LoginService {
    public void login() {
        WebDriverManager.get().openUrl(PropertyReader.getInstance().getProperty("ui_host"));
        MainPage mainPage = new MainPage();
        mainPage.waitForPageLoaded();
        mainPage.scrollToBookStoreNavigationBlock();
        mainPage.getNavigationBlock().clickLogin();
        UserForm userForm = mainPage.getUserForm();
        User user = UserProvider.getUser();
        userForm.typeLogin(user.getLogin());
        userForm.typePassword(user.getPassword());
        userForm.scrollAndClickLoginButton();
    }

    public void logout() {
        Sleeper.SYSTEM_SLEEPER.sleep(Duration.ofMillis(100));
        MainPage mainPage = new MainPage();
        mainPage.clickLogoutButton();
    }
}
