package com.gmail.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SendMessageBox;

import java.lang.Exception;
import java.util.logging.Logger;

public class LogingPageTest extends BaseTestCase {

    private LoginPage loginPage = PageFactory.initElements(getWebDriver(), LoginPage.class);
    private HomePage homePage;
    private SendMessageBox sendMessageBox;


    private static final Logger logger = Logger.getLogger(LogingPageTest.class.getName());

    @Test(enabled = true)
    public void testLogin() throws Exception {

        loginPage.get();                            // Load login page
        homePage = loginPage.loginAs(admin);        // Login as admin
        homePage.get();                             // Check if page loaded properly

        Assert.assertTrue(homePage.isLoggedIn());   // Assert home page laded

        loginPage = homePage.logOut();              // Logout
        Assert.assertTrue(loginPage.isLoggedOut()); // Assert that we are logged out
    }

}
