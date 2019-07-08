package serenitylabs.tutorials.demo.login;

import net.serenitybdd.core.pages.PageObject;
import net.thucydides.core.annotations.DefaultUrl;
import net.thucydides.core.annotations.WhenPageOpens;
import org.openqa.selenium.WebDriverException;

@DefaultUrl("http://proteustest.national.core.bbc.co.uk/proteus-web/login.action")
public class ProteusLoginPage extends PageObject {

  @WhenPageOpens
    public void whenPageOpens() {
        try {
            getDriver().manage().window().fullscreen();
        } catch (WebDriverException e) {
           System.out.println(e.getMessage());
        }
    }
}
