package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.LoadableComponent;

import java.util.NoSuchElementException;

public abstract class BasePage extends LoadableComponent<BasePage>  {

    protected WebDriver driver; //Web driver declaration

    public BasePage(WebDriver driver){ //Constructor which returns driver instance

        this.driver = driver;
    }

    public abstract void load(); //Abstract method which will force inherited classes use load

    public boolean isElementPresent(WebElement element){ //Method to check if element present
        try{
            element.isDisplayed();
            return true;
        } catch (NoSuchElementException e){
            return false;
        }
    }

    protected void type(WebElement webElement, String text){ //Method to type text
        webElement.clear();
        webElement.sendKeys(text);
    }
}
