@jira=myfeaturenumber
Feature: auto test
  As a user, i would like to check your knowledge in auto test

  Background:  Home page
    Given Navigate to home page "Cookie"

  Scenario: manage game
    When The name "Giuseppe" is given
    Then New game will start

  Scenario: manage game
    When The name "Julius" is given
    And  New game will start
    Then I add new cookies

