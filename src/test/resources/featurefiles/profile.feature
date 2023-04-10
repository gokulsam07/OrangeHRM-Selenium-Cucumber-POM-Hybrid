Feature: Verify the list of features like about, support, logout
  Description: Verify if the profile option functionalities works as warranted

  Background: Go to login page
    Given user navigates to login page
    When user enters the username Admin
    And user enters the password admin123
    And click login button
    Then it should login as "Admin" and display the dashboard or display appropriate warning

  Scenario: Logout from the application
    When click "logout" button
    Then redirect to login page check

      Scenario: Check the about section
    When click "about" button
    Then check if the about card is closed
    
    Scenario: Check the about section
    When click "support" button
    Then check if redirected to support page