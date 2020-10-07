@cohortdefinitions
Feature: Check Cohort Definitions

  @common
  Scenario: Create, edit and delete cohort
    When login to ATLAS as QA
    When click to Cohort Definitions menu as QA
    Then can see Cohort Definition page
    When click New Cohort button
    Then can see new cohort page creation
    When enter name of New Cohort Definition and save it
    When click to close cohort button
    Then filtered Cohort Definition
    Then Cohort Definition should be found
    When click to our Cohort Definition
    Then can see our Cohort Definition
    When enter new name of cohort definition
    When save new name of cohort definition
    When click to close cohort button
    Then filtered new Cohort Definition
    Then new Cohort Definition should be found
    When click to our Cohort Definition
    Then can see our Cohort Definition
    When click to delete our Cohort Definition
    When accept delete Cohort Definition alert
    Then filtered Cohort Definition
    Then Cohort Definition should be not found

  @common
  Scenario: Check uniqueness of cohort definition
    When login to ATLAS as QA
    When click to Cohort Definitions menu as QA
    Then can see Cohort Definition page
    When click New Cohort button
    Then can see new cohort page creation
    When enter name of New Cohort Definition and save it
    When click to close cohort button
    When click New Cohort button
    When enter the same name of New Cohort Definition and save it
    Then can see alert message about uniqueness

  @dev_new_t @common
  Scenario: Add Initial events to new Cohort
    When login to ATLAS as QA
    When click to Cohort Definitions menu as QA
    Then can see Cohort Definition page
    When click New Cohort button
    Then can see new cohort page creation
    When enter name of New Cohort Definition and save it
    When press Add Initial Event
    When press Add Condition Occurrence
    Then condition occurrence block shown
    When click to Any Condition menu
    When choose Import Concept Set
    Then Import Concept Set window shown
    When click to Id to sort
    When enter "Angioedema" to Filter of Concept Set from Repository
    Then can see only one field with text "Angioedema"
    When click to chosen concept set from repository
    Then can see name "Angioedema" of concept set at the button
    When add Inclusion criteria with group: "Drug Era"
    Then can see block with inclusion criterias
    When click to save button in Cohort Definition
    When click to Concept Sets tab
    Then can see row with name of Concept Set in the table
    When click on the row in table concept set in cohort definitions
    Then can see table of concept set with concept: "Angioedema"
    When click to Close concept set
    Then table of concept sets close

  @common
  Scenario: Cohort Definitions tabs
    When login to ATLAS as QA
    When click to Cohort Definitions menu as QA
    Then can see Cohort Definition page
    When click New Cohort button
    Then can see new cohort page creation
    When enter name of New Cohort Definition and save it
    When press Add Initial Event
    When press Add Condition Occurrence
    Then condition occurrence block shown
    When click to Any Condition menu
    When choose Import Concept Set
    Then Import Concept Set window shown
    When enter "angioedema" to Filter of Concept Set from Repository
    When click to Id to sort
    Then can see only one field with text "Angioedema"
    When click to chosen concept set from repository
    Then can see name "Angioedema" of concept set at the button
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

  @common
  Scenario: inclusion criterias
    When login to ATLAS as QA
    When click to Cohort Definitions menu as QA
    Then can see Cohort Definition page
    When click New Cohort button
    Then can see new cohort page creation
    When enter name of New Cohort Definition and save it
    When add Inclusion criteria
    Then can see block with inclusion criterias

  @common
  Scenario: Export and Import to new Cohort Definition
    When login to ATLAS as QA
    When click to Cohort Definitions menu as QA
    Then can see Cohort Definition page
    When enter "New users of ACE inhibitors who have a prior diagnosis of hypertension" in filter in cohort definition
    Then click to founded result
    When click to Export tab in Cohort Definitions
    When click to JSON tab in Cohort Definitions
    When click to Copy to clipboard button
    When click to close cohort button
    When click New Cohort button
    When click to Export tab in Cohort Definitions
    When click to JSON tab in Cohort Definitions
    When clear json input
    When past json from clipboard
    When click to Reload button
    When click to Definition tab
    Then can see name "ACE inhibitors" of concept set at the button

  @ohdsi @executions
  Scenario: Generate using first data source, quick analysis and Export tabs
    When login to ATLAS as QA
    When click to Cohort Definitions menu as QA
    Then can see Cohort Definition page
    When click New Cohort button
    Then can see new cohort page creation
    When enter name of New Cohort Definition and save it
    When press Add Initial Event
    When press Add Condition Occurrence
    Then condition occurrence block shown
    When click to Any Condition menu
    When choose Import Concept Set
    Then Import Concept Set window shown
    When click to Id to sort
    When enter "Chronic sinusitis" to Filter of Concept Set from Repository
    Then can see only one field with text "Chronic sinusitis"
    When click to chosen concept set from repository
    Then can see name "Chronic sinusitis" of concept set at the button
    When add Inclusion criteria with group: "Drug Era"
    Then can see block with inclusion criterias
    When click to save button in Cohort Definition
    When click to Generation tab
    When click to Generate first data source button
    Then can see Complete in first data source status in 360 seconds
    When click to Reporting tab tab
    When select first data source
    When click to quick analysis button
    When accept an alert about time
    Then can see a row with status Started
    When click to Export tab in Cohort Definitions
    Then can see "Chronic sinusitis" in Initial Event Cohort
    When click to Graphical View
    Then can see "Chronic sinusitis" in Primary Criteria
    When click to SQL tab
    Then can see sql query

  @odysseus @executions
  Scenario: Generate IMPALA and Export tabs
    When login to ATLAS as QA
    When click to Cohort Definitions menu as QA
    Then can see Cohort Definition page
    When click New Cohort button
    Then can see new cohort page creation
    When enter name of New Cohort Definition and save it
    When press Add Initial Event
    When press Add Condition Occurrence
    Then condition occurrence block shown
    When click to Any Condition menu
    When choose Import Concept Set
    Then Import Concept Set window shown
    When click to Id to sort
    When enter "angioedema" to Filter of Concept Set from Repository
    Then can see only one field with text "angioedema"
    When click to chosen concept set from repository
    Then can see name "angioedema" of concept set at the button
    When add Inclusion criteria with group: "Drug Era"
    Then can see block with inclusion criterias
    When click to save button in Cohort Definition
    When click to Generation tab
    When click to Generate Impala button
    Then can see Complete in IMPALA status in 360 seconds
    When click to Reporting tab tab
    When select "IMPALA" source
    When click to quick analysis button
    When accept an alert about time
    Then can see a row with status Started
    When click to Export tab in Cohort Definitions
    Then can see "angioedema" in Initial Event Cohort
    When click to Graphical View
    Then can see "angioedema" in Primary Criteria
    When click to SQL tab
    Then can see sql query

  @ohdsi @executions
  Scenario: Generate using first data source and Cost&Util
    When login to ATLAS as QA
    When click to Cohort Definitions menu as QA
    Then can see Cohort Definition page
    When click New Cohort button
    Then can see new cohort page creation
    When enter name of New Cohort Definition and save it
    When press Add Initial Event
    When press Add Condition Occurrence
    Then condition occurrence block shown
    When click to Any Condition menu
    When choose Import Concept Set
    Then Import Concept Set window shown
    When click to Id to sort
    When enter "Chronic sinusitis" to Filter of Concept Set from Repository
    Then can see only one field with text "Chronic sinusitis"
    When click to chosen concept set from repository
    Then can see name "Chronic sinusitis" of concept set at the button
    When add Inclusion criteria with group: "Drug Era"
    Then can see block with inclusion criterias
    When click to save button in Cohort Definition
    When click to Generation tab
    When click to Generate first data source button
    Then can see Complete in first data source status in 360 seconds
    When click to Reporting tab tab
    When select first data source
    When click to utilisation button
    Then configure of reports to run window opens
    When choose reports and press Run
    When accept an alert about time
    Then can see a row with status Started

  @dev0907 @odysseus @executions @costutil
  Scenario: Generate SynPUF 110K Cost&Util
    When login to ATLAS as QA
    When click to close cohort button
    Then can see Cohort Definition page
    When click New Cohort button
    Then can see new cohort page creation
    When enter name of New Cohort Definition and save it
    When press Add Initial Event
    When press Add Condition Occurrence
    Then condition occurrence block shown
    When click to Any Condition menu
    When choose Import Concept Set
    Then Import Concept Set window shown
    When click to Id to sort
    When enter "ACE" to Filter of Concept Set from Repository
    Then can see only one field with text "ACE"
    When click to chosen concept set from repository
    Then can see name "ACE" of concept set at the button
    When add Inclusion criteria with group: "Drug Era"
    Then can see block with inclusion criterias
    When click to save button in Cohort Definition
    When click to Generation tab
    When click to Generate SynPUF 110K Cost&Util button
    Then can see Complete in SynPUF 110K Cost&Util status in 180 seconds
    When click to Reporting tab tab
    When select "SynPUF 110K Cost&Util" source
    When click to utilisation button
    Then configure of reports to run window opens
    When choose reports and press Run
    When accept an alert about time
    Then can see a row with status Started

  @ohdsi @executions
  Scenario: Generate using first data source and Full analysis
    When login to ATLAS as QA
    When click to Cohort Definitions menu as QA
    Then can see Cohort Definition page
    When click New Cohort button
    Then can see new cohort page creation
    When enter name of New Cohort Definition and save it
    When press Add Initial Event
    When press Add Condition Occurrence
    Then condition occurrence block shown
    When click to Any Condition menu
    When choose Import Concept Set
    Then Import Concept Set window shown
    When click to Id to sort
    When enter "Chronic sinusitis" to Filter of Concept Set from Repository
    Then can see only one field with text "Chronic sinusitis"
    When click to chosen concept set from repository
    Then can see name "Chronic sinusitis" of concept set at the button
    When add Inclusion criteria with group: "Drug Era"
    Then can see block with inclusion criterias
    When click to save button in Cohort Definition
    When click to Generation tab
    When click to Generate first data source button
    Then can see Complete in first data source status in 360 seconds
    When click to Reporting tab tab
    When select first data source
    When click to Full analysis button
    When accept an alert about time
    Then can see a row with status Started

  @odysseus @executions
  Scenario: Generate  SynPUF 110k CDM5.3 and Full analysis
    When login to ATLAS as QA
    When click to Cohort Definitions menu as QA
    Then can see Cohort Definition page
    When click New Cohort button
    Then can see new cohort page creation
    When enter name of New Cohort Definition and save it
    When press Add Initial Event
    When press Add Condition Occurrence
    Then condition occurrence block shown
    When click to Any Condition menu
    When choose Import Concept Set
    Then Import Concept Set window shown
    When click to Id to sort
    When enter "angioedema" to Filter of Concept Set from Repository
    Then can see only one field with text "angioedema"
    When click to chosen concept set from repository
    Then can see name "angioedema" of concept set at the button
    When add Inclusion criteria with group: "Drug Era"
    Then can see block with inclusion criterias
    When click to save button in Cohort Definition
    When click to Generation tab
    When click to Generate: "SynPUF 110k PG12"
    Then can see Complete in "SynPUF 110k PG12" status in 360 seconds
    When click to Reporting tab tab
    When select "SynPUF 110k PG12" source
    When click to Full analysis button
    When accept an alert about time
    Then can see a row with status Started
    When click to Export tab in Cohort Definitions
    Then can see "angioedema" in Initial Event Cohort
    When click to Graphical View
    Then can see "angioedema" in Primary Criteria
    When click to SQL tab
    Then can see sql query

  @common
  Scenario: Sorting, paging
    When login to ATLAS as QA
    When click to Cohort Definitions menu as QA
    Then can see Cohort Definition page
    When click New Cohort button
    Then can see new cohort page creation
    When enter name of New Cohort Definition and save it
    When click to close cohort button
    When click New Cohort button
    Then can see new cohort page creation
    When enter name of New Cohort Definition and save it
    When click to close cohort button
    When click New Cohort button
    Then can see new cohort page creation
    When enter name of New Cohort Definition and save it
    When click to close cohort button
    When click New Cohort button
    Then can see new cohort page creation
    When enter name of New Cohort Definition and save it
    When click to close cohort button
    When click New Cohort button
    Then can see new cohort page creation
    When enter name of New Cohort Definition and save it
    When click to close cohort button
    When click New Cohort button
    Then can see new cohort page creation
    When enter name of New Cohort Definition and save it
    When click to close cohort button
    When click New Cohort button
    Then can see new cohort page creation
    When enter name of New Cohort Definition and save it
    When click to close cohort button
    When click New Cohort button
    Then can see new cohort page creation
    When enter name of New Cohort Definition and save it
    When click to close cohort button
    When click New Cohort button
    Then can see new cohort page creation
    When enter name of New Cohort Definition and save it
    When click to close cohort button
    When click to Id column
    Then can see that first value less then second
    Then can see paging


