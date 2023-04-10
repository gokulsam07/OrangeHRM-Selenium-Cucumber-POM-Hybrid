Feature: Verify the side panel option
  Description: verify all the side panel options and search functionality of side panel

  Background: Login to app 
    Given user navigates to login page
    When user enters the username "Admin"
    And user enters the password "admin123"
    And click login button
    Then it should login as "Admin" and display the dashboard or display appropriate warning
    
    Scenario: Check all the options are listed in side panel
    And all the options should be displayed in sidepanel
