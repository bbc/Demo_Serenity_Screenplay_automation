package serenitylabs.tutorials.demo.stepdefinitions;

import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import org.hamcrest.Matchers;
import serenitylabs.tutorials.demo.createproposal.*;
import serenitylabs.tutorials.demo.login.Login;
import serenitylabs.tutorials.demo.login.WaitForWelcomeMessage;
import serenitylabs.tutorials.demo.navigation.Navigate;
import serenitylabs.tutorials.demo.questions.TheNewProposalCreationConfirmationMessage;
import serenitylabs.tutorials.demo.questions.TheProposalStatus;
import serenitylabs.tutorials.demo.session.SessionData;
import static net.serenitybdd.screenplay.actors.OnStage.theActorCalled;
import static net.serenitybdd.screenplay.actors.OnStage.theActorInTheSpotlight;
import static net.serenitybdd.screenplay.matchers.ConsequenceMatchers.displays;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.core.Is.is;
import static net.serenitybdd.screenplay.GivenWhenThen.seeThat;

public class CreateProposalSteps {

    @Given("A Production User is logged in")
    public void a_production_user_is_logged_into_proteus() {
        theActorCalled("Production Super User").wasAbleTo(
                Login.asASuperNetworkUser(),
                WaitForWelcomeMessage.andClose()
        );
    }

    @And("I create a new proposal and submit to departmental")
    public void i_create_a_new_proposal() {

        Proposal proposal = new ProposalBuilder().build();
        SessionData.INSTANCE.setSupplierProposal(proposal);

        theActorInTheSpotlight().attemptsTo(
                Navigate.toCreateAProposal(),
                CreateANewProposal.withThisInformation(proposal)
        );
    }

    @Then("^Proposal should be created successfully$")
    public void proposalShouldBeCreatedSuccessfully() {
        Proposal proposal = SessionData.INSTANCE.getSupplierProposal();

                ProposalInformation proposalInformation = theActorInTheSpotlight().asksFor(
                TheProposal.information()
        );

        theActorInTheSpotlight().should(
                seeThat(TheProposal.information(),
                        displays("proposalTitle", Matchers.equalTo(proposal.getTitle())),
                        displays("shortSynopsis", Matchers.equalTo(proposal.getShortSynopsis())),
                        displays("commissioningStatus", Matchers.equalTo("Not Commissioned"))
                )
        );

        String assertProposalConfirmationMessage = "The Proposal " + proposalInformation.getProposalNumber() + " was added successfully";

        theActorInTheSpotlight().should(
                seeThat(TheNewProposalCreationConfirmationMessage.text(), is(equalTo(assertProposalConfirmationMessage))),
                seeThat(TheProposalStatus.displayed(), is(equalTo("Status - Private")))
        );
    }
}
