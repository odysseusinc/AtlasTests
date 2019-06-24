@cohortdefinitions
Feature: Check Cohort Definitions

  Scenario: Create, edit and delete cohort
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
    When enter new name of cohort definition
    When save new name of cohort definition
    When click to Cohort Definitions menu as QA
    Then filtered new Cohort Definition
    Then new Cohort Definition should be found
    When click to our Cohort Definition
    Then can see our Cohort Definition
    When click to delete our Cohort Definition
    When accept delete Cohort Definition alert
    Then filtered Cohort Definition
    Then Cohort Definition should be not found

  Scenario: Check uniqueness of cohort definition
    When login to ATLAS as QA
    When click to Cohort Definitions menu as QA
    Then can see Cohort Definition page
    When click New Cohort button
    Then can see new cohort page creation
    When enter name of New Cohort Definition and save it
    When click to cancel button
    When click New Cohort button
    When enter the same name of New Cohort Definition and save it
    Then can see alert message about uniqueness
  @dev_new_t
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
    When click to Id to sort
    When enter "10" to Filter of Concept Set from Repository
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
    When click to Close concept set
    Then table of concept sets close

  @2406
  Scenario: Cohort Definitions tabs
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
    When enter "10" to Filter of Concept Set from Repository
    When click to Id to sort
    Then can see only one field
    When click to chosen concept set from repository
    Then can see name of concept set at the button
    When click to Concept Sets tab
    Then can see row with name of Concept Set in the table
    When click to Generation tab
    Then can see Generation page
    When click to Reporting tab
    Then can see reporting page
    When click to Export tab in Cohort Definitions
    Then can see Export page
#    When click to Messages Tab
#    When click to Run diagnostic Button
#    Then can see Messages page


  Scenario: inclusion criterias
    When login to ATLAS as QA
    When click to Cohort Definitions menu as QA
    Then can see Cohort Definition page
    When click New Cohort button
    Then can see new cohort page creation
    When enter name of New Cohort Definition and save it
    When add Inclusion criteria
    Then can see block with inclusion criterias

#  Scenario: Export Cohort Definitions
#    When login to ATLAS as QA
#    When click to Cohort Definitions menu as QA
#    Then can see Cohort Definition page
#    When click New Cohort button
#    Then can see new cohort page creation
#    When enter name of New Cohort Definition and save it
#    #TODO next
#
