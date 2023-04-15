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

  Scenario: Check details in contact details page
    When user is in Contact details page
    Then fill the details save and verify
