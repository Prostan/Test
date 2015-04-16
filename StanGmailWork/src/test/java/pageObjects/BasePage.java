package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.SlowLoadableComponent;
import org.openqa.selenium.support.ui.SystemClock;
import org.testng.Reporter;

import java.util.NoSuchElementException;

public abstract class BasePage extends SlowLoadableComponent<BasePage>  {

    private static final Logger LOG = LogManager.getLogger(LoginPage.class);

    protected WebDriver driver; //Web driver declaration

    public BasePage(WebDriver driver){ //Constructor which returns driver instance
        super(new SystemClock(), 10);
        this.driver = driver;
    }

    // WebDriverWait wait = new WebDriverWait(driver, 10);

    public abstract void load(); //Abstract method which will force inherited classes use load

    public void waitPageLoadTitleContains(String title){

    }

    public boolean isElementPresent(WebElement element){ //Method to check if element present
        try{
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }

    protected void enterText(WebElement webElement, String text){ //Method to enterText text
        webElement.clear();
        webElement.sendKeys(text);
        LOG.info("Text entered");
    }

    public void safeClick(WebElement webElement) { //Sefe click method
        if(webElement != null) {
            webElement.click();
            LOG.info(" Safeclick");
        } else {
            // Using the TestNG API for logging
            Reporter.log("Element: " + webElement + ", is not available on page - "
                    + driver.getCurrentUrl()); //Todo return page instead URL
        }
    }
}
