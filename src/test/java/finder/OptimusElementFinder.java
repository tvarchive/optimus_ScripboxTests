package finder;

import com.testvagrant.optimus.parser.OptimusConfigParser;
import identifier.*;
import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import java.util.HashMap;
import java.util.Map;

import static com.testvagrant.optimus.utils.JsonUtil.getAppJson;

public class OptimusElementFinder {
    private AppiumDriver driver;
    private Map<String, ElementIdentifier> identifierMap = new HashMap<>();

    public OptimusElementFinder(AppiumDriver driver) {
        this.driver = driver;
        identifierMap.put("id", new IdIdentifier());
        identifierMap.put("xpath", new XpathIdentifier());
        identifierMap.put("className", new ClassNameIdentifier());
        identifierMap.put("css", new CssIdentifier());
        identifierMap.put("linkText", new LinkIdentifier());
        identifierMap.put("partialLinkText", new PartialLinkIdentifier());
    }


    public WebElement find(String appConsumer, String fieldName, String screenName) {
        String testFeed = System.getProperty("testFeed") + ".json";
        String appJson = getAppJson(testFeed);
        String appName = new OptimusConfigParser(appJson).getAppBelongingTo(appConsumer);
        Element appElement = new ElementStore().find(appName, fieldName, screenName);
        By locator = getLocatorType(appElement);
        new WaitControl(driver).waitFor(appElement, locator);
        return driver.findElement(locator);
    }

    private By getLocatorType(Element appElement) {
        return identifierMap.get(appElement.getIdentifier()).getLocator(appElement.getValue());
    }


}
