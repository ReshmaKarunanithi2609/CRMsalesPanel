@Leads
Feature: Leads module of the CRM application

  Background:
    Given User is on the Dashboard screen

  @positive
  Scenario: Verify the Lead Management screen and its summary cards are displayed
    When User opens the Leads screen
    Then User should see "Heading" on the Leads screen
    And User should see "Sub heading" on the Leads screen
    And User should see "New lead button" on the Leads screen
    And User should see "Search box" on the Leads screen
    And User should see "New leads card" on the Leads screen
    And User should see "Interested card" on the Leads screen
    And User should see "Converted leads card" on the Leads screen
    And User should see "Total leads card" on the Leads screen

  @positive
  Scenario: Verify the lead filter options are displayed
    When User opens the Leads screen
    Then User should see "Chip all" on the Leads screen
    And User should see "Chip appointment" on the Leads screen
    And User should see "Chip followups" on the Leads screen

  @positive
  Scenario: Verify the Appointment filter can be selected
    When User opens the Leads screen
    And User taps "Chip appointment" on the Leads screen
    Then User should see "Heading" on the Leads screen

  @positive
  Scenario: Verify text can be entered in the lead search box
    When User opens the Leads screen
    And User enters "Acme" in "Search box" on the Leads screen
    Then "Search box" should contain "Acme" on the Leads screen

  @positive
  Scenario: Verify the Add New Lead form opens from the New Lead button
    When User opens the Leads screen
    And User taps "New lead button" on the Leads screen
    Then User should see "Add lead heading" on the Leads screen
    And User should see "Lead status label" on the Leads screen
    And User should see "Status new" on the Leads screen
    And User should see "Status interested" on the Leads screen
    And User should see "Status converted" on the Leads screen
    And User should see "Status followup" on the Leads screen
    And User should see "Customer information" on the Leads screen
    And User should see "Customer name field" on the Leads screen

  @positive
  Scenario: Verify the Lead Details and notes sections are displayed in the form
    When User opens the Leads screen
    And User taps "New lead button" on the Leads screen
    And User scrolls to the text "Lead Details" on the Leads screen
    Then User should see "Lead details" on the Leads screen
    And User scrolls to the text "Manager Notes" on the Leads screen
    And User should see "Manager notes label" on the Leads screen
    And User scrolls to the text "Telecaller Notes" on the Leads screen
    And User should see "Telecaller notes label" on the Leads screen
    And User scrolls to the text "Sales Team Notes" on the Leads screen
    And User should see "Sales team notes label" on the Leads screen

  @positive
  Scenario: Verify the Phone Number field accepts a valid 10 digit number
    When User opens the Leads screen
    And User taps "New lead button" on the Leads screen
    And User enters "Automation Lead" in "Customer name field" on the Leads screen
    And User scrolls to the text "Phone Number" on the Leads screen
    And User enters "9876543210" in "Phone number field" on the Leads screen
    Then "Phone number field" should contain "9876543210" on the Leads screen

  @positive
  Scenario: Verify the follow-up date and time fields accept valid values
    When User opens the Leads screen
    And User taps "New lead button" on the Leads screen
    And User scrolls to the text "Follow-up Date" on the Leads screen
    And User enters "2026-12-20" in "Follow up date field" on the Leads screen
    And User enters "10:30" in "Follow up time field" on the Leads screen
    And "Follow up date field" should contain "2026-12-20" on the Leads screen
    And "Follow up time field" should contain "10:30" on the Leads screen

  @positive
  Scenario: Verify a new lead can be created with valid details
    When User opens the Leads screen
    And User taps "New lead button" on the Leads screen
    And User enters "Automation Lead" in "Customer name field" on the Leads screen
    And User scrolls to the text "Phone Number" on the Leads screen
    And User enters "9876543210" in "Phone number field" on the Leads screen
    And User scrolls to the text "Location" on the Leads screen
    And User enters "Chennai" in "Location field" on the Leads screen
    And User scrolls to the text "Follow-up Date" on the Leads screen
    And User enters "2026-12-20" in "Follow up date field" on the Leads screen
    And User enters "10:30" in "Follow up time field" on the Leads screen
    And User taps "Save button" on the Leads screen
    Then User should see the success message

  @negative
  Scenario: Verify saving the Add New Lead form with all fields empty is rejected
    When User opens the Leads screen
    And User taps "New lead button" on the Leads screen
    And User taps "Save button" on the Leads screen
    Then User should see a validation or error message
    And User should see "Add lead heading" on the Leads screen

  @negative
  Scenario: Verify a phone number with fewer than 10 digits is rejected
    When User opens the Leads screen
    And User taps "New lead button" on the Leads screen
    And User enters "Automation Lead" in "Customer name field" on the Leads screen
    And User scrolls to the text "Phone Number" on the Leads screen
    And User enters "12345" in "Phone number field" on the Leads screen
    And User taps "Save button" on the Leads screen
    Then User should see a validation or error message
    And User should see "Add lead heading" on the Leads screen

  @negative
  Scenario: Verify a phone number containing letters is rejected
    When User opens the Leads screen
    And User taps "New lead button" on the Leads screen
    And User enters "Automation Lead" in "Customer name field" on the Leads screen
    And User scrolls to the text "Phone Number" on the Leads screen
    And User enters "98abc12345" in "Phone number field" on the Leads screen
    And User taps "Save button" on the Leads screen
    Then User should see a validation or error message
    And User should see "Add lead heading" on the Leads screen

  @negative
  Scenario: Verify an invalid email format is rejected
    When User opens the Leads screen
    And User taps "New lead button" on the Leads screen
    And User enters "Automation Lead" in "Customer name field" on the Leads screen
    And User scrolls to the text "Email" on the Leads screen
    And User enters "userexample.com" in "Email field" on the Leads screen
    And User taps "Save button" on the Leads screen
    Then User should see a validation or error message
    And User should see "Add lead heading" on the Leads screen

  @negative
  Scenario: Verify a Customer Name with spaces only is treated as empty
    When User opens the Leads screen
    And User taps "New lead button" on the Leads screen
    And User enters "   " in "Customer name field" on the Leads screen
    And User taps "Save button" on the Leads screen
    Then User should see a validation or error message
    And User should see "Add lead heading" on the Leads screen

  @negative
  Scenario: Verify searching for a lead that does not exist shows no results
    When User opens the Leads screen
    And User enters "zzzzqqqq" in "Search box" on the Leads screen
    Then User should see the no results message
