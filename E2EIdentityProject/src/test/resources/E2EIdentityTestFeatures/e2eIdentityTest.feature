@regression
Feature: Car Tax Check

  Scenario: Valid Registration 1
    Given I navigate to Car Tax Check Url:  "https://cartaxcheck.co.uk/"
    When I enter the car the registration number: "SG18HTN"
    And click Enter
    Then I am navigated to the vehicles details page with Url: "https://cartaxcheck.co.uk/free-car-check/?vrm=SG18HTN"
    And the following details are displayed
      |REGISTRATION| MAKE | MODEL |COLOR |YEAR|
      |SG18HTN     | Volkswagen |Golf Se Navigation Tsi Evo|White |2018|

    Scenario: Invalid Registration Number
      Given I navigate to Car Tax Check Url:  "https://cartaxcheck.co.uk/"
      When I enter the car the registration number: "BW57 BOW "
      And click Enter
      Then an alert with error message "Vehicle Not Found" is displayed