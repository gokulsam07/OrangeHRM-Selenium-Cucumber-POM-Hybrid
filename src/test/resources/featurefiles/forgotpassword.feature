Feature: Forgot password
  Verify if forgot password option works fine

  Background: Go to login page
    Given user navigates to login page
    When user click forgot password link
    Then user should be redirected to resetpage

  Scenario: Forgot password link check
    And the user should be able to enter username "gokulsam07"
    And click reset and user should get proper message for reset passowrd

  Scenario: Forgot password cancel button check
    And the user should be able to click cancel button and redirect to loginpage
