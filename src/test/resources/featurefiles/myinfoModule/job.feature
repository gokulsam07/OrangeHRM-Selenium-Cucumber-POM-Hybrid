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

  Scenario: Check unable to interact with fields
    When user is in Jobs page
    And verify all data and user is not able to interact with any fields
