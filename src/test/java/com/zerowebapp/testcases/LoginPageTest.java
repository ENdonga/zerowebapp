package com.zerowebapp.testcases;

import com.zerowebapp.base.TestBase;
import com.zerowebapp.pages.AccountSummaryPage;
import com.zerowebapp.pages.HomePage;
import com.zerowebapp.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class LoginPageTest extends TestBase {
    LoginPage loginPage;
    HomePage homePage;
    AccountSummaryPage accountSummaryPage;

    public LoginPageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        homePage = new HomePage();
        loginPage = homePage.clickSignin();

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void loginPageTitleTest() {
        Assert.assertEquals(loginPage.validateLoginPageTitle(), "Zero - Log in");
    }

    @Test
    public void loginPageHeadingTest() {
        Assert.assertTrue(loginPage.validateHeading());
    }

    @Test
    public void loginPageForgotPasswordTest() {
        Assert.assertTrue(loginPage.validateForgotPassLink());
    }

    @Test
    public void loginTest() {
        accountSummaryPage = loginPage.login(properties.getProperty("username"), properties.getProperty("password"));
    }
}
