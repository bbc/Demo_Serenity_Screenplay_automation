package serenitylabs.tutorials.demo.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import serenitylabs.tutorials.demo.interaction.ClickAllegedElement;

public class WaitForWelcomeMessage implements Task {

    @Override
    public <T extends Actor> void performAs(T theActor) {
        theActor.attemptsTo(
                ClickAllegedElement.onHomePage()
        );
    }

    public static WaitForWelcomeMessage andClose() {
        return new WaitForWelcomeMessage();
    }
}
