package utils;


import exceptions.ElementNotPresentException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.WebElement;

public class DoubleTap {

    private TouchAction touchAction;

    public DoubleTap(AppiumDriver driver) {
        touchAction = new TouchAction(driver);
    }

    public void doubleTapOn(WebElement webElement) {
        try {
            touchAction.tap(webElement).release().perform().tap(webElement).release().perform();
        } catch (ElementNotPresentException e) {
            throw new ElementNotPresentException("Element is not present on the screen.");
        }
    }
}
