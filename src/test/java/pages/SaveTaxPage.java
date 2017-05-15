package pages;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import utils.SliderConstants;

public class SaveTaxPage extends BasePage {

    @FindBy(xpath = "//android.widget.LinearLayout[@index=2]/android.widget.TextView")
    private WebElement saveTaxHeader;

    @FindBy(id = "next_button_for_tax_step1")
    private WebElement letsGetStarted;

    @FindBy(id = "next_button")
    private WebElement nextButton;

    @FindBy(id = "seek_bar")
    private WebElement seekBar;

    @FindBy(id = "calculate_again")
    private WebElement calculateAgain;

    @FindBy(id = "switch_conveyance")
    private WebElement switchConveyance;

    @FindBy(id = "switch_medical")
    private WebElement switchMedical;

    @FindBy(id = "estimated_tax")
    private WebElement estimatedTax;

    private AppiumDriver driver;

    public SaveTaxPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void assertIfOnSaveTaxPage() {
        Assert.assertEquals("HOW CAN I SAVE TAX", saveTaxHeader.getText());
    }

    public void tapOnLetsGetStarted() {
        waitForElementToBeClickable(letsGetStarted);
        letsGetStarted.click();
    }

    public void tapOnNextButton() {
        waitForElementToBeClickable(nextButton);
        nextButton.click();
    }

    public void setSeekBar(SliderConstants sliderConstant) {
        waitForElementToBeVisible(seekBar);
        int xStartingPoint = seekBar.getLocation().getX();
        int xEndingPoint = seekBar.getSize().getWidth();
        int yEndingPoint = seekBar.getLocation().getY();
        int offset = 170;
        int xMidPoint = xEndingPoint / 2 + offset;

        switch (sliderConstant) {
            case VERY_LOW:
                slideSeekBar(xStartingPoint, yEndingPoint, xStartingPoint);
                break;

            case LOW:
                slideSeekBar(xStartingPoint, yEndingPoint, (int) (xMidPoint*(0.5)));
                break;

            case MID:
                slideSeekBar(xStartingPoint, yEndingPoint, xMidPoint);
                break;

            case HIGH:
                slideSeekBar(xStartingPoint, yEndingPoint, (int) (xMidPoint+xMidPoint*(0.5)));
                break;

            case VERY_HIGH:
                slideSeekBar(xStartingPoint, yEndingPoint, xMidPoint*2);
                break;
        }
    }

    private void slideSeekBar(int xStartingPoint, int yEndingPoint, int xMidPoint) {
        TouchAction action = new TouchAction(driver);
        waitForElementToBeClickable(seekBar);
        action.longPress(xStartingPoint, yEndingPoint).moveTo(xMidPoint, yEndingPoint).release().perform();
    }

    public void assertIfCalculateAgainIsDisplayed() {
        Assert.assertEquals(calculateAgain.getText(), "CALCULATE AGAIN!");
    }

    public String getEstimatedTax() {
        waitForElementToBeVisible(estimatedTax);
        return estimatedTax.getText();
    }

    public void assertIfEstimatedTaxIsSameOnEveryPage(String estimatedTaxOnNextPage) {
        waitForElementToBeVisible(estimatedTax);
        Assert.assertEquals(estimatedTax.getText(), estimatedTaxOnNextPage);
        System.out.println("Estimated tax same");
    }

    public void tapOnMonthlyConveyanceAllowance() {
        waitForElementToBeClickable(switchConveyance);
        switchConveyance.click();
    }

    public void tapOnMonthlyMedicalAllowance() {
        waitForElementToBeVisible(switchMedical);
        switchMedical.click();
    }


}
