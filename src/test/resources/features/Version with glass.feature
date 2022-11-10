# Created by Darren
Feature: Version with glass
  As a project admin I want to manage versions, so that I can connect issues to versions

  Scenario: The previously given components are visible.
    Given i am logged in
    Given i am on glass page
    When open the provided url for "/projects/POK/versions/10012"
    When click on visible issue with provided name "I need an issue to add"
    When click on edit button
    When select "Week-6-test" under "Fix Version/s" menu point
    When click on "Update" button
    When open the provided url for "/projects/POK/versions/10012"
    Then issue with summary "I need an issue to add" is visible