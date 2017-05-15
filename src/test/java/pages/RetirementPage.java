package pages;

import io.appium.java_client.AppiumDriver;
import org.junit.Assert;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;


public class RetirementPage extends BasePage {

    @FindBy(xpath = "//android.widget.LinearLayout[@index=2]/android.widget.TextView[@text='RETIREMENT READINESS']")
    private WebElement retirementReadiness;

    @FindBy(id = "lets_get_started_button_retirement_calculator")
    private WebElement letsGetStarted;

    @FindBy(id = "minus")
    private WebElement minus;

    @FindBy(id = "plus")
    private WebElement plus;

    @FindBy(id = "next_button")
    private WebElement nextButton;

    @FindBy(id = "show_age")
    private WebElement age;

    @FindBy(id = "show_income")
    private WebElement income;

    @FindBy(id = "i_have_more")
    private WebElement iHaveMore;

    private AppiumDriver driver;

    public RetirementPage(AppiumDriver driver) {
        super(driver);
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public void assertIfRetirementIsDisplayed() {
        Assert.assertEquals("RETIREMENT READINESS", retirementReadiness.getText());
    }

    public void tapOnLetsGetStarted() {
        waitForElementToBeClickable(letsGetStarted);
        letsGetStarted.click();
    }

    private int getAge() {
        waitForElementToBeVisible(age);
        return Integer.parseInt(age.getText());
    }

    public void setAge(int age) {
        int diff;
        if (age < getAge()) {
            diff = getAge() - age;
            waitForElementToBeVisible(minus);
            while (diff > 0) {
                minus.click();
                diff--;
            }
        } else if (age > getAge()) {
            diff = age - getAge();
            waitForElementToBeVisible(plus);
            while (diff > 0) {
                plus.click();
                diff--;
            }
        }
        else {

        }
    }

    public void setFamilyIncome(){
        waitForElementToBeVisible(plus);
        int count = 5;
        while(count>0){
            plus.click();
            count--;
        }
    }

    public void tapOnIHaveMore(){
        waitForElementToBeVisible(iHaveMore);
        iHaveMore.click();
    }

    public void tapOnNextButton() {
        waitForElementToBeClickable(nextButton);
        nextButton.click();
    }

}
