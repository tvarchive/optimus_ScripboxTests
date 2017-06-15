package steps;

import com.testvagrant.commons.exceptions.OptimusException;
import com.testvagrant.stepdefs.exceptions.NoSuchEventException;
import com.testvagrant.stepdefs.steps.BaseSteps;
import cucumber.api.PendingException;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;

import static com.testvagrant.stepdefs.core.Tapster.tapster;


public class GenericSteps1 extends BaseSteps{
    @Given("^(\\w+)\\s+on\\s+(\\w+)\\s+screen\\s+(\\w+)\\s+on\\s+(\\w+)\\s+value\\s+(.*)$")
    public void consumerOnScreenPerformsActionOnElementWithValue(String consumer, String screen, String action, String element, String value) throws NoSuchEventException, OptimusException {
        tapster().useDriver(getDriverInstanceFor(consumer))
                .asConsumer(consumer)
                .onScreen(screen)
                .onElement(element)
                .doAction(action)
                .withValue(value)
                .serve();
    }

    @And("^(\\w+)\\s+on\\s+(\\w+)\\s+screen\\s+(\\w+)\\s+on\\s+(\\w+)$")
    public void consumerOnScreenPerformsActionOnElement(String consumer, String screen, String action, String element) throws OptimusException, NoSuchEventException {
       tapster().useDriver(getDriverInstanceFor(consumer))
               .onScreen(screen)
               .asConsumer(consumer)
               .onElement(element)
               .doAction(action)
               .serve();
    }
}
