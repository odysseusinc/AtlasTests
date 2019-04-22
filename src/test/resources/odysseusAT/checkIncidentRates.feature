@incidencerates
Feature: Incident rates check

  Scenario: Create IR, save, edit, delete
    When login to ATLAS as QA
    When click to Incidence Rates menu as QA
    Then can see Incidence Rates page
    When click to New Analysis button in Incidence Rates
    Then can see Incidence Rates creation page
    When enter name on new Incidence Rates
    When click to save Incidence Rates Button
    Then can see new buttons in incidence rates field
    When click to cancel button in Incidence rates
    When enter name of our IR in filter
    Then can see our incidence rate in table
    When click to our incidence rate
    Then can see our incidence rate
    When enter new name of incidence rate
    When click to save Incidence Rates Button
    When click to cancel button in Incidence rates
    When enter name of new IR in filter
    Then can see new incidence rate in table
    When click to new incidence rate
    When click to delete IR button
    When accept delete IR alert
    Then cant find IR in table

  Scenario: Check tabs in IR
    When login to ATLAS as QA
    When click to Incidence Rates menu as QA
    Then can see Incidence Rates creation page
    When enter name on new Incidence Rates
    When click to save Incidence Rates Button
    When click to Concept Sets tab in IR
    Then can see concept set page in IR
    When click to Generation tab in IR
    Then can see Generation page in IR
    When click to Utilities page in IR
    Then can see Utilities page in IR

  Scenario: Create IR as Angioedema across levetriacetam new users
    When login to ATLAS as QA
    When click to Incidence Rates menu as QA
    Then can see Incidence Rates creation page
    When enter name on new Incidence Rates
    When click to save Incidence Rates Button
    When click to add Target Cohort
    When enter "New users of phenytoin" in filter of cohort
    When click to result in IR
    When enter "New users of levetiracetam" in filter of cohort
    When click to result in IR
    When close Cohort window in IR
    Then can see new rows under Target Cohorts
    When click to Add Outcome Cohort
    When enter "Levetriacetam vs phenytoin outcome cohort" in filter of cohort
    When click to result in IR
    When close Cohort window in IR
    Then can see new rows under Outcome Cohort
    When choose Time at risk starts with value 14
    When choose Time at risk ends with value 21
    When click to Concept Sets tab
    When press Load Concept Set in IR
    When enter "Angioedema or Depression" in filter Concept Set in IR
    When click to result in CS in IR
    Then can see chosen concept set in table
