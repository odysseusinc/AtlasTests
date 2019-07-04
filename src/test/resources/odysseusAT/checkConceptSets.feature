@conceptsets
Feature: Check Concept Sets

  @ct1
  Scenario: Create, edit and delete new Concept set
    When login to ATLAS as QA
    When click to Concept Sets menu as QA
    Then Concept Sets page opens
    When click to New Concept Set
    Then can see Concept Set creation form
    When enter random name of Concept set and save it
    Then show new buttons in Concept Set
    When click to cancel button
    When enter name of concept set in filter
    Then new concept set shown in table
    When click to new concept set row
    Then can see our Concept Set creation form
    When enter new name of Concept Set
    Then click to save button in Concept Set
    Then click to cancel button in Concept Set
    When enter new concept set name in filter
    Then can see row with new name of concept set
    When click to row with new name of concept set
    Then can see our Concept Set creation form
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
    # TODO this later
    Then can see search result table after conceptSet
    #
    When click to shop cart items first
    When return to concept set by the link at the head of table
    Then can see item in the concept set table
    When save value of Included Concepts
    When set checkbox in Descendants
    Then can see other value of Included Concepts

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
    When press SAVE button
    When click to Export tab in Concept set
    Then can see Concept Set JSON
    Then click to export button



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
    Then can see text "Concept Set Comparison"


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

  #Have to create compare1 and compare2 concept sets with Hydrocarbons and
  #GFA FIRST AID 75 PERSON METAL CASE - benzalkonium chloride, benzalkonium chloride, lidocaine, bacitracin zinc,neomycin sulfate,polymyxin b sulfate, povidone-iodine,
  # water, alcohol, aspirin, ibuprofen, acetaminophen, benzocaine, alcohol kit AT COMARE 1
  #and
  #GFA FIRST AID 75 PERSON METAL CASE - benzalkonium chloride, benzalkonium chloride, lidocaine, bacitracin zinc,neomycin sulfate,polymyxin b sulfate, povidone-iodine,
  # water, alcohol, aspirin, ibuprofen, acetaminophen, benzocaine, alcohol kit
  # and desogestrel and ethinyl estradiol KIT [velivet triphasic regimen] AT COMPARE 2 test concept Sets

  @comp
  Scenario: Compare 2 concept sets test
    When login to ATLAS as QA
    When click to Concept Sets menu as QA
    Then Concept Sets page opens
    When enter "toCompare1" of concept set in filter
    When click concept set result
    Then can see our concept set page
    When click to Compare tab in Concept Set
    When click to select compare set2 button
    Then can see concept set window
    When enter "toCompare2" of concept set window in filter
    Then click to first link in list in concept set window
    When click to Compare Concept Sets button
    Then can see compare table
    Then can see results of comparison

    @opt
    Scenario: Check Optimization of concept set
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
      When set checkbox in Descendants
      When click to Search menu as QA
      When enter in search panel "Acetaminophen 325 MG Oral Tablet by Accurex"
      When search activated
#      Then can see search result table
      When click to shop cart items first
      When return to concept set by the link at the head of table
      When click to Optimize button
      Then can see Concept Set Optimization window
      When click to Save Options button
      When choose Overwrite Current Concept Set point
      Then can see only one concept in table of concept sets


