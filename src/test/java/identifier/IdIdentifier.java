package identifier;

import identifier.ElementIdentifier;
import org.openqa.selenium.By;

public class IdIdentifier implements ElementIdentifier {

    @Override
    public By getLocator(String value) {
        return By.id(value);
    }
}
