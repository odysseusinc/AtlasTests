@predictions
Feature: Check Prediction

  @common
  Scenario: Create, Edit, Delete predictions
    When login to ATLAS as QA
    When click to Prediction menu as QA
    Then can see Prediction page
    When click to New Patient Level Prediction
    Then can see creation page of Prediction
    When enter name on new Prediction
    When click to save Prediction Button
    Then can see new buttons in Prediction field
    When click to cancel button in Prediction
    When enter name of our Prediction in filter
    Then can see our Prediction in table
    When click to our Prediction
    Then can see our Prediction
    When enter new name of Prediction
    When click to save Prediction Button
    When click to cancel button in Prediction
    When enter name of new Prediction in filter
    Then can see new Prediction in table
    When click to new Prediction
    When click to delete Prediction button
    When accept delete Prediction alert
    Then cant find Prediction in table

  @2406 @odysseus
  Scenario: Check tabs in Prediction with execution engine
    When login to ATLAS as QA
    When click to Prediction menu as QA
    Then can see Prediction page
    When click to New Patient Level Prediction
    When click to Prediction Problem Settings tab
    Then can see Prediction Problem Settings page
    When click to Analysis Setting tab in Prediction
    Then can see Analysis Setting page in Prediction
    When click to Execution Setting tab in Prediction
    Then can see Execution Setting page in Prediction
    When click to Training Settings tab in Prediction
    Then can see Training Settings page in Prediction
    When click to Executions tab in Prediction
    Then can see Execution page in Prediction
    When click to Utilities page in Prediction
    Then can see Utilities page in Prediction

  @no_ee @ohdsi
  Scenario: Check tabs in Prediction without execution engine
    When login to ATLAS as QA
    When click to Prediction menu as QA
    Then can see Prediction page
    When click to New Patient Level Prediction
    When click to Prediction Problem Settings tab without ee
    Then can see Prediction Problem Settings page
    When click to Analysis Setting tab in Prediction
    Then can see Analysis Setting page in Prediction
    When click to Execution Setting tab in Prediction without ee
    Then can see Execution Setting page in Prediction
    When click to Training Settings tab in Prediction
    Then can see Training Settings page in Prediction
    When click to Utilities page in Prediction without ee
    Then can see Utilities page in Prediction

  @pr_dev @odysseus
  Scenario: Fill all fields as we can with execution engine
    When login to ATLAS as QA
    When click to Prediction menu as QA
    Then can see Prediction page
    When click to New Patient Level Prediction
    When enter new name of Prediction
    When click to save Prediction Button
    Then can see new buttons in Prediction field
    When click to add Target Cohort in Predictions
    Then can see cohort definition window in Predictions
    When enter "test" in filter in cohort definition window in Predictions
    When click to result in cohort in Predictions
    Then can see choosed cohort in Prediction Target table
    When click to add Outcome Cohort in Predictions
    Then can see cohort definition window in Predictions
    When enter "test" in filter in cohort definition window in Predictions
    When click to result in cohort in Predictions
    Then can see choosed cohort in Prediction Outcome table
    When click to Add Model Settings button
    Then can see Model Settings Page
    When click to return back button
    Then can see Row in Analysis Setting table
    When click to Add Covariate button
    Then can see Covariate Page
    When click to return back button
    Then can see Row in Covariate table
    When click to Add Population button
    Then can see Population Page
    When click to return back button
    Then can see Row in Population table
    When click to save Prediction Button
    When click to Utilities button in Prediction
    Then can see Review and Download table with selected target cohort

  @no_ee @ohdsi
  Scenario: Fill all fields as we can without execution engine
    When login to ATLAS as QA
    When click to Prediction menu as QA
    Then can see Prediction page
    When click to New Patient Level Prediction
    When enter new name of Prediction
    When click to save Prediction Button
    Then can see new buttons in Prediction field
    When click to add Target Cohort in Predictions
    Then can see cohort definition window in Predictions
    When enter "Celecoxib new users" in filter in cohort definition window in Predictions
    When click to result in cohort in Predictions
    Then can see choosed cohort in Prediction Target table
    When click to add Outcome Cohort in Predictions
    Then can see cohort definition window in Predictions
    When enter "GI bleed" in filter in cohort definition window in Predictions
    When click to result in cohort in Predictions
    Then can see choosed cohort in Prediction Outcome table
    When click to Add Model Settings button
    Then can see Model Settings Page
    When click to return back button
    Then can see Row in Analysis Setting table
    When click to Add Covariate button
    Then can see Covariate Page
    When click to return back button
    Then can see Row in Covariate table
    When click to Add Population button
    Then can see Population Page
    When click to return back button
    Then can see Row in Population table
    When click to save Prediction Button
    When click to Utilities button in Prediction without ee
    Then can see Review and Download table with selected target cohort

