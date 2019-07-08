package serenitylabs.tutorials.demo.interaction;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class WaitForPageLoad implements Interaction {

    private static final Logger LOGGER = LoggerFactory.getLogger("");

    @Override
    public <T extends Actor> void performAs(T theActor) {
        WebDriver driver = BrowseTheWeb.as(theActor).getDriver();

        Boolean complete = new WebDriverWait(driver, 30).until((ExpectedCondition<Boolean>) wd ->
                ((JavascriptExecutor) wd).executeScript("return document.readyState").equals("complete"));

        LOGGER.info("Status of WaitForPageLoad.toComplete() = " + complete);
    }

    public static Interaction toComplete() {
        return instrumented(WaitForPageLoad.class);
    }

}
