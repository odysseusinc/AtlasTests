Feature: Cohort Pathway check

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
    Then can see new name of new cohost pathway in table
    When click to cohort pathway in table
    When click to delete our cohort pathway
    Then cant see our cohort pathway in table

  Scenario: Choose target cohorts and event cohorts
    When login to ATLAS as QA
    When click to Cohort Pathways menu as QA
    Then can see Cohort Pathway page
    When click to button New Pathway Analysis
    Then can see creation page of New Cohort Pathway
    When enter new name of cohort pathway
    When click to save New Cohort Pathway button
    When click to Import Target Cohorts
    Then can see window with cohort definition
    When choose cohort definition from the table in target cohort list
    Then can see cohort definition in target cohort list list
    When click to Import Event Cohorts
    Then can see window with cohort definition
    When choose cohort definition from the table in event cohort list
    Then can see cohort definition in event cohort list list

  Scenario: Executions and Utilities tab
    When login to ATLAS as QA
    When click to Cohort Pathways menu as QA
    Then can see Cohort Pathway page
    Then can see creation page of New Cohort Pathway
    When enter new name of cohort pathway
    When click to save New Cohort Pathway button
    When click to Executions tab
    Then can see Execution page
    When click to Utilities tab
    Then can see Utilities page
