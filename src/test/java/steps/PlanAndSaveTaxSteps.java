package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import pages.HomePage;
import pages.PlanPage;
import pages.SaveTaxPage;

import static utils.SliderConstants.*;

public class PlanAndSaveTaxSteps extends BaseSteps{

    public AppiumDriver getDriver(){
        return getDriverInstanceFor("user");
    }

    @When("^I choose to plan and save tax$")
    public void iChooseToPlanAndSaveTax(){
        new HomePage(getDriver()).tapOnPlan();
        new PlanPage(getDriver()).tapOnSaveTaxCard();
    }

    @Then("^I should be taken to \"Plan and Save tax\" page$")
    public void iShouldBeTakenToPlanAndSaveTaxPage(){
        new SaveTaxPage(getDriver()).assertIfOnSaveTaxPage();
    }

    @Given("^I tap on \"Let's get started\"$")
    public void iTapOnLetsGetStarted(){
        new SaveTaxPage(getDriver()).tapOnLetsGetStarted();
    }

    @When("^I enter my CTC below 3 lakhs$")
    public void iEnterMyCTCBelow3Lakhs(){
        new SaveTaxPage(getDriver()).setSeekBar(LOW);
        new SaveTaxPage(getDriver()).tapOnNextButton();
    }

    @When("^I enter my CTC above 3 lakhs$")
    public void iEnterMyCTCAbove3Lakhs(){
        new SaveTaxPage(getDriver()).setSeekBar(HIGH);
    }

    @Then("^I should be told that I am not taxable and \"Calculate Again\" button should get activated$")
    public void iShouldBeToldThatIAmNotTaxable(){
        SaveTaxPage saveTaxPage = new SaveTaxPage(getDriver());
        pageBank.addPage(saveTaxPage);
        pageBank.getPage(SaveTaxPage.class).assertIfCalculateAgainIsDisplayed();
    }

}
