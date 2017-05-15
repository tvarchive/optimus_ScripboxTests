package pages;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage extends BasePage {

    @FindBy(id = "login_register_email")
    private WebElement email;

    @FindBy(id = "login_register_password")
    private WebElement password;

    @FindBy(id = "login_facebook_custom")
    private WebElement facebook;

    @FindBy(id = "login_google_custom")
    private WebElement google;

    @FindBy(id = "next_button_to_check_email_type")
    private WebElement nextButton;

    @FindBy(id = "login_register_submit")
    private WebElement loginButton;

    private AppiumDriver driver;

    public LoginPage(AppiumDriver driver) {
        super(driver);
        PageFactory.initElements(driver, this);

    }

    public void tapOnFacebook() {
        waitForElementToBeClickable(facebook);
        facebook.click();
    }

    public void tapOnGoogle() {
        waitForElementToBeClickable(google);
        google.click();
    }

    public void enterEmail(String email) {
        waitForElementToBeVisible(this.email);
        this.email.sendKeys(email);
    }

    public void enterPassword(String password){
        waitForElementToBeVisible(this.password);
        this.password.sendKeys(password);
    }

    public void tapOnNext() {
        waitForElementToBeClickable(nextButton);
        nextButton.click();
    }

    public void tapOnLogin(){
        waitForElementToBeClickable(loginButton);
        loginButton.click();
    }
}
