@conceptsets
Feature: Check Concept Sets


  Scenario: Create and delete new Concept set
    When login to ATLAS as QA
    When click to Concept Sets menu as QA
    Then Concept Sets page opens
    When click to New Concept Set
    Then can see Concept Set creation form
    When enter random name of Concept set and save it
    Then show new buttons in Concept Set
    When click to Concept Sets menu as QA
    Then new concept set shown in table
    When click to new concept set row
    When click to delete concept set
    When click to Concept Sets menu as QA
    Then new concept set removed from table


  Scenario: Create and add new items in new Concept Set
    When login to ATLAS as QA
    When click to Concept Sets menu as QA
    Then Concept Sets page opens
    When click to New Concept Set
    Then can see Concept Set creation form
    When enter random name of Concept set and save it
    Then show new buttons in Concept Set
    When click to Search menu as QA
    When enter in search panel "aspirin"
    When search activated
    Then can see search result table


  Scenario: compare value of Included Concepts
    When login to ATLAS as QA
    When click to Concept Sets menu as QA
    Then Concept Sets page opens
    When click to New Concept Set
    Then can see Concept Set creation form
    When enter random name of Concept set and save it
    Then show new buttons in Concept Set
    When click to Search menu as QA
    When enter in search panel "aspirin"
    When search activated
    Then can see search result table after conceptSet
    When click to shop cart items first
    When return to concept set by the link at the head of table
    Then can see item in the concept set table
    When save value of Included Concepts
    When set checkbox in Descendants
    Then can see other value of Included Concepts
  @dev
  Scenario: Check Included Concept table
    When login to ATLAS as QA
    When click to Concept Sets menu as QA
    Then Concept Sets page opens
    When click to New Concept Set
    Then can see Concept Set creation form
    When enter random name of Concept set and save it
    Then show new buttons in Concept Set
    When click to Search menu as QA
    When enter in search panel "aspirin"
    When search activated
    Then can see search result table
    When click to shop cart items first
    When return to concept set by the link at the head of table
    Then can see item in the concept set table
    When click to Included Concepts tab
    Then can see table of Included Concepts

  Scenario: Check Included concept codes table
    When login to ATLAS as QA
    When click to Concept Sets menu as QA
    Then Concept Sets page opens
    When click to New Concept Set
    Then can see Concept Set creation form
    When enter random name of Concept set and save it
    Then show new buttons in Concept Set
    When click to Search menu as QA
    When enter in search panel "aspirin"
    When search activated
    Then can see search result table
    When click to shop cart items first
    When return to concept set by the link at the head of table
    Then can see item in the concept set table
    When click to Included Source Codes tab
    Then can see table of Included Source codes

  Scenario: Check explore evidance tab in Concept Set
    When login to ATLAS as QA
    When click to Concept Sets menu as QA
    Then Concept Sets page opens
    When click to New Concept Set
    Then can see Concept Set creation form
    When enter random name of Concept set and save it
    Then show new buttons in Concept Set
    When click to Search menu as QA
    When enter in search panel "aspirin"
    When search activated
    Then can see search result table
    When click to shop cart items first
    When return to concept set by the link at the head of table
    Then can see item in the concept set table
    When click to Explore Evidence
    Then can see explore evidence text

  @pending
  Scenario: Check Export tab in Concept set
    When login to ATLAS as QA
    When click to Concept Sets menu as QA
    Then Concept Sets page opens
    When click to New Concept Set
    Then can see Concept Set creation form
    When enter random name of Concept set and save it
    Then show new buttons in Concept Set
    When click to Search menu as QA
    When enter in search panel "aspirin"
    When search activated
    Then can see search result table
    When click to shop cart items first
    When return to concept set by the link at the head of table
    Then can see item in the concept set table
    When click to Export tab in Concept set
    Then can see Concept Set JSON
    When click to export button
    # TODO FIX FILENAME
    Then csv file download



  @pending
  Scenario: Check compare concepts in Concept Set
    When login to ATLAS as QA
    When click to Concept Sets menu as QA
    Then Concept Sets page opens
    When click to New Concept Set
    Then can see Concept Set creation form
    When enter random name of Concept set and save it
    Then show new buttons in Concept Set
    When click to Search menu as QA
    When enter in search panel "aspirin"
    When search activated
    Then can see search result table
    When click to shop cart items first
    When return to concept set by the link at the head of table
    Then can see item in the concept set table
    When click to Compare tab in Concept Set


  Scenario: Create and add new items in new Concept Set and remove them
    When login to ATLAS as QA
    When click to Concept Sets menu as QA
    Then Concept Sets page opens
    When click to New Concept Set
    Then can see Concept Set creation form
    When enter random name of Concept set and save it
    Then show new buttons in Concept Set
    When click to Search menu as QA
    When enter in search panel "aspirin"
    When search activated
    Then can see search result table
    When click to shop cart items first
    When return to concept set by the link at the head of table
    Then can see item in the concept set table
    When click to shop cart items in concept set table
    Then can see message in Concept Set table "No data available in table"



