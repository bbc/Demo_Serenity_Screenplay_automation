package serenitylabs.tutorials.demo.targetlocators;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class TargetViewProposal {

    public static Target CONDITIONAL_COMMISSION = Target.the("Conditional Commission").located(By.id("btn-NetworkReceivedToConditionalCommission"));
    public static Target REJECT = Target.the("Reject").located(By.id("btn-NetworkReceivedToRejected"));
    public static Target RE_REQUEST = Target.the("Re-Request").located(By.id("btn-NetworkReceivedToRerequest"));
    public static Target SHORTLIST = Target.the("Shortlist").located(By.id("btn-NetworkReceivedToShortlisted"));
    public static Target CONDITIONAL_PILOT_COMMISSION = Target.the("Conditional Pilot Commission").located(By.id("btn-NetworkReceivedToConditionalPilotCommission"));
    public static Target NETWORK_RECEIVED = Target.the("Network Received").located(By.id("btn-ShortlistedToNetworkReceived"));

    public static Target CANCEL = Target.the("Cancel").located(By.id("btn-ConditionalCommissionToCommissionCancelled"));
    public static Target SUSPEND = Target.the("Suspend").located(By.id("btn-ConditionalCommissionToCommissionSuspended"));

    public static Target VIEW_AUDIT = Target.the("View Audit").located(By.id("btn-view-audit"));

    public static Target SUCCESSFULLY_CREATED_MESSAGE = Target.the("Successfully Created Message").located(By.className("actionMessage"));
    public static Target PROPOSAL_TITLE = Target.the("Proposal Title").located(By.tagName("h4"));
    public static Target COMMISSIONED_STATUS = Target.the("Commissioning Status of Proposal").located(By.cssSelector("h4:nth-child(1)"));

    public static Target PROPOSAL_INFO = Target.the("Proposal Information from First Table").located(By.id("proposalInformation1"));

    public static Target SUPPLIER_FEEDBACK = Target.the("Supplier Feedback").located(By.id("supplierNotesNewlines"));
    public static Target COMMISSIONING_EDITOR_FEEDBACK = Target.the("Commissioning Editor Feedback").located(By.id("feedbackNotesNewlines"));
    public static Target SCHEDULE_FEEDBACK = Target.the("Schedule Feedback").located(By.id("scheduleFeedbackNotesNewlines"));
    public static Target MANAGED_RISK_FEEDBACK = Target.the("Managed Risk Feedback").located(By.id("riskFeedbackNotesNewlines"));
    public static Target OTHER_FEEDBACK = Target.the("Other Feedback").located(By.id("otherFeedbackNotesNewlines"));

    public static Target PUBLIC_SUPPLIER_NOTES = Target.the("Short Synopsis").located(By.id("workingSupplierNotesNewlines"));
    public static Target PRIVATE_NOTES = Target.the("Short Synopsis").located(By.id("productionOnlyNotesNewlines"));
    public static Target SHORT_SYNOPSIS = Target.the("Short Synopsis").located(By.id("shortSynopsis"));
    public static Target FULL_SYNOPSIS = Target.the("Short Synopsis").located(By.id("fullSynopsis"));
    public static Target MULTIMEDIA = Target.the("Short Synopsis").located(By.id("multimedia"));

    public static Target getProposalTitleTarget(String proposalTitle) {
        return Target.the(proposalTitle).located(By.linkText(proposalTitle));
    }
}
