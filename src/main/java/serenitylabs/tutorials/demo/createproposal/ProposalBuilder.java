package serenitylabs.tutorials.demo.createproposal;

import java.time.LocalDateTime;

public class ProposalBuilder {

    private String network = "400";
    private String title = "Proposal Title from Automation";
    private int proposedEpisodes = 1;
    private int proposedDuration = 300;
    private String proposedDeliveryDate = "01/01/2020";
    private String shortSynopsis = "A short synopsis";
    private String workingSupplierNotesPublic = "Kitchen calls this the Create Action and several subcommands that we'll learn about later map directly to other actions. If you are a Vagrant user then the line containing vagrant up --no-provision will look familiar.";
    private String workingFeedbackNotes = "Lorem ipsum dolor sit amet, consectetur adipiscing elit, sed do eiusmod tempor incididunt ut labore et dolore magna aliqua. Ut enim ad minim veniam, quis nostrud exercitation ullamco laboris nisi ut aliquip ex ea commodo consequat. Duis aute irure dolor in reprehenderit in voluptate velit esse cillum dolore eu fugiat nulla pariatur. Excepteur sint occaecat cupidatat non proident, sunt in culpa qui officia deserunt mollit anim id est laborum.";
    private String workingScheduleFeedbackNotes = "Sed ut perspiciatis unde omnis iste natus error sit voluptatem accusantium doloremque laudantium, totam rem aperiam, eaque ipsa quae ab illo inventore veritatis et quasi architecto beatae vitae dicta sunt explicabo. Nemo enim ipsam voluptatem quia voluptas sit aspernatur aut odit aut fugit, sed quia consequuntur magni dolores eos qui ratione voluptatem sequi nesciunt. Neque porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci velit, sed quia non numquam eius modi tempora incidunt ut labore et dolore magnam aliquam quaerat voluptatem. Ut enim ad minima veniam, quis nostrum exercitationem ullam corporis suscipit laboriosam, nisi ut aliquid ex ea commodi consequatur? Quis autem vel eum iure reprehenderit qui in ea voluptate velit esse quam nihil molestiae consequatur, vel illum qui dolorem eum fugiat quo voluptas nulla pariatur?";
    private String workingRiskFeedbackNotes = "At vero eos et accusamus et iusto odio dignissimos ducimus qui blanditiis praesentium voluptatum deleniti atque corrupti quos dolores et quas molestias excepturi sint occaecati cupiditate non provident, similique sunt in culpa qui officia deserunt mollitia animi, id est laborum et dolorum fuga. Et harum quidem rerum facilis est et expedita distinctio. Nam libero tempore, cum soluta nobis est eligendi optio cumque nihil impedit quo minus id quod maxime placeat facere possimus, omnis voluptas assumenda est, omnis dolor repellendus. Temporibus autem quibusdam et aut officiis debitis aut rerum necessitatibus saepe eveniet ut et voluptates repudiandae sint et molestiae non recusandae. Itaque earum rerum hic tenetur a sapiente delectus, ut aut reiciendis voluptatibus maiores alias consequatur aut perferendis doloribus asperiores repellat.";
    private String workingOtherFeedbackNotes = "On the other hand, we denounce withNoRepeats righteous indignation and dislike men who are so beguiled and demoralized by the charms of pleasure of the moment, so blinded by desire, that they cannot foresee the pain and trouble that are bound to ensue; and equal blame belongs to those who fail in their duty through weakness of will, which is the same as saying through shrinking from toil and pain. These cases are perfectly simple and easy to distinguish. In a free hour, when our power of choice is untrammelled and when nothing prevents our being able to do what we like best, every pleasure is to be welcomed and every pain avoided. But in certain circumstances and owing to the claims of duty or the obligations of business it will frequently occur that pleasures have to be repudiated and annoyances accepted. The wise man therefore always holds in these matters to this principle of selection: he rejects pleasures to secure other greater pleasures, or else he endures pains to avoid worse pains.";
    private String futureStatus = "";

    public ProposalBuilder withTitle(String title) {
        this.title = title;

        return this;
    }

    public ProposalBuilder withProposedEpisodes(int proposedEpisodes) {
        this.proposedEpisodes = proposedEpisodes;

        return this;
    }

    public ProposalBuilder withProposedDuration(int proposedDuration) {
        this.proposedDuration = proposedDuration;

        return this;
    }

    public ProposalBuilder withProposedDeliveryDate(String proposedDeliveryDate) {
        this.proposedDeliveryDate = proposedDeliveryDate;

        return this;
    }

    public ProposalBuilder withShortSynopsis(String shortSynopsis) {
        this.shortSynopsis = shortSynopsis;

        return this;
    }

    public ProposalBuilder withWorkingFeedbackNotes(String workingFeedbackNotes) {
        this.workingFeedbackNotes = workingFeedbackNotes;

        return this;
    }

    public ProposalBuilder withWorkingScheduleFeedbackNotes(String workingScheduleFeedbackNotes) {
        this.workingScheduleFeedbackNotes = workingScheduleFeedbackNotes;

        return this;
    }

    public ProposalBuilder withWorkingRiskFeedbackNotes(String workingRiskFeedbackNotes) {
        this.workingRiskFeedbackNotes = workingRiskFeedbackNotes;

        return this;
    }

    public ProposalBuilder withWorkingOtherFeedbackNotes(String workingOtherFeedbackNotes) {
        this.workingOtherFeedbackNotes = workingOtherFeedbackNotes;

        return this;
    }

    public ProposalBuilder withWorkingSupplierNotesPublic(String workingSupplierNotesPublic) {
        this.workingSupplierNotesPublic = workingSupplierNotesPublic;

        return this;
    }

    public ProposalBuilder withNoFeedbackNotes() {
        this.workingFeedbackNotes = "";
        this.workingScheduleFeedbackNotes = "";
        this.workingRiskFeedbackNotes = "";
        this.workingOtherFeedbackNotes = "";

        return this;
    }

    public ProposalBuilder withFutureStatus(String futureStatus) {
        this.futureStatus = futureStatus;
        return this;
    }

    public Proposal build() {
        Proposal proposal = new Proposal();

        proposal.setNetwork(this.network);
        proposal.setTitle(this.title);
        proposal.setProposedEpisodes(this.proposedEpisodes);
        proposal.setProposedDuration(this.proposedDuration);
        proposal.setProposedDeliveryDate(this.proposedDeliveryDate);
        proposal.setShortSynopsis(this.shortSynopsis);
        proposal.setWorkingSupplierNotesPublic(this.workingSupplierNotesPublic);
        proposal.setWorkingFeedbackNotes(this.workingFeedbackNotes);
        proposal.setWorkingScheduleFeedbackNotes(this.workingScheduleFeedbackNotes);
        proposal.setWorkingRiskFeedbackNotes(this.workingRiskFeedbackNotes);
        proposal.setWorkingOtherFeedbackNotes(this.workingOtherFeedbackNotes);
        proposal.setFutureStatus(this.futureStatus);

        return proposal;
    }
}
