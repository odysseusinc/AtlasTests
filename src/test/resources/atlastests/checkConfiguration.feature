@configuration
Feature: Check configuration

  @co
  Scenario: Open configuration page and check connection
    When login to ATLAS as QA
    When click to Configuration menu as QA
    Then Configuration page opens
    When click to check connection button for Impala
    Then can see success message in button for Impala
    When click to check connection button for Netezza
    Then can see success message in button for Netezza
    When click to check connection button for OVH02
    Then can see success message in button for OVH02
    When click to check connection button for SynPUF 110K Cost and Util
    Then can see success message in button for SynPUF 110K Cost and Util
    When click to check connection button for SynPUF 110K GCP Big query
    Then can see success message in button for SynPUF 110K GCP Big query
    When click to check connection button for SynPUF 110K CDM5 3
    Then can see success message in button for SynPUF 110K CDM5 3
    When click to check connection button for SynPUF 2 3 GCP BigQuery
    Then can see success message in button for SynPUF 2 3 GCP BigQuery
    When click to check connection button for SynPUF 2M GCP BigQuery
    Then can see success message in button for SynPUF 2M GCP BigQuery
    When click to check connection button for SynPUF Geo
    Then can see success message in button for SynPUF Geo
    When click to check connection button for oracle 110k
    Then can see success message in button for oracle 110k

  Scenario: Create edit and delete role
    When login to ATLAS as QA
    When click to Configuration menu as QA
    Then Configuration page opens
    When click to Manage permission button
    Then can see Roles creation page
    When click to New role button
    Then can see new role creation page
    When enter new name of role
    When choose qa login from table
    When click to save button of new role
    When click to cancel button in roles
    When enter name of our role in filter
    Then can see our role in table
    When click to our role
    Then can see our role page
    When enter new name of our role
    When click to save button of new role
    When click to cancel button in roles
    Then can see our new name role in table
    When click to our new name role
    Then can see our role page
    When click delete button in role
    Then cant see our role in table