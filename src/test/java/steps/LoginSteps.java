package steps;

import cucumber.api.java.en.Given;
import io.appium.java_client.AppiumDriver;
import pages.HomePage;

public class LoginSteps extends BaseSteps{

    public AppiumDriver getDriver(){
        return getDriverInstanceFor("user");
    }

    @Given("^I login as a valid registered user$")
    public void iLoginAsAValidRegisteredUser(){
        new HomePage(getDriver()).tapOnMenu();
    }
}
