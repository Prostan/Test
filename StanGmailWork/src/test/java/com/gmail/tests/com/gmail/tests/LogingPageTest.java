package com.gmail.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SendMessageBox;
import pageObjects.UserProfileBox;

import java.util.logging.Logger;

public class LogingPageTest extends BaseTestCase {

    private LoginPage loginPage = PageFactory.initElements(getWebDriver(), LoginPage.class);
    private HomePage homePage;
    private SendMessageBox sendMessageBox;
    private UserProfileBox userProfileBox;


    private static final Logger logger = Logger.getLogger(LogingPageTest.class.getName());

    @Test(priority = 1)
    public void testNotSuccessLogin() throws Exception {

        loginPage.get();                            // Load login page
        loginPage.badloginAs(badUser);              // Login as admin
        loginPage.get();                             // Check if page loaded properly

        Assert.assertEquals(loginPage.errorMessage.getText(), "The email or password you entered is incorrect. ?");
    }


    @Test(priority = 2)
    public void testSuccessLogin() throws Exception {

        loginPage.get();                            // Load login page
        homePage = loginPage.loginAs(admin);        // Login as admin
        homePage.get();                             // Check if page loaded properly

        Assert.assertTrue(homePage.isLoggedIn());   // Assert home page laded

    }

    @Test(priority = 3)
    public void testUserProfile() throws Exception {

        userProfileBox = homePage.openUserProfileBox();
        userProfileBox.get();                           // Assert home page loaded

        Assert.assertEquals(userProfileBox.getUserName(), "Stan Test");
    }

    @Test(priority = 4)
    public void testLogout() throws Exception {

        loginPage = userProfileBox.logOut();                // Logout
        Assert.assertTrue(loginPage.isLoggedOut());         // Assert that we are logged out

    }

}
