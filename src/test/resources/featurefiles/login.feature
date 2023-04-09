Feature: Login feature
  Verify if the login functionality works if valid credentials is furnished

  Scenario: Login with valid credentials
    Given user navigates to login page
    When user enters the username "Admin"
    And user enters the password "admin123"
    And click login button
    Then it should login and display the dashboard
