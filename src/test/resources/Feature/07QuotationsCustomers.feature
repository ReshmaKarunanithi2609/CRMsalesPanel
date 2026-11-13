@QuotationsCustomers
Feature: Quotations and Customers module of the CRM application

  Background:
    Given User is on the Dashboard screen

  @positive
  Scenario: Verify the side menu opens the Quotations screen
    When User opens the Quotations screen
    Then User should see "Heading" on the Quotations screen

  @positive
  Scenario: Verify the quotations list is displayed
    When User opens the Quotations screen
    Then User should see "Quotation id header" on the Quotations screen
    And User should see "Status header" on the Quotations screen
    And User should see "First quotation" on the Quotations screen
    And User should see "Create quotation button" on the Quotations screen

  @positive
  Scenario: Verify the quotation details are displayed when a quotation is expanded
    When User opens the Quotations screen
    And User taps "First quotation" on the Quotations screen
    Then User should see "Customer label" on the Quotations screen
    And User should see "Date issued label" on the Quotations screen
    And User should see "Valid until label" on the Quotations screen
    And User should see "Total label" on the Quotations screen

  @positive
  Scenario: Verify an expanded quotation collapses when it is tapped again
    When User opens the Quotations screen
    And User taps "First quotation" on the Quotations screen
    And User taps "First quotation" on the Quotations screen
    Then User should not see "Date issued label" on the Quotations screen

  @positive
  Scenario: Verify the Create Quotation form opens from the Create Quotation button
    When User opens the Quotations screen
    And User taps "Create quotation button" on the Quotations screen
    Then User should see "Valid until label" on the Quotations screen

  @positive
  Scenario: Verify the Create Quotation form shows its sections
    When User opens the Quotations screen
    And User taps "Create quotation button" on the Quotations screen
    And User scrolls to the text "Discount" on the Quotations screen
    Then User should see "Discount label" on the Quotations screen
    And User scrolls to the text "Tax" on the Quotations screen
    And User should see "Tax label" on the Quotations screen
    And User scrolls to the text "Line Items" on the Quotations screen
    And User should see "Line items label" on the Quotations screen
    And User should see "Add item button" on the Quotations screen
    And User scrolls to the text "Summary" on the Quotations screen
    And User should see "Summary label" on the Quotations screen

  @positive
  Scenario: Verify the side menu opens the Customer Management screen
    When User opens the Customers screen
    Then User should see "Customer management title" on the Customers screen

  @positive
  Scenario: Verify the Customer Management screen shows its elements
    When User opens the Customers screen
    Then User should see "Search box" on the Customers screen
    And User should see "Customer list label" on the Customers screen
    And User should see "First view button" on the Customers screen

  @positive
  Scenario: Verify customers can be searched by name
    When User opens the Customers screen
    And User enters "Siva" in "Search box" on the Customers screen
    Then "Search box" should contain "Siva" on the Customers screen

  @positive
  Scenario: Verify the View button opens the customer information screen
    When User opens the Customers screen
    And User taps "First view button" on the Customers screen
    Then User should not see "Customer management title" on the Customers screen

  @negative
  Scenario: Verify creating a quotation with an empty form is rejected
    When User opens the Quotations screen
    And User taps "Create quotation button" on the Quotations screen
    And User scrolls to the text "Create Quotation" on the Quotations screen
    And User taps "Create quotation button" on the Quotations screen
    Then User should see a validation or error message

  @negative
  Scenario: Verify a Discount above 100 is rejected
    When User opens the Quotations screen
    And User taps "Create quotation button" on the Quotations screen
    And User scrolls to the text "Discount" on the Quotations screen
    And User enters "150" in "Discount field" on the Quotations screen
    And User scrolls to the text "Create Quotation" on the Quotations screen
    And User taps "Create quotation button" on the Quotations screen
    Then User should see a validation or error message

  @negative
  Scenario: Verify searching for a quotation that does not exist shows no results
    When User opens the Quotations screen
    And User enters "zzzzqqqq" in "Search box" on the Quotations screen
    Then User should see the no results message

  @negative
  Scenario: Verify searching for a customer that does not exist shows no results
    When User opens the Customers screen
    And User enters "zzzzqqqq" in "Search box" on the Customers screen
    Then User should see the no results message

  @negative
  Scenario: Verify searching customers with special characters does not break the screen
    When User opens the Customers screen
    And User enters "@#$%" in "Search box" on the Customers screen
    Then The app should still respond
    And User should see "Customer management title" on the Customers screen
