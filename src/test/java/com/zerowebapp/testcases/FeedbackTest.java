package com.zerowebapp.testcases;

import com.zerowebapp.base.TestBase;
import com.zerowebapp.pages.FeedbackPage;
import com.zerowebapp.pages.HomePage;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

public class FeedbackTest extends TestBase {
    FeedbackPage feedbackPage;
    HomePage homePage;

    public FeedbackTest() {
        super();
    }

    @BeforeMethod
    public void setup() {
        initialization();
        homePage = new HomePage();
        feedbackPage = homePage.clickFeedbackLink();

    }

    @AfterMethod
    public void teardown() {
        driver.quit();
    }

    @Test
    public void feedbackPageTitleTest() {
        Assert.assertEquals(feedbackPage.validateFeedbackPageTitle(), "Zero - Contact Us");
    }

    @Test
    public void feedbackPageHeadingTest() {
        Assert.assertEquals(feedbackPage.validateHeading(), "Feedback", "Heading did not match");
    }

    @Test
    public void feedbackFormTest() {
        Assert.assertTrue(feedbackPage.validateFeedbackForm(), "Form is not displayed");
    }

}
