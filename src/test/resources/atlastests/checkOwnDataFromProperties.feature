@owndatatestsfromproperty
Feature: check own data

  @odysseus
  Scenario: Choose profile from properties data
    When login to ATLAS as QA
    When click to "Profiles" menu item
    Then can see Profiles page
    When click to Select a Data Source
    When choose "profile" in Profile Source from property
    When enter 100 in Profile Id and press Enter
    Then can see overlay
    Then can see table

  @odysseus
  Scenario: Source & Procedure from properties data
    When login to ATLAS as QA
    When click to "Data Sources" menu item
    When Data Source Page opened
    When choose Source from Data Source as "source" from property
    When choose Report from Data Source as "report" from property
    Then can see Procedure windows
    When click to element in prevalence in table
    Then can see tables in Procedure for cell
