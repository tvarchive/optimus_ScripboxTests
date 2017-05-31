package steps;

import cucumber.api.PendingException;
import cucumber.api.java8.En;
import finder.OptimusElementFinder;
import org.openqa.selenium.WebElement;
import utils.SlideController;

public class GenericSteps extends BaseSteps implements En {
    public GenericSteps() {
        Given("^(.*) on (.*) screen taps on (.*)$", (String appConsumer, String screenName, String fieldName) -> {
            WebElement webElement = new OptimusElementFinder(getDriverInstanceFor(appConsumer)).find(appConsumer, fieldName, screenName);
            webElement.click();
        });

        And("^(.*) on (.*) screen types (.*) into (.*)$", (String appConsumer, String screenName, String value, String fieldName) -> {
            WebElement webElement = new OptimusElementFinder(getDriverInstanceFor(appConsumer)).find(appConsumer, fieldName, screenName);
            webElement.clear();
            webElement.sendKeys(value);
        });

        And("^(.*) on (.*) screen clicks (.*)$", (String appConsumer, String screenName, String fieldName) -> {
            WebElement webElement = new OptimusElementFinder(getDriverInstanceFor(appConsumer)).find(appConsumer, fieldName, screenName);
            webElement.click();
        });
        And("^(.*) on (.*) screen slides (.*) to (\\d+)%$", (String appConsumer, String screenName, String fieldName, Integer slideByPercentage) -> {
            WebElement webElement = new OptimusElementFinder(getDriverInstanceFor(appConsumer)).find(appConsumer, fieldName, screenName);
            new SlideController(webElement,getDriverInstanceFor(appConsumer)).slideBy(slideByPercentage);
        });
    }
}
