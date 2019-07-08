package serenitylabs.tutorials.demo.login;

import net.serenitybdd.screenplay.targets.Target;
import org.openqa.selenium.By;

public class TargetLogin {

    public static Target USERNAME = Target.the("username field").located(By.id("username"));
    public static Target PASSWORD = Target.the("password field").located(By.id("password"));
    public static Target LOGIN_BUTTON = Target.the("login button").located(By.name("submit"));
    public static Target TANDC_CHECK_BOX = Target.the("terms and condition chckbox").located(By.className("revisited-checkbox__label"));
    public static Target OTP_CODE = Target.the("enter otp").located(By.id("code"));
    public static Target VERIFY_OTP = Target.the("verify otp button").located(By.xpath("//input[@id='submit'][@type='submit']"));

}
