package com.gmail.tests;

import data.UserData;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterTest;

/**
 * Created by Stan on 3/24/2015.
 */
public class BaseTestCase {
    protected static WebDriver driver;

    public UserData admin = new UserData("StanWebTest", "TestTest");

    protected WebDriver getWebDriver(){
        if(driver == null){
            driver = new FirefoxDriver();

        }
        return driver;
    }

    @AfterTest
    public void tearDown() throws Exception{
        driver.quit();
    }
}
