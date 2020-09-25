@owndatatestsfromproperty
Feature: check own data

  @odysseus
  Scenario: choose profile from properties data
    When login to ATLAS as QA
    When click to "Profiles" menu item
    Then can see Profiles page
    When click to Select a Data Source
    When choose "profile" in Profile Source from property
    When enter 100 in Profile Id and press Enter
    Then can see overlay
    Then can see table

  @odysseus
  Scenario: Netezza CDM5.3 Source & Procedure from properties data
    When login to ATLAS as QA
    When click to Data Sources menu as user
    When Data Source Page opened
    When choose Source from Data Source as "source" from property
    When choose Report from Data Source as "report" from property
    Then can see Procedure windows
    When click to element in prevalence in table
    Then can see tables in Procedure for cell
