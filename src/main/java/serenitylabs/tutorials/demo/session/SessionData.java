package serenitylabs.tutorials.demo.session;

import net.serenitybdd.core.Serenity;
import serenitylabs.tutorials.demo.createproposal.Proposal;

public enum SessionData {

    INSTANCE;

    protected void putIntoSession(String key, Object value) {
        Serenity.setSessionVariable(key).to(value);
    }

    protected Object getFromSession(String key) {

        return Serenity.sessionVariableCalled(key);
    }

    public void setSupplierProposal(Proposal proposal) {
        putIntoSession("supplierProposal", proposal);
    }

    public Proposal getSupplierProposal() {
        return (Proposal) getFromSession("supplierProposal");
    }

}
