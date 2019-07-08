package serenitylabs.tutorials.demo.stepdefinitions;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import net.serenitybdd.junit.runners.SerenityRunner;
import net.serenitybdd.rest.Ensure;
import net.serenitybdd.rest.SerenityRest;
import org.apache.http.HttpStatus;
import org.hamcrest.Matchers;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import restapi.SetupApi;
import static net.serenitybdd.rest.SerenityRest.*;
import static org.hamcrest.CoreMatchers.*;
//https://proteusuat-rest.national.core.bbc.co.uk/proteus-rest/api/v1/programmes/0217FB52-56A6-4D33-9052-042112476453

@RunWith(SerenityRunner.class)
public class RestApiSerenityStarter {

    private static String endPoint;

    @Before
    public void setUrl()
    {
        try {
            SetupApi.initialiseSSLSocketFactory();
            RestAssured.baseURI = "https://proteusuat-rest.national.core.bbc.co.uk/proteus-rest/api/v1/";
            endPoint = "programmes/0217FB52-56A6-4D33-9052-042112476453";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void test_simple_rest_api_test()
    {

        when().get(endPoint).then().statusCode(200);
        then().body("programme.title", Matchers.equalTo("Dominoes Goes Home"))
            .and().body("programme.production_team.production_member.full_name", Matchers.equalTo("David Prest"));
    }

    /**
     * This will demonstrate how we can verify the values from body using Hamcrest matcher method.
     * We did static import here therefore we don't need to specify SerenityRest.when()
     * when() can come from several places but we are using SerenityRest() is wrapper around the RestAssured API that gives  you extra reporting capability
     */
    @Test
    public void test_the_values_from_response_way1()
    {
        when().get(endPoint)
                .then().body("programme.title", Matchers.equalTo("Dominoes Goes Home"))
                .and().body("programme.production_team.production_member.full_name", Matchers.equalTo("David Prest"));
    }


    /**
     *  This will demonstrate how can we use Ensure.that() method to see nice report
     *  And how can we pass parameter to get() method
     */
    @Test
    public void how_to_use_param_in_verifying_response()
    {
        when().get("programmes/{prom_uuid}", "0217FB52-56A6-4D33-9052-042112476453").then().statusCode(HttpStatus.SC_OK);
        Ensure.that("Correct title should be shown", response -> response.body("programme.title", equalTo("Dominoes Goes Home")));
        Ensure.that("Correct full name should be shown", response -> response.body("programme.production_team.production_member.full_name", equalTo("David Prest")));
    }

    /**
     *  This will demonstrate how can we use Ensure.that() method to see nice report
     *  And how can we pass parameter to get() method
     */
    @Test
    public void another_way_to_pass_parameter_using_path_param()
    {
        given().pathParam("prom_uuid","0217FB52-56A6-4D33-9052-042112476453").
        when().get("programmes/{prom_uuid}").then().statusCode(HttpStatus.SC_OK);
        Ensure.that("Correct title should be shown", response -> response.body("programme.title", equalTo("Dominoes Goes Home")));
        Ensure.that("Correct full name should be shown", response -> response.body("programme.production_team.production_member.full_name", equalTo("David Prest")));
    }

    @Test
    public void test_last_response_method()
    {
        given().pathParam("prom_uuid","0217FB52-56A6-4D33-9052-042112476453").
        when().get("programmes/{prom_uuid}").then().statusCode(HttpStatus.SC_OK);

        // Verify hasItem() & notNullValue Hamcrest matchers
        Ensure.that("First id should return programme id", response -> response.body("programme.ids.id", hasItems("PEC05000004","0217FB52-56A6-4D33-9052-042112476453")))
        .andThat("Programme is should not be empty",response -> response.body("programme.ids.id[1]", notNullValue()));

        // verify content type
        then().contentType(ContentType.XML);

        // Verify response header()
        then().header("Content-Type","application/xml;charset=UTF-8");


        // using headers() method
        then().contentType(ContentType.XML).headers("Content-Type","application/xml;charset=UTF-8",
                        "Connection","close", "Transfer-Encoding","chunked");

        // checking cookies
        then().cookie("JSESSIONID",notNullValue());

        // check cookies using lastResponse() method
        System.out.println("JSESSIONID cookies:" + SerenityRest.lastResponse().cookie("JSESSIONID"));
    }
}
