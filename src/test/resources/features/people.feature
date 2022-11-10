@Regression
Feature: Glass people page display
  Scenario: Display preset users correctly
    Given i am logged in
    Given i am on glass page
    When i click on "People" tab
    Then under user i find "Auto Tester 25"
    And under user i find "Auto Tester 26"
    And under user i find "Auto Tester 27"
    And under user i find "Auto Tester 28"
    And under user i find "Auto Tester 29"