@Attendance
Feature: Attendance module of the CRM application

  Background:
    Given User is on the Dashboard screen

  @positive
  Scenario: Verify the Time Clock screen and the leave request section are displayed
    When User opens the Attendance screen
    Then User should see "Time clock tab" on the Attendance screen
    And User should see "Stats tab" on the Attendance screen
    And User scrolls to the text "Request Leave" on the Attendance screen
    And User should see "Request leave label" on the Attendance screen
    And User should see "Apply leave label" on the Attendance screen
    And User should see "Apply button" on the Attendance screen
    And User should see "Leave date header" on the Attendance screen
    And User should see "Leave status header" on the Attendance screen

  @positive
  Scenario: Verify the attendance statistics are displayed on the Stats tab
    When User opens the Attendance screen
    And User taps "Stats tab" on the Attendance screen
    Then User should see "Working days" on the Attendance screen
    And User should see "Present day" on the Attendance screen
    And User should see "Absent" on the Attendance screen
    And User should see "Workdays stats" on the Attendance screen

  @positive
  Scenario: Verify the Working Hours section is displayed on the Stats tab
    When User opens the Attendance screen
    And User taps "Stats tab" on the Attendance screen
    And User scrolls to the text "Working Hours" on the Attendance screen
    Then User should see "Working hours" on the Attendance screen

  @positive
  Scenario: Verify the Apply Leave Form opens from the Apply button
    When User opens the Attendance screen
    And User scrolls to the text "Request Leave" on the Attendance screen
    And User taps "Apply button" on the Attendance screen
    Then User should see "Apply leave form" on the Attendance screen
    And User should see "Write reason label" on the Attendance screen
    And User should see "Reason field" on the Attendance screen
    And User should see "Request button" on the Attendance screen
    And User should see "Close button" on the Attendance screen

  @positive
  Scenario: Verify the leave history shows the leave status tags
    When User opens the Attendance screen
    And User scrolls to the text "Request Leave" on the Attendance screen
    Then User should see "Approved status" on the Attendance screen

  @positive
  Scenario: Verify the bottom navigation options are displayed
    When User opens the Attendance screen
    Then User should see "Tab dashboard" on the Attendance screen
    And User should see "Tab leads" on the Attendance screen
    And User should see "Tab attendance" on the Attendance screen
    And User should see "Tab profile" on the Attendance screen

  @positive
  Scenario: Verify switching between the Time Clock and Stats tabs
    When User opens the Attendance screen
    And User taps "Stats tab" on the Attendance screen
    And User taps "Time clock tab" on the Attendance screen
    Then User should see "Time clock tab" on the Attendance screen
    And User should see "Stats tab" on the Attendance screen

  @positive
  Scenario: Verify the Close link closes the Apply Leave Form
    When User opens the Attendance screen
    And User scrolls to the text "Request Leave" on the Attendance screen
    And User taps "Apply button" on the Attendance screen
    And User taps "Close button" on the Attendance screen
    Then User should not see "Apply leave form" on the Attendance screen

  @positive
  Scenario: Verify a leave request can be submitted with a valid reason
    When User opens the Attendance screen
    And User scrolls to the text "Request Leave" on the Attendance screen
    And User taps "Apply button" on the Attendance screen
    And User enters "Due to health conditions" in "Reason field" on the Attendance screen
    And User taps "Request button" on the Attendance screen
    Then User should not see "Apply leave form" on the Attendance screen

  @negative
  Scenario: Verify a leave request with an empty reason is not sent
    When User opens the Attendance screen
    And User scrolls to the text "Request Leave" on the Attendance screen
    And User taps "Apply button" on the Attendance screen
    And User taps "Request button" on the Attendance screen
    Then User should see "Apply leave form" on the Attendance screen

  @negative
  Scenario: Verify a leave reason with spaces only is not sent
    When User opens the Attendance screen
    And User scrolls to the text "Request Leave" on the Attendance screen
    And User taps "Apply button" on the Attendance screen
    And User enters "   " in "Reason field" on the Attendance screen
    And User taps "Request button" on the Attendance screen
    Then User should see "Apply leave form" on the Attendance screen

  @negative
  Scenario: Verify the leave reason is limited to 300 characters
    When User opens the Attendance screen
    And User scrolls to the text "Request Leave" on the Attendance screen
    And User taps "Apply button" on the Attendance screen
    And User enters 350 characters in "Reason field" on the Attendance screen
    Then "Characters left text" should contain "0 character" on the Attendance screen

  @negative
  Scenario: Verify Check In with no internet shows a message
    When User opens the Attendance screen
    And User turns on flight mode
    And User taps "Check in button" on the Attendance screen
    Then User should see a validation or error message

  @negative
  Scenario: Verify the Apply Leave Form is empty when it is opened again after Close
    When User opens the Attendance screen
    And User scrolls to the text "Request Leave" on the Attendance screen
    And User taps "Apply button" on the Attendance screen
    And User enters "abc" in "Reason field" on the Attendance screen
    And User taps "Close button" on the Attendance screen
    And User taps "Apply button" on the Attendance screen
    Then "Reason field" should be empty on the Attendance screen

  @negative
  Scenario: Verify the device Back button on the Attendance screen
    When User opens the Attendance screen
    And User presses the device Back button
    Then The app should still respond
