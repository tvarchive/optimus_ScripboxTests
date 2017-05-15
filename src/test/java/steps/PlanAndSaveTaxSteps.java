package steps;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import pages.HomePage;
import pages.PlanPage;
import pages.SaveTaxPage;

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
        new SaveTaxPage(getDriver()).tapOnLetsGetStarted();
    }

    @And("^I tap on \"Let's get started\"$")
    public void iTapOnLetsGetStarted(){
        new SaveTaxPage(getDriver()).tapOnLetsGetStarted();
    }

    @When("^I enter the relevant details$")
    public void iEnterTheRelevantDetails(){
        new SaveTaxPage(getDriver()).setSalaryBelowThreeL();
//        new SaveTaxPage(getDriver()).tapOnNextButton();
    }
}
