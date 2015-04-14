package com.gmail.tests;

import data.UserData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;

/**
 * Created by Stan on 3/24/2015.
 */
public class BaseTestCase {
    protected static WebDriver driver;

    public UserData admin = new UserData("StanWebTest", "TestTest");
    public UserData badUser = new UserData("badUser", "badPassweord");

    protected WebDriver getWebDriver(){
        if(driver == null){
            driver = new FirefoxDriver();
            Reporter.log("User is Logged out and Application is closed | ");
        }
        return driver;
    }

    @AfterTest
    public void tearDown() throws Exception{
        driver.quit();
        Reporter.log("User is Logged out and Application is closed | ");
    }
}
