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

    @FindBy(linkText = "href=\"https://mail.google.com/mail/logout?hl=en\"")
    private WebElement signOutButton;

    @FindBy(className = "T-I J-J5-Ji T-I-KE L3")
    private WebElement composeButton;

    @FindBy(tagName = "title")
    private WebElement title;

    public HomePage(WebDriver driver){
        super(driver);
    }

    @Override
    public void load(){
    }

    @Override
    protected void isLoaded(){
        Assert.assertTrue("Page is not loaded", driver.getTitle().startsWith("Inbox"));
    }


    public boolean isLoggedIn(){
        return driver.getTitle().startsWith("Inbox");
    }

    public LoginPage logOut(){
        signOutButton.click();
        return PageFactory.initElements(driver, LoginPage.class);
    }
}
