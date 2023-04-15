Feature: Personal details - my Info Module
  Verify the fields in personal details

  Background: Login to app
    Given user navigates to login page
    When user enters the username Admin
    And user enters the password admin123
    And click login button
    Then it should login as "Admin" and display the dashboard or display appropriate warning
    When user selects myInfo module
    Then focus should be in myInfo module

  Scenario: Check details in personal details page
  When user is in Personal details page
  Then edit the details and save
  And verify the modified details
    

   