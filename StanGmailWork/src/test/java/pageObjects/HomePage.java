package pageObjects;

import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

/**
 * Created by Stan on 3/11/2015.
 */
public class HomePage extends BasePage {

    @FindBy(id = "gb_71")
    private WebElement signOutButton;

    @FindBy(css = "[gh=cm]")
    private WebElement composeButton;

    @FindBy(css = ".gb_L.gb_la.gb_o.gb_ha")
    private WebElement dropDown;

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
        Assert.assertTrue("Home page is not loaded", driver.getTitle().startsWith("Inbox"));
    }

    public SendMessageBox openSendMessagBox(){
        composeButton.click();
        return PageFactory.initElements(driver,SendMessageBox.class);
    }

    public SentMailPage openSentMailPage(){
        sentMailLink.click();
        return PageFactory.initElements(driver,SentMailPage.class);
    }



    public boolean isLoggedIn(){
        // wait.until(ExpectedConditions.titleContains("Inbox"));
        return driver.getTitle().startsWith("Inbox");
    }

    public LoginPage logOut(){
        dropDown.click();
        signOutButton.click();
        return PageFactory.initElements(driver, LoginPage.class);
    }
}


