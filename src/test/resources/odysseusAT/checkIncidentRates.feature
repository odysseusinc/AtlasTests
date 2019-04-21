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
    When enter new name of oe incidence rate
    When click to save Incidence Rates Button
    Then can see name of our Incidence Rate
    When click to delete IR button
    When accept delete IR alert
    Then cant find IR in table


  Scenario: Check tabs in IR
    When login to ATLAS as QA
    When click to Incidence Rates menu as QA
    Then can see Incidence Rates creation page
    When enter name on new Incidence Rates
    When click to save Incidence Rates Button
    When click to Concept Sets tab
    Then can see concept set page
    When click to Concept Sets tab
    Then can see concept set page
    When click to Generation tab in IR
    Then can see Generation pagein IR
    When click to Utilities page in IR
    Then can see Utilities page in IR
