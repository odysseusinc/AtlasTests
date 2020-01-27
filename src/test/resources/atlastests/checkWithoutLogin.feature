@unauthorized
Feature: Check permissions without login

    @common
    Scenario:  Homepage check
        When open project page
        Then check unauthorized user
        Then can see message at home menu "Welcome to ATLAS"
        Then close browser

    @common
    Scenario:  Data Sources check
        When open project page
        Then check unauthorized user
        When click to Data Sources menu
        Then can see message "This feature is protected. Please, "
        Then close browser

    @common
    Scenario:  Search check
        When open project page
        Then check unauthorized user
        When click to Search menu
        Then can see message "This feature is protected. Please, "
        Then close browser

    @common
    Scenario:  Concept Sets check
        When open project page
        Then check unauthorized user
        When click to Concept Sets menu
        Then can see message "This feature is protected. Please, "
        Then close browser

    @common
    Scenario:  Cohort Pathways check
        When open project page
        Then check unauthorized user
        When click to Cohort Pathways menu
        Then can see message "This feature is protected. Please, "
        Then close browser

    @common
    Scenario:  Characterizations check
        When open project page
        Then check unauthorized user
        When click to Characterizations menu
        Then can see message "This feature is protected. Please, "
        Then close browser

    @common
    Scenario:  Cohort Definitions check
        When open project page
        Then check unauthorized user
        When click to Cohort Definitions menu
        Then can see message "This feature is protected. Please, "
        Then close browser

    @common
    Scenario:  Incidence Rates check
        When open project page
        Then check unauthorized user
        When click to Incidence Rates menu
        Then can see message "This feature is protected. Please, "
        Then close browser

    @common
    Scenario: Profiles check
        When open project page
        Then check unauthorized user
        When click to Profiles menu
        Then can see message "This feature is protected. Please, "
        Then close browser

    @common
    Scenario:  Estimation check
        When open project page
        Then check unauthorized user
        When click to Estimation menu
        Then can see message "This feature is protected. Please, "
        Then close browser

    @common
    Scenario: Prediction check
        When open project page
        Then check unauthorized user
        When click to Prediction menu
        Then can see message "This feature is protected. Please, "
        Then close browser

    @common
    Scenario:  Jobs check
        When open project page
        Then check unauthorized user
        When click to Jobs menu
        Then can see message "This feature is protected. Please, "
        Then close browser

    @common
    Scenario: Configuration check
        When open project page
        Then check unauthorized user
        When click to Configuration menu
        Then can see message "This feature is protected. Please, "
        Then close browser

