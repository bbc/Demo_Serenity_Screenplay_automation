package serenitylabs.tutorials.demo.interaction;

import com.google.common.base.Function;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.FluentWait;
import org.openqa.selenium.support.ui.Wait;

import java.time.Duration;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class ClickAllegedElement implements Interaction {

    @Override
    public <T extends Actor> void performAs(T theActor) {
        boolean isVisible;

        try {
            WebDriver driver = BrowseTheWeb.as(theActor).getDriver();

            Wait<WebDriver> wait = new FluentWait<>(driver)
                    .withTimeout(Duration.ofSeconds(5))
                    .pollingEvery(Duration.ofSeconds(5))
                    .ignoring(NoSuchElementException.class);

            isVisible = wait.until(new Function<WebDriver, Boolean>() {
                @Override
                public Boolean apply(WebDriver driver1) {

                    return driver1.findElement(By.cssSelector("#newsMessage #ok"))
                            .getCssValue("display")
                            .contains("block");
                }
            });
            if (isVisible) {
                WebElement closeBtn = driver.findElement(By.cssSelector("#newsMessage #ok"));
                closeBtn.click();
            }

        } catch (TimeoutException e) {
            // LOGGER.info("Country lightbox did not appear");
        }
    }

    public static ClickAllegedElement onHomePage() {
        return instrumented(ClickAllegedElement.class);
    }
}
