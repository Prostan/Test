package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.util.NoSuchElementException;

public abstract class BasePage extends LoadableComponent<BasePage>  {

    protected WebDriver driver;

    public BasePage(WebDriver driver){ //Constructor which returns driver instance

        this.driver = driver;
    }

    public abstract void load();

    public boolean isElementPresent(WebElement element){
        try{
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }

    protected void type(WebElement webElement, String text){
        webElement.clear();
        webElement.sendKeys(text);
    }

    public HomePage navigateToWebApp(){
        driver.navigate().to("http://www.thetestroom.com/webapp");
        return PageFactory.initElements(driver, HomePage.class);
    }
}
