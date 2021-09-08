package com.solbegsoft.demoqa.automation.web.driver;

import java.time.Duration;

public interface Sleeper {

    Sleeper SYSTEM_SLEEPER = duration -> {
        try {
            Thread.sleep(duration.toMillis());
        } catch (InterruptedException e) {
            throw new RuntimeException(e.getMessage(), e);
        }
    };

    void sleep(Duration duration);

}