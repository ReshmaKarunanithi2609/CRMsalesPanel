@Deals
Feature: Deals module of the CRM application

  Background:
    Given User is on the Dashboard screen

  @positive
  Scenario: Verify the side menu opens the Deal Pipeline screen
    When User opens the Deals screen
    Then User should see "Heading" on the Deals screen
    And User should see "Deal pipeline title" on the Deals screen

  @positive
  Scenario: Verify the summary cards and the search box are displayed
    When User opens the Deals screen
    Then User should see "Total pipeline card" on the Deals screen
    And User should see "Won deals card" on the Deals screen
    And User should see "Search box" on the Deals screen
    And User should see "Create deal button" on the Deals screen

  @positive
  Scenario: Verify the deal stage filters are displayed
    When User opens the Deals screen
    Then User should see "Chip all" on the Deals screen
    And User should see "Chip new leads" on the Deals screen
    And User should see "Chip contacted" on the Deals screen

  @positive
  Scenario: Verify the contacted deals are displayed
    When User opens the Deals screen
    And User taps "Chip contacted" on the Deals screen
    Then User should see "Contacted header" on the Deals screen
    And User should see "First deal probability" on the Deals screen

  @positive
  Scenario: Verify the closed won deals are displayed
    When User opens the Deals screen
    And User swipes the filter row from "Chip contacted" on the Deals screen
    And User swipes the filter row from "Chip negotiation" on the Deals screen
    And User taps "Chip closed won" on the Deals screen
    Then User should see "Closed won header" on the Deals screen

  @positive
  Scenario: Verify each deal card shows its value and probability
    When User opens the Deals screen
    Then User should see "First deal amount" on the Deals screen
    And User should see "First deal probability" on the Deals screen

  @positive
  Scenario: Verify the Create Deal form opens from the Create new deal button
    When User opens the Deals screen
    And User taps "Create deal button" on the Deals screen
    Then User should see "Deal name label" on the Deals screen

  @positive
  Scenario: Verify the Create Deal form shows all its fields
    When User opens the Deals screen
    And User taps "Create deal button" on the Deals screen
    Then User should see "Deal name label" on the Deals screen
    And User should see "Customer label" on the Deals screen
    And User should see "Stage label" on the Deals screen
    And User should see "Deal value label" on the Deals screen
    And User should see "Probability label" on the Deals screen
    And User scrolls to the text "Expected" on the Deals screen
    And User should see "Expected date label" on the Deals screen
    And User should see "Description label" on the Deals screen

  @positive
  Scenario: Verify the Deal Name and Deal Value fields accept typed text
    When User opens the Deals screen
    And User taps "Create deal button" on the Deals screen
    And User enters "Auto Deal" in "Deal name field" on the Deals screen
    And User enters "50000" in "Deal value field" on the Deals screen
    Then "Deal name field" should contain "Auto Deal" on the Deals screen
    And "Deal value field" should contain "50000" on the Deals screen

  @negative
  Scenario: Verify saving the deal with the Deal Name empty is rejected
    When User opens the Deals screen
    And User taps "Create deal button" on the Deals screen
    And User enters "" in "Deal name field" on the Deals screen
    And User scrolls to the text "Save" on the Deals screen
    And User taps "Save button" on the Deals screen
    Then User should see a validation or error message
    And User should see "Deal name label" on the Deals screen

  @negative
  Scenario: Verify letters in the Deal Value are rejected
    When User opens the Deals screen
    And User taps "Create deal button" on the Deals screen
    And User enters "Auto Deal" in "Deal name field" on the Deals screen
    And User enters "abc" in "Deal value field" on the Deals screen
    And User scrolls to the text "Save" on the Deals screen
    And User taps "Save button" on the Deals screen
    Then User should see a validation or error message
    And User should see "Deal name label" on the Deals screen

  @negative
  Scenario: Verify a Probability above 100 is rejected
    When User opens the Deals screen
    And User taps "Create deal button" on the Deals screen
    And User enters "Auto Deal" in "Deal name field" on the Deals screen
    And User enters "50000" in "Deal value field" on the Deals screen
    And User enters "150" in "Probability field" on the Deals screen
    And User scrolls to the text "Save" on the Deals screen
    And User taps "Save button" on the Deals screen
    Then User should see a validation or error message
    And User should see "Deal name label" on the Deals screen

  @negative
  Scenario: Verify saving a deal without selecting a customer is rejected
    When User opens the Deals screen
    And User taps "Create deal button" on the Deals screen
    And User enters "Auto Deal" in "Deal name field" on the Deals screen
    And User enters "50000" in "Deal value field" on the Deals screen
    And User scrolls to the text "Save" on the Deals screen
    And User taps "Save button" on the Deals screen
    Then User should see a validation or error message
    And User should see "Deal name label" on the Deals screen

  @negative
  Scenario: Verify a Deal Name with spaces only is treated as empty
    When User opens the Deals screen
    And User taps "Create deal button" on the Deals screen
    And User enters "   " in "Deal name field" on the Deals screen
    And User scrolls to the text "Save" on the Deals screen
    And User taps "Save button" on the Deals screen
    Then User should see a validation or error message
    And User should see "Deal name label" on the Deals screen

  @negative
  Scenario: Verify searching deals with special characters shows no results
    When User opens the Deals screen
    And User enters "@#$%" in "Search box" on the Deals screen
    Then User should see the no results message
