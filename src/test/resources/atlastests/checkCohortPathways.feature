@cohortpathways
Feature: Cohort Pathway check

  @1707 @common
  Scenario: Create, Edit, copy and delete pathway
    When login to ATLAS as QA
    When click to Cohort Pathways menu as QA
    Then can see Cohort Pathway page
    When click to button New Pathway Analysis
    Then can see creation page of New Cohort Pathway
    When enter new name of cohort pathway
    When click to save New Cohort Pathway button
    Then can see buttons to cohort pathway
    When click to cancel button
    Then can see table with our cohort pathway
    When enter name of our pathway in filter
    Then can see name of new cohort pathway in table
    When click to cohort pathway in table
    Then can see our cohort pathway
    When change name and press save
    Then can see new name of new cohort pathway in table
    When click to cohort pathway in table
    When click to copy button for our cohort pathway
    When click to cancel button
    When enter "COPY OF " and name of our cohort pathway
    Then can see copy of our pathway
    When click to cohort pathway in table
    When click to delete our cohort pathway
    When accept delete cohort pathway
    Then cant see our cohort pathway in table

  @common
  Scenario:  Check uniqueness of cohort pathway
    When login to ATLAS as QA
    When click to Cohort Pathways menu as QA
    Then can see Cohort Pathway page
    When click to button New Pathway Analysis
    Then can see creation page of New Cohort Pathway
    When enter new name of cohort pathway
    When click to save New Cohort Pathway button
    Then can see buttons to cohort pathway
    When click to cancel button
    Then can see table with our cohort pathway
    When enter name of our pathway in filter
    Then can see name of new cohort pathway in table
    When click to button New Pathway Analysis
    Then can see creation page of New Cohort Pathway
    When enter the same name of cohort pathway
    When click to save New Cohort Pathway button special case
    Then can see alert message about uniqueness

  @common
  Scenario: Choose target cohorts and event cohorts
    When login to ATLAS as QA
    When click to Cohort Pathways menu as QA
    Then can see Cohort Pathway page
    When click to button New Pathway Analysis
    Then can see creation page of New Cohort Pathway
    When enter new name of cohort pathway
    When click to save New Cohort Pathway button
    When click to Import Target Cohorts
    When choose cohort definition "Celecoxib new users" from the table
    Then can see cohort definition in target cohort list list
    When click to Import Event Cohorts
    When choose cohort definition "bleed" from the table
    Then can see cohort definition in event cohort list list
    When click to save our cohort pathway

  @common
  Scenario: Executions and Utilities tab
    When login to ATLAS as QA
    When click to Cohort Pathways menu as QA
    Then can see Cohort Pathway page
    When click to button New Pathway Analysis
    Then can see creation page of New Cohort Pathway
    When enter new name of cohort pathway
    When click to save New Cohort Pathway button
    When click to Executions tab
    Then can see Execution page
    When click to Utilities tab
    Then can see Utilities page

  @exp @common
  Scenario: Export and Import
    When login to ATLAS as QA
    When click to Cohort Pathways menu as QA
    Then can see Cohort Pathway page
    When click to button New Pathway Analysis
    Then can see creation page of New Cohort Pathway
    When enter new name of cohort pathway
    When click to save New Cohort Pathway button
    When click to Import Target Cohorts
    When choose cohort definition "Celecoxib new users" from the table
    Then can see cohort definition in target cohort list list
    When click to Import Event Cohorts
    When choose cohort definition "bleed" from the table
    Then can see cohort definition in event cohort list list
    When click to save our cohort pathway
    When click to cancel button
    Then can see table with our cohort pathway
    When click to cohort pathway in table
    When click to Utilities tab
    When copy text from export textarea
    When click to cancel button
    When click to button New Pathway Analysis
    Then can see creation page of New Cohort Pathway
    When enter new name of cohort pathway
    When click to save New Cohort Pathway button
    When click to Utilities tab
    When click to Import cohort pathway
    When past json to pathway textarea
    When click Import button in Pathways
    When click to Design tab
    Then can see target cohorts in table like as "Celecoxib new users"


