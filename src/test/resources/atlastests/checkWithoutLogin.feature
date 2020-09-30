@unauthorized
Feature: Check permissions without login

    @common
    Scenario:  Homepage check
        When open project page
        Then check unauthorized user
        Then can see message at home menu "Welcome to ATLAS"
       

    @common
    Scenario:  Data Sources check
        When open project page
        Then check unauthorized user
        When click to "Data Sources" menu item
        Then The warning message is shown "This feature is protected. Please, "
       

    @common
    Scenario:  Search check
        When open project page
        Then check unauthorized user
        When click to "Search" menu item
        Then The warning message is shown "This feature is protected. Please, "
       

    @common
    Scenario:  Concept Sets check
        When open project page
        Then check unauthorized user
        When click to "Concept Sets" menu item
        Then The warning message is shown "This feature is protected. Please, "
       

    @common
    Scenario:  Cohort Pathways check
        When open project page
        Then check unauthorized user
        When click to "Cohort Pathways" menu item
        Then The warning message is shown "This feature is protected. Please, "
       

    @common
    Scenario:  Characterizations check
        When open project page
        Then check unauthorized user
        When click to "Characterizations" menu item
        Then The warning message is shown "This feature is protected. Please, "
       

    @common
    Scenario:  Cohort Definitions check
        When open project page
        Then check unauthorized user
        When click to "Cohort Definitions" menu item
        Then The warning message is shown "This feature is protected. Please, "
       

    @common
    Scenario:  Incidence Rates check
        When open project page
        Then check unauthorized user
        When click to "Incidence Rates" menu item
        Then The warning message is shown "This feature is protected. Please, "
       

    @common
    Scenario: Profiles check
        When open project page
        Then check unauthorized user
        When click to "Profiles" menu item
        Then The warning message is shown "This feature is protected. Please, "
       

    @common
    Scenario:  Estimation check
        When open project page
        Then check unauthorized user
        When click to "Estimation" menu item
        Then The warning message is shown "This feature is protected. Please, "
       

    @common
    Scenario: Prediction check
        When open project page
        Then check unauthorized user
        When click to "Prediction" menu item
        Then The warning message is shown "This feature is protected. Please, "
       

    @common
    Scenario:  Jobs check
        When open project page
        Then check unauthorized user
        When click to "Jobs" menu item
        Then The warning message is shown "This feature is protected. Please, "
       

    @common
    Scenario: Configuration check
        When open project page
        Then check unauthorized user
        When click to "Configuration" menu item
        Then The warning message is shown "This feature is protected. Please, "
       

