//package steps;
//
//
//import com.testvagrant.optimus.finder.OptimusElementFinder;
//import com.testvagrant.optimus.finder.SlideController;
//import com.testvagrant.optimus.steps.BaseSteps;
//import com.testvagrant.stepdefs.exceptions.NoSuchEventException;
//import cucumber.api.PendingException;
//import cucumber.api.java8.En;
//import interfaces.Scroll;
//import interfaces.Swipe;
//import org.openqa.selenium.WebElement;
//import utils.*;
//
//import static com.testvagrant.stepdefs.core.Tapster.tapster;
//import static enums.Calendar.DAY;
//import static enums.Calendar.MONTH;
//import static enums.Calendar.YEAR;
//
//public class GenericSteps extends BaseSteps implements En {
//
//    public GenericSteps() {
//
//        Given("^(.*) on (.*) screen taps on (.*)$", (String appConsumer, String screenName, String fieldName) -> {
//            WebElement webElement = new OptimusElementFinder(getDriverInstanceFor(appConsumer)).find(appConsumer, fieldName, screenName);
//            webElement.click();
//        });
//
//        Given("^(.*) on (.*) screen sets (.*) by tapping on (.*) or (.*) until it is set to ([^\"]*)$", (String appConsumer, String screenName,
//                                                                                                         String fieldName1, String fieldName2, String fieldName3, String dayMonthYear) -> {
//            WebElement webElement1 = new OptimusElementFinder(getDriverInstanceFor(appConsumer)).find(appConsumer, fieldName1, screenName);
//            WebElement webElement2 = new OptimusElementFinder(getDriverInstanceFor(appConsumer)).find(appConsumer, fieldName2, screenName);
//            WebElement webElement3 = new OptimusElementFinder(getDriverInstanceFor(appConsumer)).find(appConsumer, fieldName3, screenName);
//            setPickupDate(dayMonthYear, webElement1, webElement2, webElement3);
//        });
//
//        Given("^(.*) on (.*) screen taps (\\d+) times on (.*)$", (String appConsumer, String screenName, Integer times, String fieldName) -> {
//            WebElement webElement = new OptimusElementFinder(getDriverInstanceFor(appConsumer)).find(appConsumer, fieldName, screenName);
//            for (int i = 0; i < times; i++) {
//                webElement.click();
//            }
//        });
//
//        And("^(.*) on (.*) screen types (.*) into (.*)$", (String appConsumer, String screenName, String value, String fieldName) -> {
//            WebElement webElement = new OptimusElementFinder(getDriverInstanceFor(appConsumer)).find(appConsumer, fieldName, screenName);
//            webElement.clear();
//            webElement.sendKeys(value);
//        });
//
//        And("^(.*) on (.*) screen slides (.*) to (\\d+)%$", (String appConsumer, String screenName, String fieldName, Integer slideByPercentage) -> {
//            WebElement webElement = new OptimusElementFinder(getDriverInstanceFor(appConsumer)).find(appConsumer, fieldName, screenName);
//            new SlideController(webElement, getDriverInstanceFor(appConsumer)).slideBy(slideByPercentage);
//        });
//
//        And("^(.*) on (.*) screen double taps on (.*)$", (String appConsumer, String screenName, String fieldName) -> {
//            WebElement webElement = new OptimusElementFinder(getDriverInstanceFor(appConsumer)).find(appConsumer, fieldName, screenName);
//            new DoubleTap(getDriverInstanceFor("user")).doubleTapOn(webElement);
//        });
//
//        And("^(.*) on (.*) screen navigates back$", (String appConsumer, String screenName) -> {
//            getDriverInstanceFor("traveller").navigate().back();
//        });
//
//        And("^(.*) on (.*) screen scrolls down and taps on (.*)$", (String appConsumer, String screenName, String fieldName) -> {
//            WebElement webElement = new OptimusElementFinder(getDriverInstanceFor(appConsumer)).find(appConsumer, fieldName, screenName);
//            Scroll scroll = new AndroidScroll(getDriverInstanceFor("user"));
//            scroll.downToAndTapOn(webElement);
//        });
//
//        And("^(.*) on (.*) screen scrolls up and taps on (.*)$", (String appConsumer, String screenName, String fieldName) -> {
//            WebElement webElement = new OptimusElementFinder(getDriverInstanceFor(appConsumer)).find(appConsumer, fieldName, screenName);
//            Scroll scroll = new AndroidScroll(getDriverInstanceFor("user"));
//            scroll.upToAndTapOn(webElement);
//        });
//
//        And("^(.*) on (.*) screen scrolls up to (.*)$", (String appConsumer, String screenName, String fieldName) -> {
//            WebElement webElement = new OptimusElementFinder(getDriverInstanceFor(appConsumer)).find(appConsumer, fieldName, screenName);
//            Scroll scroll = new AndroidScroll(getDriverInstanceFor("user"));
//            scroll.upTo(webElement);
//        });
//
//        And("^(.*) on (.*) screen scrolls down to (.*)$", (String appConsumer, String screenName, String fieldName) -> {
//            WebElement webElement = new OptimusElementFinder(getDriverInstanceFor(appConsumer)).find(appConsumer, fieldName, screenName);
//            Scroll scroll = new AndroidScroll(getDriverInstanceFor("user"));
//            scroll.downTo(webElement);
//        });
//
//        And("^(.*) on (.*) screen scrolls down$", (String appConsumer, String screenName) -> {
//            Scroll scroll = new AndroidScroll(getDriverInstanceFor("user"));
//            scroll.down();
//        });
//
//        And("^(.*) on (.*) screen scrolls up$", (String appConsumer, String screenName) -> {
//            Scroll scroll = new AndroidScroll(getDriverInstanceFor("user"));
//            scroll.up();
//        });
//
//        And("^(.*) on (.*) screen swipes left to (.*)$", (String appConsumer, String screenName, String fieldName) -> {
//            WebElement webElement = new OptimusElementFinder(getDriverInstanceFor(appConsumer)).find(appConsumer, fieldName, screenName);
//            Swipe swipe = new AndroidSwipe(getDriverInstanceFor("user"));
//            swipe.leftTo(webElement);
//        });
//        And("^(.*) on (.*) screen swipes right to (.*)$", (String appConsumer, String screenName, String fieldName) -> {
//            WebElement webElement = new OptimusElementFinder(getDriverInstanceFor(appConsumer)).find(appConsumer, fieldName, screenName);
//            Swipe swipe = new AndroidSwipe(getDriverInstanceFor("user"));
//            swipe.rightTo(webElement);
//        });
//
//        And("^(.*) on (.*) screen swipes left$", (String appConsumer, String screenName) -> {
//            Swipe swipe = new AndroidSwipe(getDriverInstanceFor("user"));
//            swipe.left();
//        });
//
//        And("^(.*) on (.*) screen swipes right$", (String appConsumer, String screenName) -> {
//            Swipe swipe = new AndroidSwipe(getDriverInstanceFor("user"));
//            swipe.right();
//        });
//
//        And("^(.*) on (.*) screen swipes right and taps on (.*)$", (String appConsumer, String screenName, String fieldName) -> {
//            WebElement webElement = new OptimusElementFinder(getDriverInstanceFor(appConsumer)).find(appConsumer, fieldName, screenName);
//            Swipe swipe = new AndroidSwipe(getDriverInstanceFor("user"));
//            swipe.rightToAndTapOn(webElement);
//        });
//
//        And("^(.*) on (.*) screen swipes left and taps on (.*)$", (String appConsumer, String screenName, String fieldName) -> {
//            WebElement webElement = new OptimusElementFinder(getDriverInstanceFor(appConsumer)).find(appConsumer, fieldName, screenName);
//            Swipe swipe = new AndroidSwipe(getDriverInstanceFor("user"));
//            swipe.leftToAndTapOn(webElement);
//        });
//
//        And("^(.*) on (.*) screen drags (.*) and drops it on (.*)$", (String appConsumer, String screenName, String fieldName1, String fieldName2) -> {
//            WebElement webElement1 = new OptimusElementFinder(getDriverInstanceFor(appConsumer)).find(appConsumer, fieldName1, screenName);
//            WebElement webElement2 = new OptimusElementFinder(getDriverInstanceFor(appConsumer)).find(appConsumer, fieldName2, screenName);
//            new DragAndDrop(getDriverInstanceFor("user")).dragAndDropItem(webElement1, webElement2);
//        });
//
//    }
//
//    private void setPickupDate(String fieldName, WebElement webElement1, WebElement webElement2, WebElement webElement3) {
//        String dayMonthYear = fieldName.toUpperCase();
//        if (dayMonthYear.equals(DAY)) {
//            new DateSelector(getDriverInstanceFor("user")).setDay(dayMonthYear, webElement1, webElement2, webElement3);
//        } else if (dayMonthYear.equals(MONTH)) {
//            new DateSelector(getDriverInstanceFor("user")).setMonth(dayMonthYear, webElement1, webElement2, webElement3);
//        } else if (dayMonthYear.equals(YEAR)) {
//            new DateSelector(getDriverInstanceFor("user")).setYear(dayMonthYear, webElement1, webElement2, webElement3);
//        }
//    }
//}
