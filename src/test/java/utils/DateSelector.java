package utils;

import io.appium.java_client.AppiumDriver;
import org.openqa.selenium.WebElement;

public class DateSelector {

    private AppiumDriver driver;

    public DateSelector(AppiumDriver driver) {
        this.driver = driver;
    }

    public void setDay(String dayMonthYear, WebElement day, WebElement decreaseDay, WebElement increaseDay) {
        try {
            day.clear();
            day.sendKeys(dayMonthYear);
        } catch (Exception e) {
            int presentDay = Integer.parseInt(day.getText());
            int requiredDay = Integer.parseInt(dayMonthYear);
            if (presentDay - requiredDay > 0) {
                int i = 0;
                while (i < (presentDay - requiredDay)) {
                    decreaseDay.click();
                }
            } else if (presentDay - requiredDay < 0) {
                int i = 0;
                while (i < (Math.abs(presentDay - requiredDay))) {
                    increaseDay.click();
                }
            }
        }
    }

    public void setMonth(String dayMonthYear, WebElement month, WebElement decreaseMonth, WebElement increaseMonth) {
        try {
            month.sendKeys(dayMonthYear);
        } catch (Exception e) {

        }
    }

    public void setYear(String dayMonthYear, WebElement year, WebElement decreaseYear, WebElement increaseMonth) {
        try {
            year.sendKeys(dayMonthYear);
        } catch (Exception e) {

        }
    }

}
