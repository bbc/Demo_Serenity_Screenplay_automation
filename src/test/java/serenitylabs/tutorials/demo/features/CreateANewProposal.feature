
@test-demo
Feature: Create proposal

  In order to submit my ideas as a proposal As a Production user I want to be able to submit my proposal to department So that my ideas should be submitted

  Scenario: Production user creates a proposal and verify proposal created successfully
    Given A Production User is logged in
    When I create a new proposal and submit to departmental
    Then Proposal should be created successfully
