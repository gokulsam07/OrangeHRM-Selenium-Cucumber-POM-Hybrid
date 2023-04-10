Feature: Login feature
  Description: Verify if the login functionality works if valid credentials is furnished

  Background: Go to login page
    Given user navigates to login page

  Scenario Outline: Login with valid & invalid credentials
    When user enters the username <username>
    And user enters the password <password>
    And click login button
    Then it should login as <username> and display the dashboard or display appropriate warning

    Examples: 
      | username   | password  |
      | Admin      | admin123  |
      | gokulsam07 | Gokul@123 |

  Scenario: Login without credentials
    And click login button
    Then display appropriate warning
    