package pageObjects;

/**
 * Created by Stan on 4/2/2015.
 */

import junit.framework.Assert;
import org.openqa.selenium.WebDriver;


public class SentMailPage extends BasePage{

    public SentMailPage(WebDriver driver){
        super(driver);
    }


    @Override
    public void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        Assert.assertTrue("Send Mail page is not loaded", driver.getTitle().startsWith("Sent"));
    }
}
