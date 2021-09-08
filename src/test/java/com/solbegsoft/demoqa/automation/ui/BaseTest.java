package com.solbegsoft.demoqa.automation.ui;

import com.google.inject.Inject;
import com.solbegsoft.demoqa.automation.utilities.injector.GuiceInjector;
import com.solbegsoft.demoqa.automation.web.driver.WebDriverManager;
import com.solbegsoft.demoqa.automation.web.steps.ApiService;
import com.solbegsoft.demoqa.automation.web.steps.LoginService;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;

public class BaseTest {

    @Inject
    public LoginService loginService;

    @Inject
    public ApiService apiService;

    @BeforeClass
    public void setup() {
        WebDriverManager.get().getDriver();
        GuiceInjector.getInstance().injectMembers(this);
        apiService.registerUser();
    }

    @AfterClass()
    protected void driverClear() {
        WebDriverManager.destroyDriver();
        apiService.deleteUser();
    }

}
