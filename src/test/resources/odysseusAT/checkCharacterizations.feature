@characterization
  Feature: Characterization check


    Scenario: Create new characterization
      When login to ATLAS as QA
      When click to Characterizations menu as QA
      Then can see Charaterization page
