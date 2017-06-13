package utils;

import exceptions.ElementNotPresentException;
import interfaces.Swipe;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebDriverException;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;

public class AndroidSwipe implements Swipe {

    private AppiumDriver driver;

    public AndroidSwipe(AppiumDriver driver) {
        this.driver = driver;
    }

    @Override
    public void left() {
        driver.swipe(getWidth() / 10, getHeight() / 2, getWidth() * 9 / 10, getHeight() / 2, 1000);
    }

    @Override
    public void right() {
        driver.swipe(getWidth() * 9 / 10, getHeight() / 2, getWidth() / 10, getHeight() / 2, 1000);
    }

    @Override
    public void leftTo(WebElement webElement) {
        int count = 0;
        try {
            while (count < 12) {
                left();
                if (webElement.isDisplayed()) {
                    return;
                }
                count++;
            }
        } catch (ElementNotPresentException e) {
            throw new ElementNotPresentException("Element is not present on the screen.Was it there in the first place?");
        }
    }

    @Override
    public void rightTo(WebElement webElement) {
        int count = 0;
        try {
            while (count < 12) {
                right();
                if (webElement.isDisplayed()) {
                    return;
                }
                count++;
            }
        } catch (ElementNotPresentException e) {
            throw new ElementNotPresentException("Element is not present on the screen.Was it there in the first place?");
        }
    }

    @Override
    public void leftToAndTapOn(WebElement webElement) {
        int count = 0;
        try {
            while (count < 12) {
                left();
                if (webElement.isDisplayed()) {
                    webElement.click();
                    return;
                }
                count++;
            }
        } catch (ElementNotPresentException e) {
            throw new ElementNotPresentException("Element is not present on the screen.Was it there in the first place?");
        }
    }

    @Override
    public void rightToAndTapOn(WebElement webElement) {
        int count = 0;
        try {
            while (count < 12) {
                right();
                if (webElement.isDisplayed()) {
                    webElement.click();
                    return;
                }
                count++;
            }
        } catch (ElementNotPresentException e) {
            throw new ElementNotPresentException("Element is not present on the screen.Was it there in the first place?");
        }
    }


    private void hideKeyboard() {
        try {
            driver.hideKeyboard();
        } catch (WebDriverException ex) {

        }
    }

    private int getWidth() {
        int width = driver.manage().window().getSize().getWidth();
        return width;
    }

    private int getHeight() {
        int height = driver.manage().window().getSize().getHeight();
        return height;
    }
}
