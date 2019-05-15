@estimations
Feature: check Estimation

  Scenario: Create, Edit, Delete estimate
    When login to ATLAS as QA
    When click to Estimation menu as QA
    Then can see Estimation page
    When click to New Population Level Effect Estimation
    Then can see creation page of Estimation
    When enter new name of Estimation
    When click to save New Estimation button
    Then can see buttons to Estimation
    When click to cancel button
    Then can see table with our Estimation
    When enter name of our estimation in filter
    Then can see name of new Estimation in table
    When click to Estimation in table
    Then can see our Estimation
    When change name of Estimation and press save
    When click to cancel button in Estimation
    Then can see new name of new Estimation in table
    When click to Estimation in table
    When click to delete our Estimation
    When accept delete Estimation
    Then cant see our Estimation in table


  Scenario: Check tabs in Estimation
    When login to ATLAS as QA
    When click to Estimation menu as QA
    Then can see Estimation page
    When click to New Population Level Effect Estimation
    When click to Comparisons tab
    Then can see comparision page
    When click to Analysis Setting tab
    Then can see Analysis Setting page
    When click to Evaluation Setting tab
    Then can see Evaluation Setting page
    When click to Executions tab in Estimation
    Then can see Execution page in Estimation
    When click to Utilities page in Estimation
    Then can see Utilities page in Estimation


  Scenario: Create full list of Estimation
    When login to ATLAS as QA
    When click to Estimation menu as QA
    Then can see Estimation page
    When click to New Population Level Effect Estimation
    Then can see creation page of Estimation
    When enter new name of Estimation
    When click to save New Estimation button
    When click to add Comparison
    Then can see Comparison inputs
    When click to open target cohort button
    Then can see Select Cohort window
    When enter "test" in Filter in Cohort window
    When click to result in CR in Cohort Window
    When click to open comparator cohort button
    Then can see Select Cohort window
    When enter "test" in Filter in Cohort window
    When click to result in CR in Cohort Window
    When click to Add Outcome button
    Then can see Select Cohort window
    When enter "test" in Filter in Cohort window
    When click to result in CR in Cohort Window
    Then can see choosed cohort in estimation outcome table
    When click to Open Concept window
    Then can see concept set window
    When enter "test" in concept set window
    When click to search result in concept set window
    When click back button to specification tab
      #devide
    When press Add Analysis Settings
    Then can see Analysis Setting page
    When Enter Study Start and end date
    When Enter include concept set in baseline covariates in the propensity score model
    Then can see concept set window
    When enter "test" in concept set window
    When click to search result in concept set window
    When Enter exclude concept set in baseline covariates in the propensity score model
    Then can see concept set window
    When enter "test" in concept set window
    When click to search result in concept set window
    When click to save New Estimation button



    #add test to utilites

