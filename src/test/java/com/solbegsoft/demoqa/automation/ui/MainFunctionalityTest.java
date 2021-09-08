package com.solbegsoft.demoqa.automation.ui;

import com.google.inject.Inject;
import com.solbegsoft.demoqa.automation.utilities.UserProvider;
import com.solbegsoft.demoqa.automation.web.elements.BookTable;
import com.solbegsoft.demoqa.automation.web.pages.MainPage;
import com.solbegsoft.demoqa.automation.web.steps.BookService;
import org.testng.Assert;
import org.testng.annotations.Test;

public class MainFunctionalityTest extends BaseTest {

    @Inject
    private BookService bookService;

    @Test
    public void verifyAddBook() {
        loginService.login();
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isNameLabelVisible());
        Assert.assertEquals(UserProvider.getUser().getLogin(), mainPage.getUserName());

        String addedBook = bookService.addRandomBook();
        Assert.assertTrue(bookService.checkBookInProfile(addedBook));

        loginService.logout();
        Assert.assertFalse(mainPage.isNameLabelVisible());
    }

    @Test(dependsOnMethods = "verifyAddBook")
    public void verifyRemoveBook() {
        loginService.login();
        MainPage mainPage = new MainPage();
        Assert.assertTrue(mainPage.isNameLabelVisible());
        Assert.assertEquals(UserProvider.getUser().getLogin(), mainPage.getUserName());

        String addedBook = bookService.removeRandomBook();
        Assert.assertFalse(bookService.checkBookInProfile(addedBook));

        loginService.logout();
        Assert.assertFalse(mainPage.isNameLabelVisible());
    }

    @Test
    public void verifySearchByBookTitle() {
        MainPage mainPage = new MainPage();
        mainPage.scrollToBookStoreNavigationBlock();
        mainPage.getNavigationBlock().clickBookStore();

        String bookTitle = bookService.getRandomBookTitle();
        mainPage.typeSearchRequest(bookTitle);
        BookTable bookTable = mainPage.getBookTable();
        Assert.assertEquals(bookTable.findNumberOfBooks(), 1);
        Assert.assertEquals(bookTable.getBookTitle(0), bookTitle);
    }

}
