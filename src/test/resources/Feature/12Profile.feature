@Profile
Feature: Profile module of the CRM application

  Background:
    Given User is on the Dashboard screen

  @positive
  Scenario: Verify the profile card and its tabs are displayed
    When User opens the Profile screen
    Then User should see "Heading" on the Profile screen
    And User should see "Export profile button" on the Profile screen
    And User should see "Edit profile button" on the Profile screen
    And User should see "Account created text" on the Profile screen
    And User should see "Tab settings" on the Profile screen
    And User should see "Tab help" on the Profile screen
    And User should see "Tab about" on the Profile screen

  @positive
  Scenario: Verify the Edit Profile form opens with its fields
    When User opens the Profile screen
    And User taps "Edit profile button" on the Profile screen
    Then User should see "Name field" on the Profile screen
    And User should see "Email field" on the Profile screen
    And User should see "Phone number field" on the Profile screen
    And User should see "User name field" on the Profile screen
    And User should see "Update profile button" on the Profile screen

  @positive
  Scenario: Verify the notification settings are displayed
    When User opens the Profile screen
    Then User should see "Notification setting label" on the Profile screen
    And User should see "Bio metric label" on the Profile screen
    And User should see "Sms label" on the Profile screen
    And User should see "Push notification label" on the Profile screen

  @positive
  Scenario: Verify the security settings are displayed
    When User opens the Profile screen
    And User scrolls to the text "Security Setting" on the Profile screen
    Then User should see "Security setting label" on the Profile screen
    And User should see "Two fa label" on the Profile screen
    And User should see "Change password label" on the Profile screen

  @positive
  Scenario: Verify the other settings are displayed
    When User opens the Profile screen
    And User scrolls to the text "Other Settings" on the Profile screen
    Then User should see "Other settings label" on the Profile screen
    And User should see "Language preference label" on the Profile screen
    And User should see "Account status label" on the Profile screen
    And User should see "Logout button" on the Profile screen

  @positive
  Scenario: Verify the help and support options are displayed on the Help tab
    When User opens the Profile screen
    And User taps "Tab help" on the Profile screen
    Then User should see "Help and support label" on the Profile screen
    And User should see "Help center label" on the Profile screen
    And User should see "Faq label" on the Profile screen
    And User should see "Contact support label" on the Profile screen

  @positive
  Scenario: Verify the about and policy options are displayed on the About tab
    When User opens the Profile screen
    And User taps "Tab about" on the Profile screen
    Then User should see "About and policy label" on the Profile screen
    And User should see "Terms label" on the Profile screen
    And User should see "Privacy policy label" on the Profile screen
    And User should see "Cookies policy label" on the Profile screen
    And User should see "Licenses label" on the Profile screen

  @positive
  Scenario: Verify the Name field can be edited
    When User opens the Profile screen
    And User taps "Edit profile button" on the Profile screen
    And User enters "Karthikeyan" in "Name field" on the Profile screen
    Then "Name field" should contain "Karthikeyan" on the Profile screen

  @positive
  Scenario: Verify the device Back button on the Edit Profile screen returns to the Profile screen
    When User opens the Profile screen
    And User taps "Edit profile button" on the Profile screen
    And User presses the device Back button
    Then User should see "Edit profile button" on the Profile screen

  @negative
  Scenario: Verify updating the profile with an empty Phone Number is rejected
    When User opens the Profile screen
    And User taps "Edit profile button" on the Profile screen
    And User enters "" in "Phone number field" on the Profile screen
    And User taps "Update profile button" on the Profile screen
    Then User should see a validation or error message
    And User should see "Update profile button" on the Profile screen

  @negative
  Scenario: Verify updating the profile with an invalid email is rejected
    When User opens the Profile screen
    And User taps "Edit profile button" on the Profile screen
    And User enters "userexample.com" in "Email field" on the Profile screen
    And User taps "Update profile button" on the Profile screen
    Then User should see a validation or error message
    And User should see "Update profile button" on the Profile screen

  @negative
  Scenario: Verify updating the profile with an empty Name is rejected
    When User opens the Profile screen
    And User taps "Edit profile button" on the Profile screen
    And User enters "" in "Name field" on the Profile screen
    And User taps "Update profile button" on the Profile screen
    Then User should see a validation or error message
    And User should see "Update profile button" on the Profile screen

  @negative
  Scenario: Verify updating the profile with a Name of spaces only is rejected
    When User opens the Profile screen
    And User taps "Edit profile button" on the Profile screen
    And User enters "   " in "Name field" on the Profile screen
    And User taps "Update profile button" on the Profile screen
    Then User should see a validation or error message
    And User should see "Update profile button" on the Profile screen

  @negative
  Scenario: Verify a Phone Number with fewer than 10 digits is rejected
    When User opens the Profile screen
    And User taps "Edit profile button" on the Profile screen
    And User enters "12345" in "Phone number field" on the Profile screen
    And User taps "Update profile button" on the Profile screen
    Then User should see a validation or error message
    And User should see "Update profile button" on the Profile screen

  @negative
  Scenario: Verify a Phone Number with letters is rejected
    When User opens the Profile screen
    And User taps "Edit profile button" on the Profile screen
    And User enters "abcdefghij" in "Phone number field" on the Profile screen
    And User taps "Update profile button" on the Profile screen
    Then User should see a validation or error message
    And User should see "Update profile button" on the Profile screen
