Feature: Check permissions without login

    Scenario:  Homepage check
        When open project page
        Then check unauthorized user
        Then can see message at home menu "Welcome to ATLAS"
        Then close browser


    Scenario:  Data Sources check
        When open project page
        Then check unauthorized user
        When click to Data Sources menu
        Then can see message "This feature is protected. Please, "
        Then close browser

    Scenario:  Search check
        When open project page
        Then check unauthorized user
        When click to Search menu
        Then can see message "This feature is protected. Please, "
        Then close browser

    Scenario:  Concept Sets check
        When open project page
        Then check unauthorized user
        When click to Concept Sets menu
        Then can see message "This feature is protected. Please, "
        Then close browser

    Scenario:  Cohort Pathways check
        When open project page
        Then check unauthorized user
        When click to Cohort Pathways menu
        Then can see message "This feature is protected. Please, "
        Then close browser

    Scenario:  Characterizations check
        When open project page
        Then check unauthorized user
        When click to Characterizations menu
        Then can see message "This feature is protected. Please, "
        Then close browser


    Scenario:  Cohort Definitions check
        When open project page
        Then check unauthorized user
        When click to Cohort Definitions menu
        Then can see message "This feature is protected. Please, "
        Then close browser

    Scenario:  Incidence Rates check
        When open project page
        Then check unauthorized user
        When click to Incidence Rates menu
        Then can see message "This feature is protected. Please, "
        Then close browser

    Scenario: Profiles check
        When open project page
        Then check unauthorized user
        When click to Profiles menu
        Then can see message "This feature is protected. Please, "
        Then close browser

    Scenario:  Estimation check
        When open project page
        Then check unauthorized user
        When click to Estimation menu
        Then can see message "This feature is protected. Please, "
        Then close browser

    Scenario: Prediction check
        When open project page
        Then check unauthorized user
        When click to Prediction menu
        Then can see message "This feature is protected. Please, "
        Then close browser

    Scenario:  Jobs check
        When open project page
        Then check unauthorized user
        When click to Jobs menu
        Then can see message "This feature is protected. Please, "
        Then close browser

    Scenario: Configuration check
        When open project page
        Then check unauthorized user
        When click to Configuration menu
        Then can see message "This feature is protected. Please, "
        Then close browser

