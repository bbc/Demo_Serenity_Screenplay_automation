import cucumber.api.CucumberOptions;
import net.serenitybdd.cucumber.CucumberWithSerenity;
import org.junit.runner.RunWith;

@RunWith(CucumberWithSerenity.class)
@CucumberOptions(features = "src/test/java/serenitylabs/tutorials/demo/features", tags = "@JIRA-proteus-rest-api")
public class RunnerClass {}
