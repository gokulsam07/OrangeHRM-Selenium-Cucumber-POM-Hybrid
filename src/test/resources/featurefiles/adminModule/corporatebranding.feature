Feature: Corporate branding - Admin Module
  Check the color gradients in the page

  Background: Login to app
    Given user navigates to login page
    When user enters the username Admin
    And user enters the password admin123
    And click login button
    Then it should login as "Admin" and display the dashboard or display appropriate warning
    When user selects Admin module
    Then focus should be in Admin module

  #Scenario: verify the default color
    #When focus is in corporate branding module
    #Then verify default color

  Scenario: Change colors and verify
    When focus is in corporate branding module
    And modify colors and verify color change in preview
    Then reset the colors and verify colors after reset
