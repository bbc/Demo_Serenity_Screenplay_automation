package serenitylabs.tutorials.demo.login;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Performable;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.Open;
import serenitylabs.tutorials.demo.interaction.WaitForPageLoad;
import static net.serenitybdd.screenplay.Tasks.instrumented;
import static org.openqa.selenium.Keys.ENTER;

public class Login implements Task {

    private ProteusLoginPage loginPage;

    @Override
    public <T extends Actor> void performAs(T theActor) {

        theActor.attemptsTo(
                Open.browserOn().the(loginPage),
                WaitForPageLoad.toComplete(),
                Enter.theValue("****").into(TargetLogin.USERNAME),
                Enter.theValue("****").into(TargetLogin.PASSWORD).thenHit(ENTER)
        );
    }

    public static Performable asASuperNetworkUser() {
        return instrumented(Login.class);
    }
}
