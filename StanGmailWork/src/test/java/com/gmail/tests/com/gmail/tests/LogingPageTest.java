package com.gmail.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import java.lang.Exception;
import java.util.logging.Logger;

public class LogingPageTest extends BaseTestCase {

    private LoginPage loginPage = PageFactory.initElements(getWebDriver(), LoginPage.class);
    private HomePage homePage;
    private static final Logger logger = Logger.getLogger(LogingPageTest.class.getName());

    @Test

    public void testLogin() throws Exception {

        logger.info("login page load");
        loginPage.get();
        logger.info("login ad admin leads to the home page");
        homePage = loginPage.loginAs(admin);
        logger.info("assert");
        Assert.assertTrue(homePage.isLoggedIn());
        loginPage = homePage.logOut();
        Assert.assertTrue(loginPage.isLoggedOut());
    }
}
