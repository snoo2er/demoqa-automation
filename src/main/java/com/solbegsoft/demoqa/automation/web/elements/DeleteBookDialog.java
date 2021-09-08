package com.solbegsoft.demoqa.automation.web.elements;

import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.element.Button;

@FindBy(xpath = "//div[@class='modal-content']")
public class DeleteBookDialog extends DemoQaBlock {

    @FindBy(xpath = "//button[@id='closeSmallModal-ok']")
    private Button okButton;

    public void clickOkButton() {
        clickElement(okButton);
    }

}