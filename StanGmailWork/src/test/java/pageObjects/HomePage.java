package pageObjects;

import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Created by Stan on 3/11/2015.
 */
public class HomePage extends BasePage {

    @FindBy(id = "gb_71")
    private WebElement signOutButton;

    @FindBy(css = "[gh=cm]")
    private WebElement composeButton;

    @FindBy(css = ".gb_ja")
    private WebElement dropDown;

    // WebDriverWait wait = new WebDriverWait(driver, 10); // TODO find how to properly use it

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

    public void composeMail(){
        // wait.until(ExpectedConditions.titleContains("Inbox"));
        composeButton.click();

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


