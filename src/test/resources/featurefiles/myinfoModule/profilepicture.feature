Feature: Profile picture - my Info Module
  Verify positive & negative scenarios in profile picture upoad

  Background: Login to app
    Given user navigates to login page
    When user enters the username Admin
    And user enters the password admin123
    And click login button
    Then it should login as "Admin" and display the dashboard or display appropriate warning
    When user selects myInfo module
    Then focus should be in myInfo module
    When user is in profile picture page

  Scenario: Upload valid file and verify
  Then upload the "valid file" and verify
  
  
  Scenario Outline: Upload invalid and verify
    Then upload the "<filetype>" and verify

    Examples: 
      | filetype          |
      | big file          |
      | incompatible file |
      | no file           |
