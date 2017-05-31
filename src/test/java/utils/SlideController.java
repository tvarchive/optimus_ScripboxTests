package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.MobileElement;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SlideController {

    private WebElement seekbar;
    private AppiumDriver driver;
    private TouchAction touchAction;
    private final int offset = 200;
    private WebDriverWait wait;

    public SlideController(WebElement seekbar, AppiumDriver driver) {
        this.seekbar = seekbar;
        this.driver = driver;
        this.wait = new WebDriverWait(driver,10);
    }

    public void slideBy(int slideByPercentage){
        int xStartingPoint = seekbar.getLocation().getX();
        int xEndingPoint = seekbar.getSize().getWidth();
        int yStartingAndEndingPoint = seekbar.getLocation().getY();
        moveSliderAccordingToSpecifiedPercentage(xStartingPoint,xEndingPoint,yStartingAndEndingPoint,slideByPercentage);
    }

    private void moveSliderAccordingToSpecifiedPercentage(int xStartingPoint, int xEndingPoint, int yStartingAndEndingPoint, int slideByPercentage) {
        double slideFactor = (double)slideByPercentage/(double)100;
        int pointToMoveTo = (int) ((xEndingPoint+offset)*slideFactor);
        touchAction = new TouchAction(driver);
        wait.until(ExpectedConditions.elementToBeClickable(seekbar));
        touchAction.longPress(seekbar,xStartingPoint,yStartingAndEndingPoint,1000).moveTo(pointToMoveTo,yStartingAndEndingPoint).release().perform();
    }
}
