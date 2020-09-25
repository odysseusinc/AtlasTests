@login
Feature: Check login page

  @common
  Scenario:  Homepage check incorrect credentials
    When open project page
    When click to LogIn link
    When click Environment
    When login "daf" and password "das" Entered and submitted
    Then see message "Bad credentials"

  @common
  Scenario:  Homepage check correct credentials
    When login to ATLAS as QA



