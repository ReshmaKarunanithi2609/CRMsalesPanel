@FollowUp
Feature: Follow-Up Management module of the CRM application

  Background:
    Given User is on the Dashboard screen

  @positive
  Scenario: Verify the side menu opens the Follow-Up Management screen
    When User opens the Follow-Up screen
    Then User should see "Heading" on the Follow-Up screen

  @positive
  Scenario: Verify the summary cards are displayed
    When User opens the Follow-Up screen
    Then User should see "New schedule button" on the Follow-Up screen
    And User should see "Total follow up card" on the Follow-Up screen
    And User should see "Completed this week card" on the Follow-Up screen
    And User should see "Success rate card" on the Follow-Up screen

  @positive
  Scenario: Verify the scheduled follow-up details are displayed
    When User opens the Follow-Up screen
    And User scrolls to the text "Follow-Up schedules" on the Follow-Up screen
    Then User should see "Schedules heading" on the Follow-Up screen
    And User should see "First schedule email" on the Follow-Up screen
    And User should see "Pending badge" on the Follow-Up screen
    And User should see "Notes label" on the Follow-Up screen

  @positive
  Scenario: Verify the Schedule Lead Follow-Up form opens from the New Schedule button
    When User opens the Follow-Up screen
    And User taps "New schedule button" on the Follow-Up screen
    Then User should see "Popup title" on the Follow-Up screen

  @positive
  Scenario: Verify the Schedule Lead Follow-Up form shows all its fields
    When User opens the Follow-Up screen
    And User taps "New schedule button" on the Follow-Up screen
    Then User should see "Email field" on the Follow-Up screen
    And User should see "Phone field" on the Follow-Up screen
    And User should see "Type label" on the Follow-Up screen
    And User should see "Date field" on the Follow-Up screen
    And User should see "Time field" on the Follow-Up screen
    And User should see "Priority label" on the Follow-Up screen
    And User should see "Notes field" on the Follow-Up screen
    And User should see "Cancel button" on the Follow-Up screen
    And User should see "Schedule button" on the Follow-Up screen

  @positive
  Scenario: Verify the default Type and Priority values are displayed
    When User opens the Follow-Up screen
    And User taps "New schedule button" on the Follow-Up screen
    Then User should see "Type value" on the Follow-Up screen
    And User should see "Priority value" on the Follow-Up screen

  @positive
  Scenario: Verify the Notes field accepts typed text
    When User opens the Follow-Up screen
    And User taps "New schedule button" on the Follow-Up screen
    And User enters "Product demo call" in "Notes field" on the Follow-Up screen
    Then "Notes field" should contain "Product demo call" on the Follow-Up screen

  @positive
  Scenario: Verify the Cancel button closes the form
    When User opens the Follow-Up screen
    And User taps "New schedule button" on the Follow-Up screen
    And User taps "Cancel button" on the Follow-Up screen
    Then User should not see "Popup title" on the Follow-Up screen

  @positive
  Scenario: Verify text can be entered in the follow-up search box
    When User opens the Follow-Up screen
    And User enters "WOW" in "Search box" on the Follow-Up screen
    Then "Search box" should contain "WOW" on the Follow-Up screen

  @negative
  Scenario: Verify scheduling with all fields empty is rejected
    When User opens the Follow-Up screen
    And User taps "New schedule button" on the Follow-Up screen
    And User taps "Schedule button" on the Follow-Up screen
    Then User should see a validation or error message
    And User should see "Popup title" on the Follow-Up screen

  @negative
  Scenario: Verify a phone number with fewer than 10 digits is rejected
    When User opens the Follow-Up screen
    And User taps "New schedule button" on the Follow-Up screen
    And User enters "12345" in "Phone field" on the Follow-Up screen
    And User taps "Schedule button" on the Follow-Up screen
    Then User should see a validation or error message
    And User should see "Popup title" on the Follow-Up screen

  @negative
  Scenario: Verify an invalid email address is rejected
    When User opens the Follow-Up screen
    And User taps "New schedule button" on the Follow-Up screen
    And User enters "userexample.com" in "Email field" on the Follow-Up screen
    And User taps "Schedule button" on the Follow-Up screen
    Then User should see a validation or error message
    And User should see "Popup title" on the Follow-Up screen

  @negative
  Scenario: Verify searching for a schedule that does not exist shows no results
    When User opens the Follow-Up screen
    And User enters "zzzzqqqq" in "Search box" on the Follow-Up screen
    Then User should see the no results message

  @negative
  Scenario: Verify the device Back button closes the form without scheduling
    When User opens the Follow-Up screen
    And User taps "New schedule button" on the Follow-Up screen
    And User presses the device Back button
    Then User should not see "Popup title" on the Follow-Up screen
    And The app should still respond

  @negative
  Scenario: Verify the close icon closes the form without scheduling
    When User opens the Follow-Up screen
    And User taps "New schedule button" on the Follow-Up screen
    And User taps "Popup close icon" on the Follow-Up screen
    Then User should not see "Popup title" on the Follow-Up screen
