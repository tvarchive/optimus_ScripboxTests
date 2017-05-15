package steps;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.appium.java_client.AppiumDriver;
import pages.HomePage;
import pages.PlanPage;
import pages.RetirementPage;

public class RetirementPlanSteps extends BaseSteps{

    public AppiumDriver getDriver(){
        return getDriverInstanceFor("user");
    }

    @When("^I choose to see \"How am I doing for my retirement\"$")
    public void iChooseToSeeHowAmIDoingForMyRetirement(){
        PlanPage planPage = new PlanPage(getDriver());
        HomePage homePage = new HomePage(getDriver());
        homePage.tapOnPlan();
        planPage.tapOnRetirementCard();
    }

    @Then("^I should be taken to \"Retirement Readiness\" page$")
    public void iShouldBeTakenToRetirementPlanPage(){
        RetirementPage retirementPage = new RetirementPage(getDriver());
        retirementPage.assertIfRetirementIsDisplayed();
    }

    @Given("^I tap on \"Let's get started\" tab$")
    public void iTapOnLetsGetStarted(){
        RetirementPage retirementPage = new RetirementPage(getDriver());
        retirementPage.tapOnLetsGetStarted();
    }

    @When("^I enter the required relevant details$")
    public void iEnterTheRelevantDetails(){
        RetirementPage retirementPage = new RetirementPage(getDriver());
        retirementPage.setAge(24);
        retirementPage.tapOnNextButton();
        retirementPage.setFamilyIncome();
        retirementPage.tapOnNextButton();
        retirementPage.tapOnIHaveMore();
        retirementPage.tapOnNextButton();
    }

    @Then("^I should be given advice regarding my plan$")
    public void iShouldBeGivenAdviceRegardingMyPlan(){

    }
}
