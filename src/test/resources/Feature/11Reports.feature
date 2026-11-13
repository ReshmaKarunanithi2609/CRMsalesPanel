@Reports
Feature: Reports module of the CRM application

  Background:
    Given User is on the Dashboard screen

  @positive
  Scenario: Verify the side menu opens the Reports and Analytics screen
    When User opens the Reports screen
    Then User should see "Heading" on the Reports screen
    And User should see "Reports analytics title" on the Reports screen

  @positive
  Scenario: Verify the report tabs are displayed
    When User opens the Reports screen
    Then User should see "Tab overview" on the Reports screen
    And User should see "Tab leads" on the Reports screen
    And User should see "Tab sales" on the Reports screen
    And User should see "Tab support" on the Reports screen

  @positive
  Scenario: Verify the overview summary cards are displayed
    When User opens the Reports screen
    Then User should see "Total revenue card" on the Reports screen
    And User should see "Total customer card" on the Reports screen
    And User should see "Conversation rate card" on the Reports screen
    And User should see "Active task card" on the Reports screen

  @positive
  Scenario: Verify the sales pipeline and the financial summary are displayed
    When User opens the Reports screen
    And User scrolls to the text "Sales Pipeline" on the Reports screen
    Then User should see "Sales pipeline label" on the Reports screen
    And User should see "Total pipeline label" on the Reports screen
    And User should see "Won deals label" on the Reports screen
    And User should see "Order completion label" on the Reports screen
    And User scrolls to the text "Financial Summary" on the Reports screen
    And User should see "Financial summary label" on the Reports screen

  @positive
  Scenario: Verify the support ticket statistics are displayed on the Support tab
    When User opens the Reports screen
    And User taps "Tab support" on the Reports screen
    Then User should see "Total tickets card" on the Reports screen
    And User should see "Open tickets card" on the Reports screen

  @positive
  Scenario: Verify the team performance is displayed on the Teams tab
    When User opens the Reports screen
    And User swipes the filter row from "Tab support" on the Reports screen
    And User taps "Tab teams" on the Reports screen
    Then User should see "Team won badge" on the Reports screen

  @positive
  Scenario: Verify the report tabs row scrolls to the last tab
    When User opens the Reports screen
    And User swipes the filter row from "Tab support" on the Reports screen
    Then User should see "Tab teams" on the Reports screen

  @positive
  Scenario: Verify the side menu opens the Profile screen
    When User opens the Reports screen
    And User taps "Menu icon" on the Reports screen
    And User taps "Side profile" on the Reports screen
    Then User should see "Export profile button" on the Reports screen

  @positive
  Scenario: Verify Logout in the side menu shows the Login screen
    When User opens the Reports screen
    And User taps "Menu icon" on the Reports screen
    And User taps "Side logout" on the Reports screen
    Then User should see "Login heading" on the Reports screen

  @negative
  Scenario: Verify the Reports screen with no internet
    When User turns on flight mode
    And User opens the Reports screen
    Then The app should still respond

  @negative
  Scenario: Verify switching rapidly between the report tabs
    When User opens the Reports screen
    And User taps "Tab support" on the Reports screen
    And User taps "Tab overview" on the Reports screen
    And User taps "Tab support" on the Reports screen
    And User taps "Tab overview" on the Reports screen
    Then User should see "Total revenue card" on the Reports screen

  @negative
  Scenario: Verify the device Back button on the Reports screen
    When User opens the Reports screen
    And User presses the device Back button
    Then The app should still respond

  @negative
  Scenario: Verify the Reports screen keeps its content after rotation
    When User opens the Reports screen
    And User rotates the device to landscape
    And User rotates the device to portrait
    Then User should see "Heading" on the Reports screen

  @negative
  Scenario: Verify tapping the selected tab again does not break the screen
    When User opens the Reports screen
    And User taps "Tab overview" on the Reports screen
    And User taps "Tab overview" on the Reports screen
    Then User should see "Total revenue card" on the Reports screen

  @negative
  Scenario: Verify the Overview tab content returns after visiting the Support tab
    When User opens the Reports screen
    And User taps "Tab support" on the Reports screen
    And User taps "Tab overview" on the Reports screen
    Then User should see "Total customer card" on the Reports screen
