@characterization
Feature: Characterization check

  Scenario: Create new characterization and delete it
    When login to ATLAS as QA
    When click to Characterizations menu as QA
    Then can see Characterization page
    When click to New characterization button
    When enter Characterization name and save it
    When return to Characterization table
    When enter created characterization name in filter
    Then can see new characterization in table
    When click to our characterization
    When click to delete characterization button
    When accept delete characterization
    Then cant find characterization in the table

  @chun
  Scenario: Check uniqueness of characterization
    When login to ATLAS as QA
    When click to Characterizations menu as QA
    Then can see Characterization page
    When click to New characterization button
    When enter Characterization name and save it
    When return to Characterization table
    When click to New characterization button
    When enter the same Characterization name and save it
    Then can see alert message about uniqueness

    @2406
  Scenario: Add new feature analyses and delete it
    When login to ATLAS as QA
    When click to Characterizations menu as QA
    Then can see Characterization page
    When click to Feature Analyses tab
    Then can see Feature Analyses table
    When click to New Feature analyses
    Then can see page of creation New Feature Analyse
    When enter name of New Feature Analyse
    When enter description
    When choose Criteria design
    When click to save feature analyse button
    Then go to feature analyses table by pressing close button
    When enter name of our feature to filter
    Then can see our feature in table of feature analyses
    When click to our feature analyse
    Then can see page of our Feature Analyse
    When click to delete feature analyse
    When accept delete feature analyse
    Then cant find feature analyse in the table

  Scenario: Import definitions, features and tabs
    When login to ATLAS as QA
    When click to Characterizations menu as QA
    Then can see Characterization page
    When click to New characterization button
    When enter Characterization name and save it
    #Need to check
    When click to Import Cohort Definition
    Then can see window with cohort definition
    When choose cohort definition from the table in characterization
    Then can see cohort definition in characterization list
    When click to Import Feature analyses
    Then can see Feature analyses window
    When click to feature checkbox from Feature analyses
    When click to Import Feature analyse
    Then Feature analyse table is visible








