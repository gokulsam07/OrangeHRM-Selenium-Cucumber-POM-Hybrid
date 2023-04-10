Feature: Verify the side panel options
  Description: verify all the side panel options and search functionality of side panel

  Background: Login to app
    Given user navigates to login page
    When user enters the username Admin
    And user enters the password admin123
    And click login button
    Then it should login as "Admin" and display the dashboard or display appropriate warning

  Scenario: Check all the options are listed in side panel
  And all the options should be displayed in sidepanel
  
  Scenario: Check if toggle shrink button works as expected
  And click on the shrink toggle and verify behavaior
  
  Scenario: Check if toggle expand button works as expected
  And click on the expand toggle and verify behavaior
  
  Scenario Outline: Enter a keyword in search and see if the listed options is as per the keyword
    Then enter "<keyword>" and verify the options list

    Examples: 
      | keyword |
      | im      |
      | e       |
      | a       |
