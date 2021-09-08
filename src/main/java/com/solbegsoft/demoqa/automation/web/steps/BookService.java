package com.solbegsoft.demoqa.automation.web.steps;

import com.solbegsoft.demoqa.automation.web.elements.BookProfile;
import com.solbegsoft.demoqa.automation.web.elements.BookTable;
import com.solbegsoft.demoqa.automation.web.elements.UserBookTable;
import com.solbegsoft.demoqa.automation.web.pages.MainPage;

import java.util.Random;

public class BookService {
    public String addRandomBook() {
        MainPage mainPage = new MainPage();
        mainPage.scrollToBookStoreNavigationBlock();
        mainPage.getNavigationBlock().clickBookStore();
        BookTable bookTable = mainPage.getBookTable();
        int index = new Random().nextInt(bookTable.findNumberOfBooks());
        bookTable.scrollToBookAndClick(index);
        BookProfile bookProfile = mainPage.getBookProfile();
        String bookTitle = bookProfile.getBookTitle();
        bookProfile.scrollAndClickAddToYourCollectionButton();
        mainPage.acceptAlert();
        bookProfile.clickBackToBookStoreButton();
        return bookTitle;
    }

    public boolean checkBookInProfile(String bookTitle) {
        MainPage mainPage = new MainPage();
        mainPage.scrollToBookStoreNavigationBlock();
        mainPage.getNavigationBlock().clickProfile();
        return mainPage.getUserBookTable().isBookPresentInCollection(bookTitle);
    }

    public String removeRandomBook() {
        MainPage mainPage = new MainPage();
        UserBookTable userBookTable = mainPage.getUserBookTable();
        int index = new Random().nextInt(userBookTable.findNumberOfBooks());
        String bookTitle = userBookTable.getBookTitle(index);
        userBookTable.scrollAndClickDeleteButton(index);
        mainPage.getDeleteBookDialog().clickOkButton();
        mainPage.acceptAlert();
        return bookTitle;
    }

    public String getRandomBookTitle() {
        UserBookTable userBookTable = new MainPage().getUserBookTable();
        int index = new Random().nextInt(new MainPage().getUserBookTable().findNumberOfBooks());
        return userBookTable.getBookTitle(index);
    }

}
