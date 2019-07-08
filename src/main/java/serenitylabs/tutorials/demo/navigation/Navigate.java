package serenitylabs.tutorials.demo.navigation;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import serenitylabs.tutorials.demo.interaction.WaitForPageLoad;
import serenitylabs.tutorials.demo.targetlocators.TargetMenuHeader;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class Navigate implements Task {

    @Override
    public <T extends Actor> void performAs(T theActor) {
        theActor.attemptsTo(
                Click.on(TargetMenuHeader.COMMISSIONS),
                Click.on(TargetMenuHeader.COMMISSIONS_CREATE_PROPOSAL),
                WaitForPageLoad.toComplete()
        );
    }

    public static Navigate toCreateAProposal() {
        return instrumented(Navigate.class);
    }
}
