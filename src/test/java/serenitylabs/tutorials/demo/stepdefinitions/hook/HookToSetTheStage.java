package serenitylabs.tutorials.demo.stepdefinitions.hook;

import cucumber.api.java.Before;
import net.serenitybdd.core.Serenity;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;

public class HookToSetTheStage {

    /**
     * Set the stage hook executes after all other hooks have completed.
     */
    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());

        Serenity.getCurrentSession().clear();
    }

}
