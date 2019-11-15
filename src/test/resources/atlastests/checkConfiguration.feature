@configuration
Feature: Check configuration

  @co
  Scenario: Open configuration page and check connection
    When login to ATLAS as QA
    When click to Configuration menu as QA
    Then Configuration page opens
    When Click to every datasource connection button
    Then Successful connection messages are visible

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
    When enter name of our role in filter
    Then can see our new name role in table
    When click to our new name role
    Then can see our role page
    When click delete button in role
    Then cant see our role in table