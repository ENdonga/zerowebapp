package com.zerowebapp.pages;

import com.zerowebapp.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends TestBase {
    @FindBy(id = "user_login")
    WebElement usernameInputBox;
    @FindBy(id = "user_password")
    WebElement passwordInputBox;
    @FindBy(className = "btn")
    WebElement signinButton;
    @FindBy(linkText = "Forgot your password ?")
    WebElement forgotPasswordLink;
    @FindBy(tagName = "h3")
    WebElement headingH3;

    public LoginPage() {
        PageFactory.initElements(driver, this);
    }

    public String validateLoginPageTitle() {
        return driver.getTitle();
    }

    public boolean validateHeading() {
        return headingH3.isDisplayed();
    }

    public boolean validateForgotPassLink() {
        return forgotPasswordLink.isDisplayed();
    }

    public AccountSummaryPage login(String username, String password) {
        usernameInputBox.clear();
        passwordInputBox.clear();
        usernameInputBox.sendKeys(username);
        passwordInputBox.sendKeys(password);
        signinButton.click();
        return new AccountSummaryPage();
    }

}
