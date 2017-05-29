package finder;

import com.testvagrant.optimus.parser.OptimusConfigParser;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import static com.testvagrant.optimus.utils.JsonUtil.getAppJson;

public class OptimusElementFinder {
    private AppiumDriver driver;

    public OptimusElementFinder(AppiumDriver driver) {
        this.driver = driver;

    }


    public WebElement find(String appConsumer, String fieldName, String screenName) {
        String testFeed = System.getProperty("testFeed") + ".json";
        String appJson = getAppJson(testFeed);
        String appName = new OptimusConfigParser(appJson).getAppBelongingTo(appConsumer);
        Element appElement = new ElementStore().find(appName, fieldName, screenName);
        WebDriverWait wait = new WebDriverWait(driver, 10);
        By locator = getLocatorType(appElement);
        wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
//        return driver.findElement(appElement.getIdentifier(), appElement.getValue());
        return driver.findElement(locator);
    }

    private By getLocatorType(Element appElement) {
        if (appElement.getIdentifier().equalsIgnoreCase("id")) return By.id(appElement.getValue());
        if (appElement.getIdentifier().equalsIgnoreCase("xpath")) return By.xpath(appElement.getValue());
        if (appElement.getIdentifier().equalsIgnoreCase("className")) return By.className(appElement.getValue());
        if (appElement.getIdentifier().equalsIgnoreCase("css")) return By.cssSelector(appElement.getValue());
        if (appElement.getIdentifier().equalsIgnoreCase("linkText")) return By.linkText(appElement.getValue());
        if (appElement.getIdentifier().equalsIgnoreCase("partialLinkText"))
            return By.partialLinkText(appElement.getValue());
        throw new RuntimeException("Not a valid identifier");
    }


}
