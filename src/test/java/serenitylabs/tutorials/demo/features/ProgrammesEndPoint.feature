
@test-demo
Feature: REST API

  Scenario: Confirm REST-API is available

    Given AMP request the /programmes rest-api end-point
    Then the REST API retrieves the correct data
    And check the value of programme xml

