@incidencerates
Feature: Incident rates check

  @common
  Scenario: Create IR, save, edit, create copy, delete
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
    When click to copy button for our IR
    When click to cancel button in Incidence rates
    When enter "COPY OF " and name of our IR
    Then can see copy of our IR
    When click to our incidence rate
    When click to delete IR button
    When accept delete IR alert
    When enter "COPY OF " and name of our IR
    Then cant find IR in table


  @common
  Scenario: Check tabs in IR
    When login to ATLAS as QA
    When click to Incidence Rates menu as QA
    Then can see Incidence Rates page
    When click to New Analysis button in Incidence Rates
    Then can see Incidence Rates creation page
    When enter name on new Incidence Rates
    When click to save Incidence Rates Button
    When click to "Concept Sets" tab in IR
    Then can see concept set page in IR
    When click to "Generation" tab in IR
    Then can see Generation page in IR
    When click to "Utilities" tab in IR
    Then can see Utilities page in IR


  @ohdsi
  Scenario: Create IR as GI Bleed across Celecoxib new users
    When login to ATLAS as QA
    When click to Incidence Rates menu as QA
    Then can see Incidence Rates page
    When click to New Analysis button in Incidence Rates
    Then can see Incidence Rates creation page
    When enter "Incidence of GI Bleed after Celecoxib initiation" name on new Incidence Rate
    When click to save Incidence Rates Button
    When click to add Target Cohort
    When enter "Celecoxib new users" in filter of cohort
    When click to result in IR
    When close Cohort window in IR
    Then can see "Celecoxib new users" Target Cohort
    When click to Add Outcome Cohort
    When enter "GI bleed" in filter of cohort
    When click to result in IR
    When close Cohort window in IR
    Then can see "bleed" Outcome Cohort
    When choose Time at risk starts with value 0
    When choose Time at risk ends with value 1095
    When click to save Incidence Rates Button
    When click to cancel button in Incidence rates
  
   
  @2406 @odysseus
  Scenario: Create IR as Angioedema across levetriacetam new users
    When login to ATLAS as QA
    When click to Incidence Rates menu as QA
    Then can see Incidence Rates page
    When click to New Analysis button in Incidence Rates
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
    When press Import Concept Set in IR
    When choose Import from Repository
    When enter "Angioedema" in filter Concept Set in IR
    When click to "Angioedema" in CS in IR
    Then can see chosen concept set in table: "Angioedema"

    @common
    Scenario: GI Bleed Celecoxib new users Export and Import
      When login to ATLAS as QA
      When click to Incidence Rates menu as QA
      Then can see Incidence Rates page
      When enter "Incidence of GI Bleed after Celecoxib initiation" in filter of cohort
      When click to result in IR
      When click to "Utilities" tab in IR
      When click to Export tab in IR
      When copy text from export textarea
      When click to cancel button in Incidence rates
      When click to New Analysis button in Incidence Rates
      When click to "Utilities" tab in IR
      When past json to IR textarea
      When click to import ir button
      Then can see Target cohort with "Celecoxib new users" value
