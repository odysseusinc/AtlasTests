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

  @chcopy
  Scenario: Create new characterization and copy it
    When login to ATLAS as QA
    When click to Characterizations menu as QA
    Then can see Characterization page
    When click to New characterization button
    When enter Characterization name and save it
    When return to Characterization table
    When enter created characterization name in filter
    Then can see new characterization in table
    When click to our characterization
    When click to copy characterization
    When click to cancel button
    When enter "COPY OF: " and name of our characterization
    Then can see copy of our characterization

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


  @eunomiaCharacterization
  Scenario: Import cohort definition, feature analyses, and generate with first data source
    When login to ATLAS as QA
    When click to Characterizations menu as QA
    Then can see Characterization page
    When click to New characterization button
    When enter Characterization name and save it
    When click to Import Cohort Definition
    Then can see window with cohort definition
    When choose cohort definition "Celecoxib new users" from the table in characterization
    Then can see cohort definition in characterization list with text "Celecoxib new users"
    When click to Import Feature analyses
    Then can see Feature analyses window
    When click to feature checkbox with text "Condition Era Long Term" from Feature analyses
    When click to feature checkbox with text "Condition Era Short Term" from Feature analyses
    When click to Import Feature analyse
    Then Feature analyse table is visible
    Then can see result of our search "Condition Era Short Term" and "Condition Era Long Term"
    When click to save Chacterization
    When click to Executions tab in Characterizations
    When click Generate report button on first data source
    Then first data source generate button has to be with Cancel text

  Scenario: Import definitions, features and IMPALA report
    When login to ATLAS as QA
    When click to Characterizations menu as QA
    Then can see Characterization page
    When click to New characterization button
    When enter Characterization name and save it
    When click to Import Cohort Definition
    Then can see window with cohort definition
    When choose cohort definition "New users of ACE inhibitors" from the table in characterization
    Then can see cohort definition in characterization list with text "New users of ACE inhibitors"
    When click to Import Feature analyses
    Then can see Feature analyses window
    When click to feature checkbox with text "Condition Era Long Term" from Feature analyses
    When click to feature checkbox with text "Condition Era Short Term" from Feature analyses
    When click to Import Feature analyse
    Then Feature analyse table is visible
    Then can see result of our search "Condition Era Short Term" and "Condition Era Long Term"
    When click Remove first Feature Analyse from the table
    When click to save Chacterization
    When click to Executions tab in Characterizations
    When click Generate report button on first data source
    Then first data source generate button has to be with Cancel text

  Scenario: Import definitions, features and Netezza report
    When login to ATLAS as QA
    When click to Characterizations menu as QA
    Then can see Characterization page
    When click to New characterization button
    When enter Characterization name and save it
    When click to Import Cohort Definition
    Then can see window with cohort definition
    When choose cohort definition "New users of ACE inhibitors" from the table in characterization
    Then can see cohort definition in characterization list with text "New users of ACE inhibitors"
    When click to Import Feature analyses
    Then can see Feature analyses window
    When click to feature checkbox with text "Condition Era Long Term" from Feature analyses
    When click to feature checkbox with text "Condition Era Short Term" from Feature analyses
    When click to Import Feature analyse
    Then Feature analyse table is visible
    Then can see result of our search "Condition Era Short Term" and "Condition Era Long Term"
    When click Remove first Feature Analyse from the table
    When click to save Chacterization
    When click to Executions tab in Characterizations
    When click to Netezza Generate report button
    Then Netezza generate button has to be with Cancel text

  @1107
  Scenario: Import definitions, features and SynPUF 110k CDM5.3 report
    When login to ATLAS as QA
    When click to Characterizations menu as QA
    Then can see Characterization page
    When click to New characterization button
    When enter Characterization name and save it
    When click to Import Cohort Definition
    Then can see window with cohort definition
    When choose cohort definition "New users of ACE inhibitors" from the table in characterization
    Then can see cohort definition in characterization list with text "New users of ACE inhibitors"
    When click to Import Feature analyses
    Then can see Feature analyses window
    When click to feature checkbox with text "Condition Era Long Term" from Feature analyses
    When click to feature checkbox with text "Condition Era Short Term" from Feature analyses
    When click to Import Feature analyse
    Then Feature analyse table is visible
    Then can see result of our search "Condition Era Short Term" and "Condition Era Long Term"
    When click Remove first Feature Analyse from the table
    When click to save Chacterization
    When click to Executions tab in Characterizations
    When click to SynPUF110k Generate report button
    Then SynPUF110k generate button has to be with Cancel text


  @1107
  Scenario: Import definitions, features and SynPUF 110k CDM5.3 report
    When login to ATLAS as QA
    When click to Characterizations menu as QA
    Then can see Characterization page
    When click to New characterization button
    When enter Characterization name and save it
    When click to Import Cohort Definition
    Then can see window with cohort definition
    When choose cohort definition "New users of ACE inhibitors" from the table in characterization
    Then can see cohort definition in characterization list with text "New users of ACE inhibitors"
    When click to Import Feature analyses
    Then can see Feature analyses window
    When click to feature checkbox with text "Condition Era Long Term" from Feature analyses
    When click to feature checkbox with text "Condition Era Short Term" from Feature analyses
    When click to Import Feature analyse
    Then Feature analyse table is visible
    Then can see result of our search "Condition Era Short Term" and "Condition Era Long Term"
    When click Remove first Feature Analyse from the table
    When click to save Chacterization
    When click to Executions tab in Characterizations
    When click to oracle Generate report button
    Then oracle generate button has to be with Cancel text

    @sub
  Scenario: Create characterization with Subgroup analyses and Feature Analyses
    When login to ATLAS as QA
    When click to Characterizations menu as QA
    Then can see Characterization page
    When click to New characterization button
    When enter Characterization name and save it
    When click to Import Cohort Definition
    Then can see window with cohort definition
    When choose cohort definition "New users of ACE inhibitors" from the table in characterization
    Then can see cohort definition in characterization list with text "New users of ACE inhibitors"
    When click to Import Feature analyses
    Then can see Feature analyses window
    When click to feature checkbox with text "Condition Era Long Term" from Feature analyses
    When click to feature checkbox with text "Condition Era Short Term" from Feature analyses
    When click to Import Feature analyse
    Then Feature analyse table is visible
    Then can see result of our search "Condition Era Short Term" and "Condition Era Long Term"
    When click to Add Subgroup analyses
    Then can see Stratified input and subgroup table
    When enter Stratified by text "test"
    When click to add criteria to group button
    When click to Add Demographic point
    Then can see Add attribute button
    When click to New parameter button
    When enter name of parameter "test" and value "0" and click Submit button
    Then can see our parameter "test" and value "0" in the table





