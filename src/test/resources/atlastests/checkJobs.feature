@jobs
Feature: Check Jobs

  @local @common
  Scenario: Open job table
    When login to ATLAS as QA
    When click to Jobs menu as QA
    Then can see Jobs page
    Then can see job table with all fields
    When click to Column visibility button
    Then can see window with column names
    When click to "ExecutionId" button
    When click to free space
    Then cant see ExecutionId in table
    When click to CSV button in Jobs
    Then can see downloaded file

  @common
  Scenario: Search job
    When login to ATLAS as QA
    When click to Jobs menu as QA
    Then can see Jobs page
    Then can see job table with all fields
    When click to name of column
    Then can see that Id order was changed
    #change after
    When enter "warming" in search filter
    Then can see our result in table

  @2406 @common
  Scenario: Feedback page
    When login to ATLAS as QA
    When click to Feedback menu as QA
    Then can see Feedback page
