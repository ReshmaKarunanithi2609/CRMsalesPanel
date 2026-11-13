@Login
Feature: Login module of the CRM application

  Background:
    Given User is on the Login screen

  @positive
  Scenario: Verify all the elements are displayed on the Login screen
    Then User should see "Heading" on the Login screen
    And User should see "Sub heading" on the Login screen
    And User should see "Email label" on the Login screen
    And User should see "Email field" on the Login screen
    And User should see "Password label" on the Login screen
    And User should see "Password field" on the Login screen
    And User should see "Remember me" on the Login screen
    And User should see "Forgot password" on the Login screen
    And User should see "Login button" on the Login screen
    And User should see "Sign up link" on the Login screen

  @positive
  Scenario: Verify login with valid email and password
    When User enters the registered email on the Login screen
    And User enters the registered password on the Login screen
    And User taps "Login button" on the Login screen
    Then User should be navigated to the Dashboard

  @positive
  Scenario: Verify the password is shown in plain text when the eye icon is tapped
    When User enters "Test@1234" in "Password field" on the Login screen
    And User taps "Eye icon" on the Login screen
    Then "Password field" should contain "Test@1234" on the Login screen

  @positive
  Scenario: Verify the user stays logged in after reopening the app when Remember me is selected
    When User enters the registered email on the Login screen
    And User enters the registered password on the Login screen
    And User taps "Remember me" on the Login screen
    And User taps "Login button" on the Login screen
    Then User should be navigated to the Dashboard
    When User closes and reopens the application
    Then User should be navigated to the Dashboard

  @positive
  Scenario: Verify the Forgot Password link opens the next screen
    When User taps "Forgot password" on the Login screen
    Then User should not see "Heading" on the Login screen

  @positive
  Scenario: Verify the Sign up link opens the Create your account screen
    When User taps the Sign up link on the Login screen
    Then User should see "Sign up title" on the Login screen
    And User should see "Full name label" on the Login screen

  @positive
  Scenario: Verify Sign In Instead returns to the Login screen
    When User taps the Sign up link on the Login screen
    And User scrolls to the text "Sign In Instead" on the Login screen
    And User taps "Sign in instead" on the Login screen
    Then User should see "Heading" on the Login screen

  @positive
  Scenario: Verify login with the registered email in upper case
    When User enters the registered email in upper case on the Login screen
    And User enters the registered password on the Login screen
    And User taps "Login button" on the Login screen
    Then User should be navigated to the Dashboard

  @positive
  Scenario: Verify tapping Log In five times quickly processes only one login
    When User enters the registered email on the Login screen
    And User enters the registered password on the Login screen
    And User taps "Login button" 5 times quickly on the Login screen
    Then User should be navigated to the Dashboard
    And User should not see "Error toast" on the Login screen

  @negative
  Scenario: Verify login with both fields empty shows the required messages
    When User taps "Login button" on the Login screen
    Then User should see "Email required message" on the Login screen
    And User should see "Password required message" on the Login screen

  @negative
  Scenario: Verify login with a valid email and an empty password shows the password message
    When User enters the registered email on the Login screen
    And User taps "Login button" on the Login screen
    Then User should see "Password required message" on the Login screen

  

  @negative
  Scenario: Verify login with an unregistered email is rejected
    When User enters "no.account.user@example.com" in "Email field" on the Login screen
    And User enters "Test@1234" in "Password field" on the Login screen
    And User taps "Login button" on the Login screen
    Then User should see a validation or error message
    And User should see "Heading" on the Login screen

  