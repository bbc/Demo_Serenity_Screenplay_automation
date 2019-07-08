package serenitylabs.tutorials.demo.createproposal;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Interaction;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class TinyMCE implements Interaction {

    private String text;
    private Target target;

    public TinyMCE(Target target, String text) {
        this.text = text;
        this.target = target;
    }

    @Override
    public <T extends Actor> void performAs(T theActor) {
        WebElement targetElement = target.resolveFor(theActor);
        WebDriver driver = BrowseTheWeb.as(theActor).getDriver();

        driver.switchTo().frame(targetElement);
        driver.findElement(By.id("tinymce")).sendKeys(text);
        driver.switchTo().parentFrame();
    }

    public static TinyMCE on(Target target, String text) {
        return instrumented(TinyMCE.class, target, text);
    }
}
