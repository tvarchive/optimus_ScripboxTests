package steps;

import cucumber.api.java.en.Given;
import io.appium.java_client.AppiumDriver;
import pages.HomePage;
import pages.LoginPage;
import pages.MenuPage;

public class LoginSteps extends BaseSteps{

    public AppiumDriver getDriver(){
        return getDriverInstanceFor("user");
    }

    @Given("^I login as a valid registered user with email ([^\"]*) and password ([^\"]*)$")
    public void iLoginAsAValidRegisteredUser(String email,String password){
        new HomePage(getDriver()).tapOnMenu();
        new MenuPage(getDriver()).tapOnLogin();
        new LoginPage(getDriver()).enterEmail(email);
        new LoginPage(getDriver()).tapOnNext();
        new LoginPage(getDriver()).enterPassword(password);
        new LoginPage(getDriver()).tapOnLogin();
    }
}
