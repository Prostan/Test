package com.gmail.tests;

import data.UserData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.Capabilities;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import util.PropertyLoader;
import util.WebDriverFactory;


import java.io.IOException;

/**
 * Base class for TestNG-based test classes
 */


public class TestBase {

    private static final Logger LOG = LogManager.getLogger(TestBase.class);

    protected static String gridHubUrl;
    protected static String baseUrl;
    protected static Capabilities capabilities;


    protected WebDriver driver;

    public UserData admin = new UserData("StanWebTest", "TestTest");
    public UserData badUser = new UserData("badUser", "badPassweord");


    @BeforeSuite
    public void initTestSuite() throws IOException {
        baseUrl = PropertyLoader.loadProperty("site.url");
        gridHubUrl = PropertyLoader.loadProperty("grid.url");
        if ("".equals(gridHubUrl)) {
            gridHubUrl = null;
        }
        capabilities = PropertyLoader.loadCapabilities();
        //    WebDriverFactory.setMode(WebDriverFactoryMode.THREADLOCAL_SINGLETON);
    }

    @BeforeMethod
    public void initWebDriver() {
        driver = WebDriverFactory.getDriver(gridHubUrl, capabilities);
    }

    @AfterSuite(alwaysRun = true)
    public void tearDown() {
        WebDriverFactory.dismissDriver();
    }


    /*protected WebDriver getWebDriver(){
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
    }*/
}
