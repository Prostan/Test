package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;

/**
 * Created by Stan on 4/14/2015.
 */
public class UserProfileBox extends BasePage{

    @FindBy(id = "gb_71")
    private WebElement signOutButton;

    @FindBy(css = ".gb_za")
    private WebElement userProfileName;



    public UserProfileBox(WebDriver driver){
        super(driver);
    }

    public String getUserName(){
       return userProfileName.getText();

    }


    public LoginPage logOut(){
        signOutButton.click();
        return PageFactory.initElements(driver, LoginPage.class);
    }

    @Override
    public void load() {
    }

    @Override
    protected void isLoaded() throws Error {
        Assert.assertTrue(isElementPresent(signOutButton));
    }

}
