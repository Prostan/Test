package pageObjects;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;


public class SentMailPage extends BasePage{

    public SentMailPage(WebDriver driver){
        super(driver);
    }


    @Override
    public void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        Assert.assertTrue(driver.getTitle().startsWith("Sent"), "Send Mail page is not loaded");
    }
}
