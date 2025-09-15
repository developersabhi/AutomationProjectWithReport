Feature: Here we are check the login the page with different data.

  Scenario: Scenario_1: Verify login the User with username and password.
    Given User load the login page.
    Then User enter the correct username and password.
    Then User click on the "submit" button.
    Then Verify the home page.