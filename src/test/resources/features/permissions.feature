@Regression
Feature: Glass permissions viewer

  Scenario: Preset permissions are displayed correctly
    Given i am logged in
    And i am on glass page
    When i click on "Permissions" tab
    And i click on "View by Actors" tab
    Then under Any logged in user i will find "Browse Projects"
    And under Any logged in user i will find "Create Issues"
    And under Any logged in user i will find "Edit Issues"
    Then under Any logged in user i will not find "Delete Issues"