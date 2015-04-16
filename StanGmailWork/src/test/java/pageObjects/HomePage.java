package pageObjects;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * Created by Stan on 3/11/2015.
 */
public class HomePage extends BasePage {

    @FindBy(css = "[gh=cm]")
    private WebElement composeButton;

    @FindBy(css = ".gb_L.gb_la.gb_o.gb_ha")
    private WebElement userProfileButton;

    @FindBy(css = "[title='Sent Mail']")
    private WebElement sentMailLink;

    private static final Logger LOG = LogManager.getLogger(LoginPage.class);

    public HomePage(WebDriver driver){
        super(driver);
    }

    @Override
    public void load(){ //Using load companent
    }

    @Override
    protected void isLoaded(){   //make sure we are in the right page
        Assert.assertTrue(driver.getTitle().startsWith("Inbox"), "Home page is not loaded");
        LOG.info("Home Page is loaded");
    }

    public SendMessageBox openSendMessagBox(){
        composeButton.click();
        LOG.info("Clicking on Compose button");
        return PageFactory.initElements(driver,SendMessageBox.class);
    }

    public UserProfileBox openUserProfileBox(){
        userProfileButton.click();
        LOG.info("Clicking on UserProfile button");
        return PageFactory.initElements(driver,UserProfileBox.class);
    }


    public SentMailPage openSentMailPage(){
        sentMailLink.click();
        LOG.info("Clicking on Sent mail link");
        return PageFactory.initElements(driver,SentMailPage.class);
    }



    public boolean isLoggedIn(){
        // wait.until(ExpectedConditions.titleContains("Inbox"));
        return driver.getTitle().startsWith("Inbox");
    }


}


