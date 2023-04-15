Feature: Contact details - my Info Module
  update the fields in contact details

  Background: Login to app
    Given user navigates to login page
    When user enters the username Admin
    And user enters the password admin123
    And click login button
    Then it should login as "Admin" and display the dashboard or display appropriate warning
    When user selects myInfo module
    Then focus should be in myInfo module

  Scenario: Check details in emergency contacts page, add & delete contacts
    When user is in Emergency contacts page
    And verify there is no record
    Then add emergency contact and verify
    And delete and reverify
