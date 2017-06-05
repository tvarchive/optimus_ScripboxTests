package interfaces;

import org.openqa.selenium.WebElement;

public interface Swipe {
    void left();

    void right();

    void leftTo(WebElement webElement);

    void rightTo(WebElement webElement);

    void leftToAndTapOn(WebElement webElement);

    void rightToAndTapOn(WebElement webElement);
}
