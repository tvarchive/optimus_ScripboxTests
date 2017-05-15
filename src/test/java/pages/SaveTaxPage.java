package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SaveTaxPage extends BasePage {

    @FindBy(xpath = "//android.widget.LinearLayout[@index=2]/android.widget.TextView")
    private WebElement saveTaxHeader;

    @FindBy(id = "next_button_for_tax_step1")
    private WebElement letsGetStarted;

    @FindBy(id = "next_button")
    private WebElement nextButton;

    @FindBy(id = "seek_bar")
    private WebElement setCTC;

    private AppiumDriver driver;

    public SaveTaxPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public void assertIfOnSaveTaxPage(){
        Assert.assertEquals("HOW CAN I SAVE TAX",saveTaxHeader.getText());
    }

    public void tapOnLetsGetStarted(){
        waitForElementToBeClickable(letsGetStarted);
        letsGetStarted.click();
    }

    public void tapOnNextButton(){
        waitForElementToBeClickable(nextButton);
        nextButton.click();
    }

    public void setSalaryBelowThreeL(){
       int xStartingPoint = setCTC.getLocation().getX();
       int xEndingPoint = setCTC.getSize().getWidth();
       int yStartingPoint = setCTC.getLocation().getY();
       int yEndingPoint = setCTC.getSize().getHeight();
       int xSingleCTCLength = xEndingPoint/30;
       int xLastPointToGo = xSingleCTCLength*3;
       TouchAction action = new TouchAction(driver);
       waitForElementToBeClickable(setCTC);
       action.longPress(xStartingPoint,yStartingPoint).moveTo(xLastPointToGo,yEndingPoint).release().perform();
    }


}
