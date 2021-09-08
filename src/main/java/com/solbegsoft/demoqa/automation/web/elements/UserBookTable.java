package com.solbegsoft.demoqa.automation.web.elements;

import com.solbegsoft.demoqa.automation.web.driver.WebDriverManager;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;

import java.util.List;

public class UserBookTable extends BookTable {

    @FindBy(xpath = "//div[@role='rowgroup']//span[@id='delete-record-undefined']")
    List<Button> bookDeleteButtons;

    public void removeBook(String title) {
        WebDriverManager.get().getElementByXpath("//div[@role='rowgroup'][.//a[text()='" + title
                + "']]//span[@id='delete-record-undefined']").click();
    }

    public void scrollAndClickDeleteButton(int index) {
        scrollAndClickElement(bookDeleteButtons.get(index));
    }
}
