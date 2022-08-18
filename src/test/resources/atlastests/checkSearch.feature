@search
Feature: Search in Vocabularies

  @ss @common
  Scenario: Search something
    When login to ATLAS as QA
    When click to "Search" menu item
    When enter in search panel "aspirin"
    When search activated
    Then can see search result table
    When double click RC column
    Then can see not null values at first row in DC or RDC
    When click to Column visibility
    When click to button Standard Concept Caption
    Then Standard Concept Caption should be shown

  @common
  Scenario: Sort values by ID
    When login to ATLAS as QA
    When click to "Search" menu item
    When enter in search panel "aspirin"
    When search activated
    Then can see search result table
    When click to Id header
    Then first value more then second
    When click to Id header
    Then second value more then first

  @common
  Scenario: Filtering in Search
    When login to ATLAS as QA
    When click to "Search" menu item
    When enter in search panel "aspirin"
    When search activated
    Then can see search result table
    When enter in filtering search area "SULFINPYRAZONE"
    Then can see search result only with "SULFINPYRAZONE"

  @local @common
  Scenario: Downloading CSV in Search
    When login to ATLAS as QA
    When click to "Search" menu item
    When enter in search panel "aspirin"
    When search activated
    Then can see search result table
    When enter in filtering search area "SULFINPYRAZONE"
    When click to CSV button
    Then file download

  @0407 @common
  Scenario: Open the concept and check content of tabs
    When login to ATLAS as QA
    When click to "Search" menu item
    When enter in search panel "Acetaminophen 325 MG Oral Tablet by Accurex"
    When search activated
    When click to the name of standard concept
    Then page with concept fields is opened
    Then check Related Concepts tab
    Then check Hierarchy tab
    Then check Record Counts tab









