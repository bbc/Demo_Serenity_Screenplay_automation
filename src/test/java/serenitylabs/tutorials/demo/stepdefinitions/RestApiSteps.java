package serenitylabs.tutorials.demo.stepdefinitions;

import cucumber.api.java.Before;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import org.hamcrest.Matchers;
import org.simpleframework.xml.Serializer;
import org.simpleframework.xml.core.Persister;
import restapi.ProgrammeApiResponse;
import restapi.SetupApi;
import static net.serenitybdd.rest.SerenityRest.when;

public class RestApiSteps {

    private static String programmeUuid;

    @Before
    public static void setUrl()
    {
        try {
            SetupApi.initialiseSSLSocketFactory();
            RestAssured.baseURI = "https://proteusuat-rest.national.core.bbc.co.uk/proteus-rest/api/v1/";
            programmeUuid = "programmes/5F3C704F-3786-4F6B-ABE9-89975BE8A6D8";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Given("AMP request the /programmes rest-api end-point")
    public void programmes_end_point() throws Exception {
         when().get(programmeUuid)
                .then().statusCode(200);
        System.out.println("Status code: "+ when().get("programmes/5F3C704F-3786-4F6B-ABE9-89975BE8A6D8").getStatusCode()+ "\nstatus Line: "+ when().get("programmes/5F3C704F-3786-4F6B-ABE9-89975BE8A6D8").getStatusLine());

    }

    @And("^check the value of programme xml$")
    public void checkTheValueOfProgrammeXml() {
        when().get(programmeUuid).then().statusCode(200).and().body("programme.programme_number", Matchers.equalTo("PEO06000004"));
    }

    @Then("the REST API retrieves the correct data")
    public void the_rest_api_retrieves_the_correct_data() throws Exception {

        Response response = when().get(programmeUuid);
        response.prettyPrint();
        Serializer serializer = new Persister();
        ProgrammeApiResponse read = serializer.read(ProgrammeApiResponse.class, response.prettyPrint(), false);

        System.out.println(read.getError());
    }
}
