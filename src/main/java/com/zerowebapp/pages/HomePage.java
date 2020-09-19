package com.zerowebapp.pages;

import com.zerowebapp.base.TestBase;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends TestBase {
    @FindBy(id = "searchTerm")
    WebElement searchInput;
    @FindBy(id = "signin_button")
    WebElement signinBtn;
    @FindBy(id = "online-banking")
    WebElement moreServicesBtn;
    @FindBy(className = "brand")
    WebElement logo;

    // Initializing page objects
    public HomePage(){
        PageFactory.initElements(driver, this);
    }

    public String validateHomePageTitle(){
        return driver.getTitle();
    }

    public boolean validateLogo(){
        return logo.isDisplayed();
    }

    public boolean validateSearchBox(){
        return searchInput.isDisplayed();
    }

    public LoginPage clickSignin(){
        signinBtn.click();
        return new LoginPage();
    }
}
