package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class MenuPage extends BasePage {

    @FindBy(xpath = "//android.widget.CheckedTextView[@text='Login']")
    private WebElement login;

    private AppiumDriver driver;

    public MenuPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public void tapOnLogin(){
        waitForElementToBeVisible(login);
        login.click();
    }
}
