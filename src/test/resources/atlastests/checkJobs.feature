@jobs
Feature: Check Jobs

  Scenario: Open job table
    When login to ATLAS as QA
    When click to Jobs menu as QA
    Then can see Jobs page
    Then can see job table with all fields
    When click to Column visibility button
    Then can see window with column names
    #have to change  line before cause I dont use param
    When click to "ExecutionId" button
    When click to free space
    Then cant see ExecutionId in table
    When click to CSV button in Jobs
    Then can see downloaded file


  Scenario: Search job
    When login to ATLAS as QA
    When click to Jobs menu as QA
    Then can see Jobs page
    Then can see job table with all fields
    When click to name of column
    Then can see that Id order was changed
    Then can see job table with all fields
    #change after
    When enter "Generating " in search filter
    Then can see our result in table

  @2308
#  Scenario: Get all jobs
#    When send post request to get all jobs
#    Then can see values in ID and Author fields

  Scenario: Feedback page
    When login to ATLAS as QA
    When click to Feedback menu as QA
    Then can see Feedback page
