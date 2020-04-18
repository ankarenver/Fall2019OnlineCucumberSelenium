@activities
Feature: Create calendar event
  As user, I want to be able to create calendar events.

  Scenario: Create calendar event as sales manager
    Given user is on the login page
    When user logs in as a sales manager
    And user navigate to "Activities" and "Calendar Events"
    Then user click on create calendar event button
    And user enters "Sprint Retrospective" as title
    And user enters "On this meeting we discuss what went well, what went wrong and what can be improved" as description
    And user clicks on save and close button
    And user verify that description of new calendar event is "On this meeting we discuss what went well, what went wrong and what can be improved"
    And user verifies that title of new calendar event is "Sprint Retrospective"