package com.gmail.tests;

import org.apache.logging.log4j.LogManager;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SendMessageBox;
import pageObjects.UserProfileBox;

public class LogingPageTest extends TestBase {

    private LoginPage loginPage;
    private HomePage homePage;
    private UserProfileBox userProfileBox;


    private static final org.apache.logging.log4j.Logger LOG = LogManager.getLogger(LoginPage.class);

    @BeforeMethod
    public void initPageObjects() {
        loginPage = PageFactory.initElements(driver, LoginPage.class);
    }


    @Test(priority = 1)
    public void testNotSuccessLogin() throws Exception {

        LOG.info("testNotSuccessLogin in progress...");
        loginPage.get();                            // Load login page
        loginPage.badloginAs(badUser);              // Login as admin
        loginPage.get();                             // Check if page loaded properly

        Assert.assertEquals(loginPage.errorMessage.getText(), "The email or password you entered is incorrect. ?");
    }


    @Test(priority = 2)
    public void testSuccessLogin() throws Exception {

        LOG.info("testSuccessLogin in progress...");
        loginPage.get();                            // Load login page
        homePage = loginPage.loginAs(admin);        // Login as admin
        homePage.get();                             // Check if page loaded properly

        Assert.assertTrue(homePage.isLoggedIn());   // Assert home page laded

    }

    @Test(priority = 3)
    public void testUserProfile() throws Exception {

        LOG.info("testUserProfile in progress...");
        userProfileBox = homePage.openUserProfileBox();
        userProfileBox.get();                           // Assert home page loaded

        Assert.assertEquals(userProfileBox.getUserName(), "Stan Test");
    }

    @Test(priority = 4)
    public void testLogout() throws Exception {

        LOG.info("testLogout in progress...");
        loginPage = userProfileBox.logOut();                // Logout
        Assert.assertTrue(loginPage.isLoggedOut());         // Assert that we are logged out

    }

}