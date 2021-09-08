package com.solbegsoft.demoqa.automation.utilities.injector;

import com.google.inject.AbstractModule;
import com.google.inject.Scopes;
import com.solbegsoft.demoqa.automation.web.steps.ApiService;
import com.solbegsoft.demoqa.automation.web.steps.BookService;
import com.solbegsoft.demoqa.automation.web.steps.LoginService;

public class StepModules extends AbstractModule {

    @Override
    protected void configure() {
        bind(ApiService.class).in(Scopes.SINGLETON);
        bind(LoginService.class).in(Scopes.SINGLETON);
        bind(BookService.class).in(Scopes.SINGLETON);
    }

}
