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
@tag
Feature: Assign leave

  @tag1
  Scenario: Assign leave
    Given User is logged in
    And clicks on Assign Leave options
    And Enters employee name "Rebecca Harmony"
    And Selects Leave type
    And adds comment
    And Select Date 
    When Taps on assign button
    And Taps on entitlement
    And Tap on employee entitlement
    And Enter employee name "Rebecca Harmony"
    Then name of employee who was assigned leave should appear
    


