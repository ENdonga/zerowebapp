package com.zerowebapp.pages;

import com.zerowebapp.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class FeedbackPage extends TestBase {
    @FindBy(id = "feedback-title")
    WebElement headingH3;
    @FindBy(className = "form-inputs")
    WebElement form;

    public FeedbackPage() {
        PageFactory.initElements(driver, this);
    }

    public String validateFeedbackPageTitle() {
        return driver.getTitle();
    }

    public String validateHeading() {
        return headingH3.getText();
    }

    public boolean validateFeedbackForm() {
        return form.isDisplayed();
    }
}
