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
Feature: Free Login Application feature

  @tag1
Scenario Outline: User Login scenario
    Given User is on the Application Home Page
    When Application Page Title is Free CRM
    Then User click on SignUp button
    When Application Page Title is Cogmento CRM
    Then User click on Got an account button
    When user is on the Login page
    Then User enters username and password
  	When User navigate to user profile page
  	Then Mouse Hover on Contacts and Click new Contact
  	And User enters Contact Details <firstname> and <lastname> and <position> and <department>
		Then Click Submit button
Examples:
		 | firstname | lastname | position | department |
		 | Deepu | Jose | QA Tester | Testing |
#		 | Ann | Joseph | QA Tester | Testing | 	
#		 | Test | Test | QA Tester | Testing |
 