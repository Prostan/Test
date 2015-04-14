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

    @FindBy(css = "#errormsg_0_Passwd")
    public WebElement errorMessage;


    public LoginPage(WebDriver driver){
        super(driver);
    }

    public HomePage loginAs(UserData user){
        typeText(userNameField, user.name);
        typeText(passwordField, user.pass);
        //todo uncheck save user
        //staySignedCheckBox.isSelected();
        signInButton.click();
        return PageFactory.initElements(driver, HomePage.class);
    }

    public void badloginAs(UserData badUser){
        typeText(userNameField, badUser.name);
        typeText(passwordField, badUser.pass);
        signInButton.click();
    }



    @Override
    public void load(){
        driver.get("http://gmail.com");
    }

    @Override
    protected void isLoaded(){
        Assert.assertTrue("Login page is not loaded", driver.getTitle().startsWith("Gmail"));
    }

    public boolean isLoggedOut(){
        return isElementPresent(signInButton);
    }


}
