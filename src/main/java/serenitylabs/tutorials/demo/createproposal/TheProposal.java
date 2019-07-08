package serenitylabs.tutorials.demo.createproposal;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Question;
import net.serenitybdd.screenplay.questions.Text;
import serenitylabs.tutorials.demo.interaction.HTMLTableData;

import java.util.List;
import java.util.Map;
import static serenitylabs.tutorials.demo.targetlocators.TargetViewProposal.*;

public class TheProposal implements Question<ProposalInformation> {

    @Override
    public ProposalInformation answeredBy(Actor theActor) {
        List<Map<Integer, String>> proposalInformationFromTable = HTMLTableData.of(PROPOSAL_INFO).viewedBy(theActor).resolve();

        String supplierFeedback = Text.of(SUPPLIER_FEEDBACK).viewedBy(theActor).resolve();
        String commissioningEditorFeedback = Text.of(COMMISSIONING_EDITOR_FEEDBACK).viewedBy(theActor).resolve();
        String scheduleFeedback = Text.of(SCHEDULE_FEEDBACK).viewedBy(theActor).resolve();
        String managedRiskFeedback = Text.of(MANAGED_RISK_FEEDBACK).viewedBy(theActor).resolve();
        String otherFeedback = Text.of(OTHER_FEEDBACK).viewedBy(theActor).resolve();
        String publicSupplierNotes = Text.of(PUBLIC_SUPPLIER_NOTES).viewedBy(theActor).resolve();
        String privateNotes = Text.of(PRIVATE_NOTES).viewedBy(theActor).resolve();
        String shortSynopsis = Text.of(SHORT_SYNOPSIS).viewedBy(theActor).resolve();
        String fullSynopsis = Text.of(FULL_SYNOPSIS).viewedBy(theActor).resolve();
        String multimedia = Text.of(MULTIMEDIA).viewedBy(theActor).resolve();
        String proposalTitle = Text.of(PROPOSAL_TITLE).viewedBy(theActor).resolve();
        String commissioningStatus = Text.of(COMMISSIONED_STATUS).viewedBy(theActor).resolve();

        ProposalInformation proposalInformation = new ProposalInformation();
        proposalInformation.setProposalTitle(proposalTitle.trim());
        proposalInformation.setProposalNumber(proposalInformationFromTable.get(0).get(1).trim());
        proposalInformation.setSupplier(proposalInformationFromTable.get(1).get(1).trim());
        proposalInformation.setCommissioningInformation(proposalInformationFromTable.get(2).get(1).trim());
        proposalInformation.setCommissioningEditor(proposalInformationFromTable.get(3).get(1).trim());
        proposalInformation.setNetwork(proposalInformationFromTable.get(4).get(1).trim());
        proposalInformation.setManagedRisk(proposalInformationFromTable.get(5).get(1).trim());
        proposalInformation.setSupplierFeedback(supplierFeedback.trim());
        proposalInformation.setCommissioningEditorFeedback(commissioningEditorFeedback.trim());
        proposalInformation.setScheduleFeedback(scheduleFeedback.trim());
        proposalInformation.setManagedRiskFeedback(managedRiskFeedback.trim());
        proposalInformation.setOtherFeedback(otherFeedback.trim());
        proposalInformation.setPublicSupplierNotes(publicSupplierNotes.trim());
        proposalInformation.setPrivateNotes(privateNotes.trim());
        proposalInformation.setShortSynopsis(shortSynopsis.trim());
        proposalInformation.setFullSynopsis(fullSynopsis.trim());
        proposalInformation.setMultimedia(multimedia.trim());

        proposalInformation.setCommissioningStatus(commissioningStatus);

        return proposalInformation;
    }

    public static TheProposal information() {
        return new TheProposal();
    }
}
