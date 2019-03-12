Feature: Search in Vocabularies

  Scenario: Search something
    When login to ATLAS as QA
    When click to Search menu
    When enter in search panel "aspirin"
    When search activated
    Then can see search result table
    When click to Column visibility
    When click to button Standard Concept Caption
    Then Standard Concept Caption should be shown

  Scenario: Sort values by ID
    When login to ATLAS as QA
    When click to Search menu
    When enter in search panel "aspirin"
    When search activated
    Then can see search result table
    When click to Id header
    Then first value more then second
    When click to Id header
    Then second value more then first


  Scenario: Filtering in Search
    When login to ATLAS as QA
    When click to Search menu
    When enter in search panel "aspirin"
    When search activated
    Then can see search result table
    When enter in filtering search area "SULFINPYRAZONE"
    Then can see search result only with "SULFINPYRAZONE"

  @dev
  Scenario: Downloading CSV in Search
    When login to ATLAS as QA
    When click to Search menu
    When enter in search panel "aspirin"
    When search activated
    Then can see search result table
    When enter in filtering search area "SULFINPYRAZONE"
    When click to CSV button









