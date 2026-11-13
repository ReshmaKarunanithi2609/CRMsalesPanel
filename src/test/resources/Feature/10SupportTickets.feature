@SupportTickets
Feature: Support Tickets module of the CRM application

  Background:
    Given User is on the Dashboard screen

  @positive
  Scenario: Verify the side menu opens the Support Tickets screen
    When User opens the Support Tickets screen
    Then User should see "Heading" on the Support Tickets screen
    And User should see "Sub heading" on the Support Tickets screen

  @positive
  Scenario: Verify the Support Tickets screen shows its elements
    When User opens the Support Tickets screen
    Then User should see "Search box" on the Support Tickets screen
    And User should see "Open card" on the Support Tickets screen
    And User should see "In progress card" on the Support Tickets screen
    And User should see "Resolved card" on the Support Tickets screen
    And User should see "High priority card" on the Support Tickets screen
    And User should see "Ticket list label" on the Support Tickets screen
    And User should see "Create ticket button" on the Support Tickets screen

  @positive
  Scenario: Verify the ticket status filters are displayed
    When User opens the Support Tickets screen
    Then User should see "Chip all" on the Support Tickets screen
    And User should see "Chip open" on the Support Tickets screen
    And User should see "Chip in progress" on the Support Tickets screen

  @positive
  Scenario: Verify the Open ticket filter can be selected
    When User opens the Support Tickets screen
    And User taps "Chip open" on the Support Tickets screen
    Then User should see "Heading" on the Support Tickets screen

  @positive
  Scenario: Verify the On Hold ticket filter can be selected
    When User opens the Support Tickets screen
    And User swipes the filter row from "Chip in progress" on the Support Tickets screen
    And User taps "Chip on hold" on the Support Tickets screen
    Then User should see "Heading" on the Support Tickets screen

  @positive
  Scenario: Verify the Create Ticket form opens from the Create Ticket button
    When User opens the Support Tickets screen
    And User taps "Create ticket button" on the Support Tickets screen
    Then User should see "Create ticket title" on the Support Tickets screen
    And User should see "Raise text" on the Support Tickets screen

  @positive
  Scenario: Verify the Create Ticket form shows its fields
    When User opens the Support Tickets screen
    And User taps "Create ticket button" on the Support Tickets screen
    Then User should see "Customer account label" on the Support Tickets screen
    And User should see "Select customer value" on the Support Tickets screen
    And User should see "Subject label" on the Support Tickets screen
    And User should see "Category label" on the Support Tickets screen
    And User should see "Priority sla label" on the Support Tickets screen
    And User scrolls to the text "Description" on the Support Tickets screen
    And User should see "Description label" on the Support Tickets screen

  @positive
  Scenario: Verify the default category and priority are displayed
    When User opens the Support Tickets screen
    And User taps "Create ticket button" on the Support Tickets screen
    Then User should see "Category value" on the Support Tickets screen
    And User should see "Priority value" on the Support Tickets screen

  @positive
  Scenario: Verify the Subject field accepts typed text
    When User opens the Support Tickets screen
    And User taps "Create ticket button" on the Support Tickets screen
    And User enters "Login issue" in "Subject field" on the Support Tickets screen
    Then "Subject field" should contain "Login issue" on the Support Tickets screen

  @negative
  Scenario: Verify creating a ticket with an empty form is rejected
    When User opens the Support Tickets screen
    And User taps "Create ticket button" on the Support Tickets screen
    And User scrolls to the text "Create Ticket" on the Support Tickets screen
    And User taps "Create ticket button" on the Support Tickets screen
    Then User should see a validation or error message

  @negative
  Scenario: Verify creating a ticket without selecting a customer is rejected
    When User opens the Support Tickets screen
    And User taps "Create ticket button" on the Support Tickets screen
    And User enters "Login issue" in "Subject field" on the Support Tickets screen
    And User scrolls to the text "Create Ticket" on the Support Tickets screen
    And User taps "Create ticket button" on the Support Tickets screen
    Then User should see a validation or error message

  @negative
  Scenario: Verify a Subject with spaces only is treated as empty
    When User opens the Support Tickets screen
    And User taps "Create ticket button" on the Support Tickets screen
    And User enters "   " in "Subject field" on the Support Tickets screen
    And User scrolls to the text "Create Ticket" on the Support Tickets screen
    And User taps "Create ticket button" on the Support Tickets screen
    Then User should see a validation or error message

  @negative
  Scenario: Verify searching for a ticket that does not exist shows no results
    When User opens the Support Tickets screen
    And User enters "zzzzqqqq" in "Search box" on the Support Tickets screen
    Then User should see the no results message

  @negative
  Scenario: Verify searching tickets with special characters does not break the screen
    When User opens the Support Tickets screen
    And User enters "@#$%" in "Search box" on the Support Tickets screen
    Then The app should still respond
    And User should see "Heading" on the Support Tickets screen

  @negative
  Scenario: Verify the Support Tickets screen with no internet
    When User turns on flight mode
    And User opens the Support Tickets screen
    Then The app should still respond
