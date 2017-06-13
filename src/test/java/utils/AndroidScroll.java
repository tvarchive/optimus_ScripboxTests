package utils;

import exceptions.ElementNotPresentException;
import interfaces.Scroll;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;


public class AndroidScroll implements Scroll {

    private AppiumDriver driver;
    private TouchAction touchAction;

    public AndroidScroll(AppiumDriver driver) {
        this.driver = driver;
        this.touchAction = new TouchAction(driver);
    }

    @Override
    public void downTo(WebElement webElement) {
        hideKeyboard();
        try {
            int i = 0;
            while (i < 12) {
                if (webElement.isDisplayed()) {
                    return;
                }
                down();
                i++;
            }
        } catch (ElementNotPresentException e) {
            throw new ElementNotPresentException("Element not present on the screen.Was it there in the first place ? ");
        }
    }

    @Override
    public void upTo(WebElement webElement) {
        hideKeyboard();
        try {
            int i = 0;
            while (i < 12) {
                if (webElement.isDisplayed()) {
                    return;
                }
                up();
                i++;
            }
        } catch (ElementNotPresentException e) {
            throw new ElementNotPresentException("Element not present on the screen.Was it there in the first place ? ");
        }
    }

    @Override
    public void downToAndTapOn(WebElement webElement) {
        hideKeyboard();
        try {
            int i = 0;
            while (i < 12) {
                if (webElement.isDisplayed()) {
                    webElement.click();
                    return;
                }
                down();
                i++;
            }
        } catch (ElementNotPresentException e) {
            throw new ElementNotPresentException("Element not present on the screen.Was it there in the first place ? ");

        }
    }

    @Override
    public void upToAndTapOn(WebElement webElement) {
        hideKeyboard();
        try {
            int i = 0;
            while (i < 12) {
                if (webElement.isDisplayed()) {
                    webElement.click();
                    return;
                }
                up();
                i++;
            }
        } catch (ElementNotPresentException e) {
            throw new ElementNotPresentException("Element not present on the screen.Was it there in the first place ? ");

        }
    }

    @Override
    public void up() {
        driver.swipe(5, getHeight() / 3, 5, getHeight() * 2 / 3, 1000);
    }

    @Override
    public void down() {
        driver.swipe(5, getHeight() * 2 / 3, 5, getHeight() / 3, 1000);
    }

    private void hideKeyboard() {
        try {
            driver.hideKeyboard();
        } catch (WebDriverException ex) {


        }
    }

    private int getHeight() {
        int height = driver.manage().window().getSize().getHeight();
        return height;
    }
}

