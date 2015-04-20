package pageObjects;


import data.UserData;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.testng.Assert;



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

    private static final Logger LOG = LogManager.getLogger(LoginPage.class);

    public LoginPage(WebDriver driver){
        super(driver);
    }

    public HomePage loginAs(UserData user){
        enterText(userNameField, user.name);
        enterText(passwordField, user.pass);
        //todo uncheck save user
        //staySignedCheckBox.isSelected();
        safeClick(signInButton);
        LOG.info("Logging as Admin");
        return PageFactory.initElements(driver, HomePage.class);
    }

    public void badloginAs(UserData badUser){
        enterText(userNameField, badUser.name);
        enterText(passwordField, badUser.pass);
        safeClick(signInButton);
        LOG.info("Logging as BadUser");
    }



    @Override
    public void load(){
        driver.get("https://accounts.google.com");
        LOG.info("Login Page is loaded");
    }

    @Override
    protected void isLoaded(){
        Assert.assertTrue(driver.getTitle().startsWith("Sign in"), "Login page is not loaded");
    }

    public boolean isLoggedOut(){
        return isElementPresent(signInButton);
    }


}
