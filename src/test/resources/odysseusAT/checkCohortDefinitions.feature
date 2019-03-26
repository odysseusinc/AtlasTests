@cohortdefinitions
Feature: Check Cohort Definitions

  Scenario: Create and delete cohort
    When login to ATLAS as QA
    When click to Cohort Definitions menu as QA
    Then can see Cohort Definition page
    When click New Cohort button
    Then can see new cohort page creation
    When enter name of New Cohort Definition and save it
    When click to Cohort Definitions menu as QA
    Then filtered Cohort Definition
    Then Cohort Definition should be found
    When click to our Cohort Definition
    Then can see our Cohort Definition
    When click to delete our Cohort Definition
    When accept delete Cohort Definition alert
    Then filtered Cohort Definition
    Then Cohort Definition should be not found


  @dev
  Scenario: Add Initial events to new Cohort

    When login to ATLAS as QA
    When click to Cohort Definitions menu as QA
    Then can see Cohort Definition page
    When click New Cohort button
    Then can see new cohort page creation
    When enter name of New Cohort Definition and save it
    When press Add Initial Event
    When press Add Condition Era
    Then a condition era block shown
    When click to Any Condition menu
    When choose Import Concept Set
    Then Import Concept Set window shown
    When enter "71" to Filter of Concept Set from Repository
    #hardcode, fix later
    Then can see only one field
    #
    When click to chosen concept set from repository
    #hardcode, fix later
    Then can see name of concept set at the button
    #
    When click to Concept Sets tab
    Then can see row with name of Concept Set in the table
    When click on the row in table concept set in cohort definitions
    Then can see table of concept set with concepts

