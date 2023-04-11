Feature: Nationality - Admin Module
  Check all nationalities are disaplayed and user is able to navigate pages, add and remove countries

  Background: Login to app
    Given user navigates to login page
    When user enters the username Admin
    And user enters the password admin123
    And click login button
    Then it should login as "Admin" and display the dashboard or display appropriate warning
    When user selects Admin module
    Then focus should be in Admin module
    
    Scenario: Check if all nationalities are present and verify addition of new country
    And click on nationalities and verify the count of countries
    And add country and verify the addition
    