package utils;

import interfaces.Scroll;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class IoSScroll implements Scroll {

    private AppiumDriver driver;

    public IoSScroll(AppiumDriver driver) {
        this.driver = driver;
    }

    @Override
    public void downTo(WebElement webElement) {
    }

    @Override
    public void upTo(WebElement webElement) {

    }

    @Override
    public void downToAndTapOn(WebElement webElement) {

    }

    @Override
    public void upToAndTapOn(WebElement webElement) {

    }

    @Override
    public void up() {

    }

    @Override
    public void down() {

    }
}
