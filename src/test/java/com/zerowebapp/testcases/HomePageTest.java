package com.zerowebapp.testcases;

import com.zerowebapp.base.TestBase;
import com.zerowebapp.pages.HomePage;
import com.zerowebapp.pages.LoginPage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class HomePageTest extends TestBase {
    HomePage homePage;
    LoginPage loginPage;

    public HomePageTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        homePage = new HomePage();
    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void homepageTitleTest() {
        Assert.assertEquals(homePage.validateHomePageTitle(), "Zero - Personal Banking - Loans - Credit Cards");
    }

//     @Test
//     public void homepageLogoTest() {
//         Assert.assertTrue(homePage.validateLogo());
//     }

//     @Test
//     public void homepageSearchBoxTest() {
//         Assert.assertTrue(homePage.validateSearchBox());
//     }

//     @Test
//     public void clickSigninTest() {
//         loginPage = homePage.clickSignin();
//     }
}
