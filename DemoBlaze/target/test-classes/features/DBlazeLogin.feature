Feature: Verify DemoBlaze application

@testcase1
  Scenario: Verify the URL for DemoBlaze on google browser
    Given the user navigates to the DemoBlaze application
    When the user opens the application on google browser
    Then the URL should be "https://www.demoblaze.com" on the google browser
 @testcase2   
    Scenario: Verify that the user redirects to the sign-up page
    Given the user is on the Demoblaze application home page
    When the user clicks on the sign-up link
    Then the user should be redirected to the sign-up page
 @testcase3
    Scenario: Verify that the user enters the valid user name
    Given the user is on the Demoblaze sign-up page
    When the user enters a valid username
    