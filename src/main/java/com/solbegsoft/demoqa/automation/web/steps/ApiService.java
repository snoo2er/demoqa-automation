package com.solbegsoft.demoqa.automation.web.steps;

import com.google.inject.Inject;
import com.solbegsoft.demoqa.automation.model.User;
import com.solbegsoft.demoqa.automation.model.UserResponse;
import com.solbegsoft.demoqa.automation.rest.restassured.DemoQaService;
import com.solbegsoft.demoqa.automation.utilities.UserProvider;

public class ApiService {

    @Inject
    private DemoQaService demoQaService;

    private User user;
    private UserResponse userResponse;

    public void registerUser() {
        user = UserProvider.getUser();
        userResponse = demoQaService.registerUser(user);

    }

    public void deleteUser() {
        demoQaService.deleteUser(userResponse.getUserId(), demoQaService.generateToken(user));
    }

}
