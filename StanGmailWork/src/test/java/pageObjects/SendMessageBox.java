package pageObjects;


import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;

public class SendMessageBox extends BasePage{

    @FindBy(css = "[aria-label*='Ctrl-Enter']") //Find element by attribute. Attribute value contains(*) "Ctrl-enter"
    private WebElement sendMessageButton;

    @FindBy(css = ".vO[aria-label='To']") //Attribute value much "To"
    private WebElement resipientsBox;

    @FindBy(css = ".aoT")
    private WebElement subjectBox;

    @FindBy(css = "[aria-label='Message Body'][hidefocus='true']") //Combining two attribute values
    private WebElement messageBodyBox;

    public SendMessageBox(WebDriver driver){
        super(driver);
    }

    @Override
    public void load() {

    }

    @Override
    protected void isLoaded() throws Error {
        Assert.assertTrue(isElementPresent(sendMessageButton));
    }

    public void sendMail(){
        typeText(resipientsBox, "stanwebtest@gmail.com");
        typeText(subjectBox, "test");
        typeText(messageBodyBox, "Hello Amigo");
        sendMessageButton.click();
    }

}
