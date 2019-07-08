package serenitylabs.tutorials.demo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import static serenitylabs.tutorials.demo.targetlocators.TargetViewProposal.SUCCESSFULLY_CREATED_MESSAGE;

public class TheNewProposalCreationConfirmationMessage implements Question<String> {

    @Override
    public String answeredBy(Actor theActor) {
        return Text.of(SUCCESSFULLY_CREATED_MESSAGE)
                .viewedBy(theActor)
                .asString();
    }

    public static TheNewProposalCreationConfirmationMessage text() {
        return new TheNewProposalCreationConfirmationMessage();
    }
}
