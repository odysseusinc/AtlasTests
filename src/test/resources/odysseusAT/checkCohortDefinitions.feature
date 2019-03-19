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

  Scenario: Add Initial events to new Cohort

    When login to ATLAS as QA
    When click to Cohort Definitions menu as QA
    Then can see Cohort Definition page
    When click New Cohort button
    Then can see new cohort page creation
    When enter name of New Cohort Definition and save it