package interfaces;


import org.openqa.selenium.WebElement;

public interface Scroll {

    void downTo(WebElement webElement);

    void upTo(WebElement webElement);

    void downToAndTapOn(WebElement webElement);

    void upToAndTapOn(WebElement webElement);

    void up();

    void down();

}
