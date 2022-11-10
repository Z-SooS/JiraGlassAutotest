@Regression
Feature: Glass general info display
  Scenario: Check preset values are displayer correctly
    Given i am logged in
    Given i am on glass page
    When i click on "General" tab
    Then basic summary contains "PokeTestProject"
    And basic summary contains "POK"

    Scenario: Correct workflow schemes associated with issue types
      Given i am logged in
      Given i am on glass page
      When i click on "General" tab
      Then the workflow scheme for "Task" is "POK: Scrum Default Screen Scheme"
      And the workflow scheme for "Sub-task" is "POK: Scrum Default Screen Scheme"
      And the workflow scheme for "Story" is "POK: Scrum Default Screen Scheme"
      And the workflow scheme for "Epic" is "POK: Scrum Default Screen Scheme"
      And the workflow scheme for "TestIssue" is "POK: Scrum Default Screen Scheme"
      But the workflow scheme for "Bug" is "POK: Scrum Bug Screen Scheme"