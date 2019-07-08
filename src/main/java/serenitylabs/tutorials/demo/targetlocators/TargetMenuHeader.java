package serenitylabs.tutorials.demo.targetlocators;

import net.serenitybdd.core.annotations.findby.By;
import net.serenitybdd.screenplay.targets.Target;

public class TargetMenuHeader {

    public static Target COMMISSIONS = Target.the("Commissions").located(By.linkText("Commissions"));
    public static Target COMMISSIONS_CREATE_PROPOSAL = Target.the("Create a Proposal").located(By.linkText("Create a Proposal"));
}
