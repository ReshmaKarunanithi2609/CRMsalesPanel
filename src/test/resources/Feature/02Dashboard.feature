@Dashboard
Feature: Dashboard module of the CRM application

  Background:
    Given User is on the Dashboard screen

  @positive
  Scenario: Verify the welcome header and the Clock In card are displayed
    When User opens the Dashboard screen
    Then User should see "Welcome header" on the Dashboard screen
    And User should see "Start working" on the Dashboard screen
    And User should see "Clock in button" on the Dashboard screen

  @positive
  Scenario: Verify the side menu shows all the module options
    When User opens the Dashboard screen
    And User taps "Menu icon" on the Dashboard screen
    Then User should see "Side my leads" on the Dashboard screen
    And User should see "Side follow ups" on the Dashboard screen
    And User should see "Side deals" on the Dashboard screen
    And User should see "Side quotations" on the Dashboard screen
    And User should see "Side customers" on the Dashboard screen
    And User should see "Side orders" on the Dashboard screen
    And User should see "Side payments" on the Dashboard screen
    And User should see "Side supports" on the Dashboard screen
    And User should see "Side reports" on the Dashboard screen
    And User should see "Side profile" on the Dashboard screen
    And User should see "Side logout" on the Dashboard screen

  @positive
  Scenario: Verify the Performance Overview card shows its title and figures
    When User opens the Dashboard screen
    Then User should see "Performance overview" on the Dashboard screen
    And User should see "Growth text" on the Dashboard screen
    And User should see "Total sales" on the Dashboard screen
    And User should see "Win rate" on the Dashboard screen
    And User should see "Your sales" on the Dashboard screen

  @positive
  Scenario: Verify the summary cards are displayed
    When User opens the Dashboard screen
    Then User should see "My leads card" on the Dashboard screen
    And User should see "Active deals card" on the Dashboard screen
    And User should see "Revenue closed card" on the Dashboard screen
    And User should see "Pipeline value card" on the Dashboard screen

  @positive
  Scenario: Verify the Recent Leads list is displayed
    When User opens the Dashboard screen
    And User scrolls to the text "Recent Leads" on the Dashboard screen
    Then User should see "Recent leads tab" on the Dashboard screen
    And User should see "First lead email" on the Dashboard screen

  @positive
  Scenario: Verify the Active Deals list is displayed
    When User opens the Dashboard screen
    And User scrolls to the text "Recent Leads" on the Dashboard screen
    And User taps "Active deals tab" on the Dashboard screen
    Then User should see "First deal amount" on the Dashboard screen

  @positive
  Scenario: Verify the bottom navigation opens each screen
    When User opens the Dashboard screen
    And User taps "Tab leads" on the Dashboard screen
    Then User should see "Leads title" on the Dashboard screen
    And User taps "Tab attendance" on the Dashboard screen
    And User should see "Time clock tab" on the Dashboard screen
    And User taps "Tab profile" on the Dashboard screen
    And User should see "Export profile button" on the Dashboard screen
    And User taps "Tab dashboard" on the Dashboard screen
    And User should see "Welcome header" on the Dashboard screen

  @positive
  Scenario: Verify the bell icon opens the Notifications screen
    When User opens the Dashboard screen
    And User taps "Bell icon" on the Dashboard screen
    Then User should see "Notifications heading" on the Dashboard screen

  @positive
  Scenario: Verify switching between Recent Leads and Active Deals shows the correct list
    When User opens the Dashboard screen
    And User scrolls to the text "Recent Leads" on the Dashboard screen
    And User taps "Active deals tab" on the Dashboard screen
    And User taps "Recent leads tab" on the Dashboard screen
    And User taps "Active deals tab" on the Dashboard screen
    And User taps "Recent leads tab" on the Dashboard screen
    Then User should see "First lead email" on the Dashboard screen

  @negative
  Scenario: Verify the Dashboard with no internet
    When User turns on flight mode
    And User opens the Dashboard screen
    Then The app should still respond
    And User should see "Welcome header" on the Dashboard screen

  @negative
  Scenario: Verify the device Back button on the Dashboard
    When User presses the device Back button
    Then The app should close or ask for exit confirmation

  @negative
  Scenario: Verify tapping Clock In rapidly does not show an error
    When User opens the Dashboard screen
    And User taps "Clock in button" 3 times quickly on the Dashboard screen
    Then The app should still respond
    And User should not see "Error toast" on the Dashboard screen

  @negative
  Scenario: Verify the Dashboard keeps its content after rotation
    When User opens the Dashboard screen
    And User rotates the device to landscape
    And User rotates the device to portrait
    Then User should see "Welcome header" on the Dashboard screen

  @negative
  Scenario: Verify tapping the My Leads card opens the related list
    When User opens the Dashboard screen
    And User taps "My leads card" on the Dashboard screen
    Then User should not see "Welcome header" on the Dashboard screen

  @negative
  Scenario: Verify the Conversion Rate card label spelling
    When User opens the Dashboard screen
    And User scrolls to the text "Conver" on the Dashboard screen
    Then User should see "Conversion rate label" on the Dashboard screen
