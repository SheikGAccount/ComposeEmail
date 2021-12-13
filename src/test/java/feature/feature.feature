#Author: sheikabdulkadar12@gmail.com
#Keywords Summary : Test Compose Function in Gmail to send an email with the body "Automation QA Test for Incubyte" and subject "Incubyte"
Feature: Login to Gmail,  Compose email and Verify Sent email
  
  @Unit
  Scenario: Login to Gmail
    Given User Launch the Chrome Browser and navigates to Gmail Login Page
    When User enters Username "SelTestMail1" and Click Next
    And User enters Password "SAKU1234" and Click Next
    Then User successfully logged in Gmail account


  @Regression
  Scenario Outline: Login to Gmail and Compose Email
    Given User Launch the Chrome Browser and navigates to Gmail Login Page
    When User enters Username "SelTestMail1" and Click Next
    And User enters Password "SAKU1234" and Click Next
    Then User successfully logged in Gmail account
    When User navigates to Compose Mail Page
    And User Enters To Address as "<EmailTo>"
    And User Enters Subject as "<Subject>"
    And User Enters the Email Body as "<Body>"
    And User Clicks Send
    Then Verify Email Sent
    
    Examples: 
      | EmailTo | Subject | Body |
      | sheikabdulkadar12@gmail.com | Incubyte | Automation QA Test for Incubyte |
     