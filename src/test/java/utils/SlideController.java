package utils;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.TouchAction;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SlideController {

    private WebElement seekbar;
    private AppiumDriver driver;
    private final int offset = 320;
    private TouchAction touchAction;
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
        int pointToMoveTo = (int) (((xEndingPoint-xStartingPoint)+offset)*(slideFactor));
        touchAction = new TouchAction(driver);
        wait.until(ExpectedConditions.visibilityOf(seekbar));
        touchAction.longPress(xStartingPoint,yStartingAndEndingPoint).moveTo(pointToMoveTo,yStartingAndEndingPoint).release().perform();
    }
}
