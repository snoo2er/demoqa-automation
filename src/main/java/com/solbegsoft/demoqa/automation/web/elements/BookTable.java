package com.solbegsoft.demoqa.automation.web.elements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Link;
import ru.yandex.qatools.htmlelements.element.TypifiedElement;

import java.util.List;
import java.util.stream.Collectors;

@FindBy(xpath = "//div[contains(@class, 'ReactTable')]")
public class BookTable extends DemoQaBlock {

    @FindBy(xpath = "//div[@role='rowgroup']//a")
    List<Link> books;

    public int findNumberOfBooks() {
        return books.size();
    }

    public boolean isBookPresentInCollection(String title) {
        return isElementPresentInCollection(title, books.stream().map(TypifiedElement::getWrappedElement)
                .collect(Collectors.toList()));
    }

    public String getBookTitle(int index) {
        return getElementText(books.get(index));
    }

    public void scrollToBookAndClick(int index) {
        scrollAndClickElement(books.get(index));
    }
}
