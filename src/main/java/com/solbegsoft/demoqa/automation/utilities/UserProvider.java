package com.solbegsoft.demoqa.automation.utilities;

import com.solbegsoft.demoqa.automation.model.User;

import java.util.Random;

public class UserProvider {
    private static final boolean USE_DEFAULT_USER =
            Boolean.parseBoolean(System.getenv(Properties.USE_DEFAULT_USER.getValue()));

    private static User user;

    public static User getUser() {
        if (user == null) {
            if (USE_DEFAULT_USER) {
                user = new User(PropertyReader.getInstance().getTestProperty("user_login"),
                        PropertyReader.getInstance().getTestProperty("user_password"));
            } else {
                user = new User("testUser" + new Random().nextInt(10000),
                        "Qa1#" + new Random().nextInt(10000));
            }
        }
        return user;
    }

}
