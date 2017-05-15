package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage extends BasePage {

    @FindBy(id = "toolbar")
    private WebElement toolbar;

    @FindBy(xpath = "//android.widget.TextView[@text='Plan']")
    private WebElement plan;

    @FindBy(xpath = "//android.widget.TextView[@text='Learn']")
    private WebElement learn;

    @FindBy(xpath = "//android.widget.TextView[@text='Invest']")
    private WebElement invest;


    private AppiumDriver driver;

    public HomePage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);
        this.driver = driver;
    }

    public void tapOnMenu() {
        waitForElementToBeVisible(toolbar);
        getElement(toolbar, By.xpath("//android.widget.ImageButton")).click();
    }

    public void tapOnPlan(){
        waitForElementToBeClickable(plan);
        plan.click();
    }

    public void tapOnLearn(){
        waitForElementToBeClickable(learn);
        learn.click();
    }

    public void tapOnInvest(){
        waitForElementToBeClickable(invest);
        invest.click();
    }
}
