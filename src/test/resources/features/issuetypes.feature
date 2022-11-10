Feature: Issue Type display
  Scenario: All preset issue types are available
    Given i am logged in
    Given i am on glass page
    When i click on "Issue Types" tab
    Then issue types list contains "Task"
    And issue types list contains "Sub-task"
    And issue types list contains "Story"
    And issue types list contains "Bug"
    And issue types list contains "Epic"
    And issue types list contains "TestIssue"