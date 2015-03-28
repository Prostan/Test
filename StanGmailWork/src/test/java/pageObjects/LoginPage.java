package pageObjects;


import data.UserData;
import junit.framework.Assert;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage{

    @FindBy(name = "Email")
    public WebElement userNameField;

    @FindBy(name = "Passwd")
    public WebElement passwordField;

    @FindBy(name = "signIn")
    public WebElement signInButton;

    @FindBy(name = "PersistentCookie")
    public WebElement staySignedCheckBox;

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public HomePage loginAs(UserData admin){
        type(userNameField, admin.name);
        type(passwordField, admin.pass);
        //todo uncheck save user
        //staySignedCheckBox.isSelected();
        signInButton.click();
        return PageFactory.initElements(driver, HomePage.class);
    }

    @Override
    public void load(){
        driver.get("http://gmail.com");
    }

    @Override
    protected void isLoaded(){
        Assert.assertTrue("Page is not loaded", driver.getTitle().startsWith("Gmail"));
    }

    public boolean isLoggedOut(){
        return isElementPresent(signInButton);
    }


}
