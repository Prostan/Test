package com.gmail.tests;

import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.Test;
import pageObjects.HomePage;
import pageObjects.LoginPage;
import pageObjects.SendMessageBox;
import pageObjects.SentMailPage;

import java.util.logging.Logger;

public class HomePageTest extends BaseTestCase {

    private LoginPage loginPage = PageFactory.initElements(getWebDriver(), LoginPage.class);
    private HomePage homePage;
    private SendMessageBox sendMessageBox;
    private SentMailPage sentMailPage;

    private static final Logger logger = Logger.getLogger(LogingPageTest.class.getName());

    @Test
    public void testSendMessage() throws Exception {

        loginPage.get();                                    // Load login page
        homePage = loginPage.loginAs(admin);                // Login as admin
        homePage.get();                                     // Check if page loaded properly

        sendMessageBox = homePage.openSendMessagBox();      // Open sendMessage box
        sendMessageBox.get();
        sendMessageBox.sendMail();                          // Send message

        sentMailPage = homePage.openSentMailPage();
        sentMailPage.get();


    }
}
