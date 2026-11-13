@Orders
Feature: Orders module of the CRM application

  Background:
    Given User is on the Dashboard screen

  @positive
  Scenario: Verify the side menu opens the Orders screen
    When User opens the Orders screen
    Then User should see "Heading" on the Orders screen
    And User should see "Order management title" on the Orders screen

  @positive
  Scenario: Verify the Orders screen shows its elements
    When User opens the Orders screen
    Then User should see "Search box" on the Orders screen
    And User should see "Order list label" on the Orders screen
    And User should see "Order id header" on the Orders screen
    And User should see "Status header" on the Orders screen
    And User should see "First order" on the Orders screen
    And User should see "Create new order button" on the Orders screen

  @positive
  Scenario: Verify the order details are displayed when an order is expanded
    When User opens the Orders screen
    And User taps "First order" on the Orders screen
    Then User should see "Customer label" on the Orders screen
    And User should see "Order date label" on the Orders screen
    And User should see "Total label" on the Orders screen
    And User should see "View details button" on the Orders screen

  @positive
  Scenario: Verify the order status filters are displayed
    When User opens the Orders screen
    Then User should see "Chip all" on the Orders screen
    And User should see "Chip completed" on the Orders screen
    And User should see "Chip processing" on the Orders screen
    And User should see "Chip cancelled" on the Orders screen

  @positive
  Scenario: Verify the Completed filter can be selected
    When User opens the Orders screen
    And User taps "Chip completed" on the Orders screen
    Then User should see "Order list label" on the Orders screen

  @positive
  Scenario: Verify the processing orders are displayed when the Processing filter is selected
    When User opens the Orders screen
    And User taps "Chip processing" on the Orders screen
    Then User should see "Processing badge" on the Orders screen

  @positive
  Scenario: Verify text can be entered in the orders search box
    When User opens the Orders screen
    And User enters "ORDER" in "Search box" on the Orders screen
    Then "Search box" should contain "ORDER" on the Orders screen

  @positive
  Scenario: Verify the Create New Order form opens from the Create New Order button
    When User opens the Orders screen
    And User taps "Create new order button" on the Orders screen
    Then User should see "Create order title" on the Orders screen
    And User should see "Customer information title" on the Orders screen
    And User should see "Select quotation label" on the Orders screen

  @positive
  Scenario: Verify the Create New Order form shows its fields
    When User opens the Orders screen
    And User taps "Create new order button" on the Orders screen
    Then User should see "Customer name label" on the Orders screen
    And User should see "Email label" on the Orders screen
    And User should see "Phone number label" on the Orders screen
    And User scrolls to the text "Shipping Address" on the Orders screen
    And User should see "Shipping address label" on the Orders screen
    And User should see "Continue button" on the Orders screen

  @negative
  Scenario: Verify continuing with an empty order form is rejected
    When User opens the Orders screen
    And User taps "Create new order button" on the Orders screen
    And User taps "Continue button" on the Orders screen
    Then User should see a validation or error message

  @negative
  Scenario: Verify an invalid email in the order form is rejected
    When User opens the Orders screen
    And User taps "Create new order button" on the Orders screen
    And User enters "abc" in "Email field" on the Orders screen
    And User taps "Continue button" on the Orders screen
    Then User should see a validation or error message

  @negative
  Scenario: Verify letters in the order phone number are rejected
    When User opens the Orders screen
    And User taps "Create new order button" on the Orders screen
    And User enters "abc" in "Phone field" on the Orders screen
    And User taps "Continue button" on the Orders screen
    Then User should see a validation or error message

  @negative
  Scenario: Verify searching for an order that does not exist shows no results
    When User opens the Orders screen
    And User enters "zzzzqqqq" in "Search box" on the Orders screen
    Then User should see the no results message

  @negative
  Scenario: Verify searching orders with special characters does not break the screen
    When User opens the Orders screen
    And User enters "@#$%" in "Search box" on the Orders screen
    Then The app should still respond
    And User should see "Order management title" on the Orders screen

  @negative
  Scenario: Verify the Orders screen with no internet
    When User turns on flight mode
    And User opens the Orders screen
    Then The app should still respond
