@Payments
Feature: Payments module of the CRM application

  Background:
    Given User is on the Dashboard screen

  @positive
  Scenario: Verify the side menu opens the Payment Tracking screen
    When User opens the Payments screen
    Then User should see "Heading" on the Payments screen
    And User should see "Search box" on the Payments screen

  @positive
  Scenario: Verify the payment summary cards are displayed
    When User opens the Payments screen
    Then User should see "Total invoiced card" on the Payments screen
    And User should see "Collected card" on the Payments screen
    And User should see "Pending card" on the Payments screen
    And User should see "Collected rate card" on the Payments screen

  @positive
  Scenario: Verify the invoices and payments list is displayed
    When User opens the Payments screen
    And User scrolls to the text "Invoices and Payments" on the Payments screen
    Then User should see "Invoices and payments label" on the Payments screen
    And User should see "Quotation id header" on the Payments screen
    And User should see "Status header" on the Payments screen
    And User should see "First invoice" on the Payments screen

  @positive
  Scenario: Verify the invoice details are displayed when an invoice is expanded
    When User opens the Payments screen
    And User scrolls to the text "Invoices and Payments" on the Payments screen
    And User taps "First invoice" on the Payments screen
    Then User should see "Customer label" on the Payments screen
    And User should see "Date label" on the Payments screen
    And User should see "Amount label" on the Payments screen
    And User should see "Paid label" on the Payments screen
    And User should see "Balance label" on the Payments screen

  @positive
  Scenario: Verify an expanded invoice collapses when it is tapped again
    When User opens the Payments screen
    And User scrolls to the text "Invoices and Payments" on the Payments screen
    And User taps "First invoice" on the Payments screen
    And User taps "First invoice" on the Payments screen
    Then User should not see "Balance label" on the Payments screen

  @positive
  Scenario: Verify the eye icon opens the invoice details
    When User opens the Payments screen
    And User scrolls to the text "Invoices and Payments" on the Payments screen
    And User taps "Eye icon" on the Payments screen
    Then User should not see "Invoices and payments label" on the Payments screen

  @positive
  Scenario: Verify text can be entered in the payments search box
    When User opens the Payments screen
    And User enters "INV" in "Search box" on the Payments screen
    Then "Search box" should contain "INV" on the Payments screen

  @positive
  Scenario: Verify invoices can be searched by customer name
    When User opens the Payments screen
    And User enters "Siva" in "Search box" on the Payments screen
    Then "Search box" should contain "Siva" on the Payments screen

  @positive
  Scenario: Verify the invoice status tag is displayed
    When User opens the Payments screen
    And User scrolls to the text "Invoices and Payments" on the Payments screen
    Then User should see "Follow up badge" on the Payments screen

  @negative
  Scenario: Verify searching for an invoice that does not exist shows no results
    When User opens the Payments screen
    And User enters "zzzzqqqq" in "Search box" on the Payments screen
    Then User should see the no results message

  @negative
  Scenario: Verify searching invoices with special characters does not break the screen
    When User opens the Payments screen
    And User enters "@#$%" in "Search box" on the Payments screen
    Then The app should still respond
    And User should see "Heading" on the Payments screen

  @negative
  Scenario: Verify searching invoices with spaces only does not break the screen
    When User opens the Payments screen
    And User enters "   " in "Search box" on the Payments screen
    Then The app should still respond
    And User should see "Heading" on the Payments screen

  @negative
  Scenario: Verify a very long search text does not break the screen
    When User opens the Payments screen
    And User enters 300 characters in "Search box" on the Payments screen
    Then The app should still respond
    And User should see "Heading" on the Payments screen

  @negative
  Scenario: Verify the Payments screen with no internet
    When User turns on flight mode
    And User opens the Payments screen
    Then The app should still respond

  @negative
  Scenario: Verify the Payments screen keeps its content after rotation
    When User opens the Payments screen
    And User rotates the device to landscape
    And User rotates the device to portrait
    Then User should see "Heading" on the Payments screen
