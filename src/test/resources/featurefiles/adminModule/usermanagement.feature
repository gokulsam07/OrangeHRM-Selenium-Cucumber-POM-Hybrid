Feature: User Management - Admin Module
  Check all options in user management of admin module is working as expected

  Background: Login to app
    Given user navigates to login page
    When user enters the username Admin
    And user enters the password admin123
    And click login button
    Then it should login as "Admin" and display the dashboard or display appropriate warning

  #Scenario: Search for employee in user management module
    #When user selects Admin module
    #Then focus should be in Admin module
    #And user enters username Admin in the username field and clicks search to verify
    
    Scenario: Search for employee in user management module and reset search
    When user selects Admin module
    Then focus should be in Admin module
    And user enters username Admin in the username field and clicks search to verify
    Then user clicks on reset to verify reset
