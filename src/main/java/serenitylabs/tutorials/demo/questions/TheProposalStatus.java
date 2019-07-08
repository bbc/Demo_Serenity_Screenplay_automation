package serenitylabs.tutorials.demo.questions;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import static serenitylabs.tutorials.demo.targetlocators.TargetCreateProposal.PROPOSAL_STATUS;

public class TheProposalStatus implements Question<String> {

    @Override
    public String answeredBy(Actor theActor) {
        return Text.of(PROPOSAL_STATUS)
                   .viewedBy(theActor)
                   .resolve();
    }

    public static Question<String> displayed() {

        return new TheProposalStatus();
    }
}
