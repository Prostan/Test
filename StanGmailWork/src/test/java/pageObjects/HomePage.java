package pageObjects;

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


    public HomePage(WebDriver driver){
        super(driver);
    }

    @Override
    public void load(){ //Using load companent
    }

    @Override
    protected void isLoaded(){   //make sure we are in the right page
        Assert.assertTrue(driver.getTitle().startsWith("Inbox"), "Home page is not loaded");
    }

    public SendMessageBox openSendMessagBox(){
        composeButton.click();
        return PageFactory.initElements(driver,SendMessageBox.class);
    }

    public UserProfileBox openUserProfileBox(){
        userProfileButton.click();
        return PageFactory.initElements(driver,UserProfileBox.class);
    }


    public SentMailPage openSentMailPage(){
        sentMailLink.click();
        return PageFactory.initElements(driver,SentMailPage.class);
    }



    public boolean isLoggedIn(){
        // wait.until(ExpectedConditions.titleContains("Inbox"));
        return driver.getTitle().startsWith("Inbox");
    }


}


