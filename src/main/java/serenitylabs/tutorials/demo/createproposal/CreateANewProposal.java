package serenitylabs.tutorials.demo.createproposal;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.Click;
import net.serenitybdd.screenplay.actions.Enter;
import net.serenitybdd.screenplay.actions.SelectFromOptions;
import serenitylabs.tutorials.demo.targetlocators.TargetCreateProposal;

import static net.serenitybdd.screenplay.Tasks.instrumented;

public class CreateANewProposal implements Task {

    private Proposal proposal;

    public CreateANewProposal(Proposal proposal) {
        this.proposal = proposal;
    }

    @Override
    public <T extends Actor> void performAs(T theActor) {

        theActor.attemptsTo(
                Enter.theValue(proposal.getTitle()).into(TargetCreateProposal.PROPOSAL_TITLE),
                SelectFromOptions.byValue(proposal.getNetwork()).from(TargetCreateProposal.NETWORK),
                SelectFromOptions.byValue("20202021;5").from(TargetCreateProposal.COMM_YEAR_ROUND_SELECTION),
                SelectFromOptions.byVisibleText("47019 - Afternoon Drama").from(TargetCreateProposal.COMM_BRIEF),
                Enter.theValue(String.valueOf(proposal.getProposedEpisodes())).into(TargetCreateProposal.PROPOSED_EPISODES),
                Enter.theValue(String.valueOf(proposal.getProposedDuration())).into(TargetCreateProposal.PROPOSED_DURATION),
                Enter.theValue(proposal.getProposedDeliveryDate()).into(TargetCreateProposal.PROPOSED_DELIVERY_DATE),
                Click.on(TargetCreateProposal.DIRECTOR_EDITOR),
                TinyMCE.on(TargetCreateProposal.PROPOSAL_SHORT_SYNOPSIS, proposal.getShortSynopsis()),
                Click.on(TargetCreateProposal.SUBMIT)
        );
    }

    public static CreateANewProposal withThisInformation(Proposal proposal) {
        return instrumented(CreateANewProposal.class, proposal);
    }
}
