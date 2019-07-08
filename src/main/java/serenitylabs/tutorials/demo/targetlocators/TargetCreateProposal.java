package serenitylabs.tutorials.demo.targetlocators;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;



public class TargetCreateProposal {

    public static Target NETWORK = Target.the("Network drop-down box").located(By.id("networkId"));
    public static Target PROPOSAL_TITLE = Target.the("Proposal Title").located(By.id("proposalTitle"));
    public static Target COMM_YEAR_ROUND_SELECTION = Target.the("Commissioning Year / Round").located(By.id("commissioningYearRound"));
    public static Target COMM_BRIEF = Target.the("Commissioning Brief").located(By.id("commissioningRoundBrief"));
    public static Target SUPPLIER = Target.the("Supplier").located(By.id("organisationId"));
    public static Target PROPOSED_EPISODES = Target.the("Proposed Episodes").located(By.id("proposedEpisodes"));
    public static Target PROPOSED_DURATION = Target.the("Proposed Duration in Minutes").located(By.id("proposedDurationInMinutes"));
    public static Target PRICE_PER_EPISODE = Target.the("Proposed Price Per Episode").located(By.id("proposedPricePerEpisodeInPounds"));
    public static Target PRODUCER = Target.the("Producer").located(By.id("proposal.producer"));
    public static Target EXECUTIVE_PRODUCER = Target.the("Executive Producer").located(By.id("proposal.executiveProducer"));
    public static Target PRESENTER = Target.the("Presenter").located(By.id("proposal.presenter"));
    public static Target AUTHOR = Target.the("Author").located(By.id("proposal.author"));
    public static Target ADAPTATION_BY = Target.the("Adaptation By").located(By.id("proposal.adaptationBy"));
    public static Target DIRECTOR_EDITOR = Target.the("Director").located(By.id("proposal.director"));
    public static Target PROPOSED_DELIVERY_DATE = Target.the("Proposed Delivery Date").located(By.id("proposedDeliveryDate"));

    public static Target SUPPLIER_NOTES = Target.the("Supplier Notes").located(By.id("workingSupplierNotes"));
    public static Target PRIVATE_NOTES = Target.the("Production Only Notes").located(By.id("productionOnlyNotes"));
    public static Target SUBMIT = Target.the("Save Proposal as Draft").located(By.id("btn-submit"));
    public static Target PROPOSAL_SHORT_SYNOPSIS = Target.the("Short Synopsis").located(By.id("shortSynopsis_ifr"));
    public static Target PROPOSAL_SHORT_SYNOPSIS_VALIDATION = Target.the("Short Synopsis").located(By.className("mce-container"));

    public static Target PROPOSAL_STATUS = Target.the("Proposal Status").located(By.tagName("h5"));
    public static Target PROPOSAL_NUMBER = Target.the("Proposal Number").located(By.id("proposalNumber"));
}
