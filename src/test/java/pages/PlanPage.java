package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class PlanPage extends BasePage {

    @FindBy(id = "save_tax_card")
    private WebElement saveTaxCard;

    @FindBy(id = "compare_investment_card")
    private WebElement investMyMoneyCard;

    @FindBy(id = "wealth_check_up_card")
    private WebElement wealthCheckupCard;

    @FindBy(id = "child_education_card")
    private WebElement childEducationCard;

    @FindBy(id = "retirement_card")
    private WebElement retirementCard;

    private AppiumDriver driver;

    public PlanPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver,this);
        this.driver = driver;
    }

    public void tapOnSaveTaxCard(){
        waitForElementToBeVisible(saveTaxCard);
        saveTaxCard.click();
    }

    public void tapOnInvestMyMoneyCard(){
        waitForElementToBeVisible(investMyMoneyCard);
        investMyMoneyCard.click();
    }

    public void tapOnWealthCheckupCard(){
        waitForElementToBeVisible(wealthCheckupCard);
        wealthCheckupCard.click();
    }

    public void tapOnChildEducationCard(){
        waitForElementToBeVisible(childEducationCard);
        childEducationCard.click();
    }

    public void tapOnRetirementCard(){
        waitForElementToBeVisible(retirementCard);
        retirementCard.click();
    }
}
