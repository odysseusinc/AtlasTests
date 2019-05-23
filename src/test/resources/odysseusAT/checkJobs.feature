Feature: Check Jobs

  Scenario: Open job table
    When login to ATLAS as QA
    When click to Jobs menu as QA
    Then can see Jobs page
    Then can see job table with all fields
    Then can see info at all columns
    When click to Column visibility button
    Then can see window with column names
    When click to "ExecutionId" button
    Then cant see ExecutionId in table
    When click to CSV button
    Then can see downloaded file
    When click to name of column
    Then can see that Id order was changed


  Scenario: Search job
    When login to ATLAS as QA
    When click to Jobs menu as QA
    Then can see Jobs page
    Then can see job table with all fields
    When enter "test" in search filter
    Then can see our result in table


  Scenario: Feedback page
    When login to ATLAS as QA
    When click to Feedback menu as QA
    Then can see Feedback page
