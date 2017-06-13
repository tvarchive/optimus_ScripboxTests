package utils;

import exceptions.ElementNotPresentException;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.WebElement;

public class DragAndDrop {

    private TouchAction touchAction;

    public DragAndDrop(AppiumDriver driver) {
        this.touchAction = new TouchAction(driver);
    }

    public void dragAndDropItem(WebElement elem1, WebElement elem2){
        try {
            touchAction.press(elem1).waitAction(1000).moveTo(elem2).release().perform();
        } catch (ElementNotPresentException e) {
            throw new ElementNotPresentException("Element is not present on the screen");
        }
    }
}
