package steps;


import com.testvagrant.optimus.finder.OptimusElementFinder;
import com.testvagrant.optimus.finder.SlideController;
import com.testvagrant.optimus.steps.BaseSteps;
import cucumber.api.java8.En;
import interfaces.Scroll;
import interfaces.Swipe;
import org.openqa.selenium.WebElement;
import utils.DoubleTap;
import utils.AndroidScroll;
import utils.AndroidSwipe;

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

        And("^(.*) on (.*) screen slides (.*) to (\\d+)%$", (String appConsumer, String screenName, String fieldName, Integer slideByPercentage) -> {
            WebElement webElement = new OptimusElementFinder(getDriverInstanceFor(appConsumer)).find(appConsumer, fieldName, screenName);
            new SlideController(webElement, getDriverInstanceFor(appConsumer)).slideBy(slideByPercentage);
        });
        And("^(.*) on (.*) screen double taps on (.*)$", (String appConsumer, String screenName, String fieldName) -> {
            WebElement webElement = new OptimusElementFinder(getDriverInstanceFor(appConsumer)).find(appConsumer, fieldName, screenName);
            new DoubleTap(getDriverInstanceFor("user")).doubleTapOn(webElement);
        });

        And("^(.*) on (.*) screen scrolls down and taps on (.*)$", (String appConsumer, String screenName, String fieldName) -> {
            WebElement webElement = new OptimusElementFinder(getDriverInstanceFor(appConsumer)).find(appConsumer, fieldName, screenName);
            Scroll scroll = new AndroidScroll(getDriverInstanceFor("user"));
            scroll.downToAndTapOn(webElement);
        });

        And("^(.*) on (.*) screen scrolls up and taps on (.*)$", (String appConsumer, String screenName, String fieldName) -> {
            WebElement webElement = new OptimusElementFinder(getDriverInstanceFor(appConsumer)).find(appConsumer, fieldName, screenName);
            Scroll scroll = new AndroidScroll(getDriverInstanceFor("user"));
            scroll.upToAndTapOn(webElement);
        });

        And("^(.*) on (.*) screen scrolls up to (.*)$", (String appConsumer, String screenName, String fieldName) -> {
            WebElement webElement = new OptimusElementFinder(getDriverInstanceFor(appConsumer)).find(appConsumer, fieldName, screenName);
            Scroll scroll = new AndroidScroll(getDriverInstanceFor("user"));
            scroll.upTo(webElement);
        });

        And("^(.*) on (.*) screen scrolls down to (.*)$", (String appConsumer, String screenName, String fieldName) -> {
            WebElement webElement = new OptimusElementFinder(getDriverInstanceFor(appConsumer)).find(appConsumer, fieldName, screenName);
            Scroll scroll = new AndroidScroll(getDriverInstanceFor("user"));
            scroll.downTo(webElement);
        });

        And("^(.*) on (.*) screen scrolls down$", (String appConsumer, String screenName) -> {
            Scroll scroll = new AndroidScroll(getDriverInstanceFor("user"));
            scroll.down();
        });

        And("^(.*) on (.*) screen scrolls up$", (String appConsumer, String screenName) -> {
            Scroll scroll = new AndroidScroll(getDriverInstanceFor("user"));
            scroll.up();
        });

        And("^(.*) on (.*) screen swipes left to (.*)$", (String appConsumer, String screenName, String fieldName) -> {
            WebElement webElement = new OptimusElementFinder(getDriverInstanceFor(appConsumer)).find(appConsumer, fieldName, screenName);
            Swipe swipe = new AndroidSwipe(getDriverInstanceFor("user"));
            swipe.leftTo(webElement);
        });
        And("^(.*) on (.*) screen swipes right to (.*)$", (String appConsumer, String screenName, String fieldName) -> {
            WebElement webElement = new OptimusElementFinder(getDriverInstanceFor(appConsumer)).find(appConsumer, fieldName, screenName);
            Swipe swipe = new AndroidSwipe(getDriverInstanceFor("user"));
            swipe.rightTo(webElement);
        });

        And("^(.*) on (.*) screen swipes left$", (String appConsumer, String screenName) -> {
            Swipe swipe = new AndroidSwipe(getDriverInstanceFor("user"));
            swipe.left();
        });

        And("^(.*) on (.*) screen swipes right$", (String appConsumer, String screenName) -> {
            Swipe swipe = new AndroidSwipe(getDriverInstanceFor("user"));
            swipe.right();
        });

        And("^(.*) on (.*) screen swipes right and taps on (.*)$", (String appConsumer, String screenName, String fieldName) -> {
            WebElement webElement = new OptimusElementFinder(getDriverInstanceFor(appConsumer)).find(appConsumer, fieldName, screenName);
            Swipe swipe = new AndroidSwipe(getDriverInstanceFor("user"));
            swipe.rightToAndTapOn(webElement);
        });

        And("^(.*) on (.*) screen swipes left and taps on (.*)$", (String appConsumer, String screenName, String fieldName) -> {
            WebElement webElement = new OptimusElementFinder(getDriverInstanceFor(appConsumer)).find(appConsumer, fieldName, screenName);
            Swipe swipe = new AndroidSwipe(getDriverInstanceFor("user"));
            swipe.leftToAndTapOn(webElement);
        });
    }
}
