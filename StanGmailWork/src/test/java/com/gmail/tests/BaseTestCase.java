package com.gmail.tests;

import data.UserData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Reporter;
import org.testng.annotations.AfterTest;


public class BaseTestCase {

    private static final Logger LOG = LogManager.getLogger(BaseTestCase.class);
    protected static WebDriver driver;

    public UserData admin = new UserData("StanWebTest", "TestTest");
    public UserData badUser = new UserData("badUser", "badPassweord");

    protected WebDriver getWebDriver(){
        if(driver == null){
            driver = new FirefoxDriver();
            LOG.info(" ------------------------------------- New FireFox driver instantiated ----------------------------");
        }
        return driver;
    }

    @AfterTest
    public void tearDown() throws Exception{
        driver.quit();
        LOG.info(" --------------------------- WebBrowser is closed!!!! ---------------------------------------");
    }
}
