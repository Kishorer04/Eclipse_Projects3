#Author: your.email@your.domain.com
#Keywords Summary :
#Feature: List of scenarios.
#Scenario: Business rule through list of steps with arguments.
#Given: Some precondition step
#When: Some key actions
#Then: To observe outcomes or validation
#And,But: To enumerate more Given,When,Then steps
#Scenario Outline: List of steps for data-driven as an Examples and <placeholder>
#Examples: Container for s table
#Background: List of steps run before each of the scenarios
#""" (Doc Strings)
#| (Data Tables)
#@ (Tags/Labels):To group Scenarios
#<> (placeholder)
#""
## (Comments)
#Sample Feature Definition Template
########################################################################
#Can use Given also instead of And

Feature: BookCart application demo

  Scenario: Login should be success

    Given User should navigate to the application
    And User clicks on the login link    
    And User enter the username as "ortoni"
    And User enter the password as "pass1234"
    When User click the login button
    Then login should be success

  Scenario: Login should be fail

    Given User should navigate to the application
    And User clicks on the login link
    And User enter the username as "kishore"
    And User enter the password as "passkishore"
    When User click the login button
    But login should be fail
